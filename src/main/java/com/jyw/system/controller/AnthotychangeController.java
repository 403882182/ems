package com.jyw.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.*;
import com.jyw.system.dto.AnthortyDTO;
import com.jyw.system.service.AnthortyInfoService;
import com.jyw.system.service.RoleAnthorityInfoService;
import com.jyw.system.service.RoleInfoService;
import com.jyw.system.service.StaffInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/anthotychange")
public class AnthotychangeController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private RoleAnthorityInfoService roleAnthorityInfoService;
    @Autowired
    private AnthortyInfoService anthortyInfoService;
    @Autowired
    private StaffInfoService staffInfoService;
    /**
     * 查询角色信息
     * @param pageNum
     * @param roleInfo
     * @param map
     * @return
     */
    @RequestMapping("/list.do")
    public String list(@RequestParam(required = false,defaultValue = "1") int pageNum,
                       RoleInfo roleInfo, Map<String,Object> map){
        PageHelper.startPage(pageNum,10);
        RoleInfoCriteria criteria = new RoleInfoCriteria();
        //判断是否为空
        if(roleInfo!=null&&StringUtils.isNotEmpty(roleInfo.getRoleName())){
            criteria.or()
                    .andRoleNameLike("%" + roleInfo.getRoleName() + "%");
        }
        //分页

        //查询所有角色信息
        List<RoleInfo> list = roleInfoService.selectByExample(criteria);
        //存入分页类中
        PageInfo page = new PageInfo(list);
        //存入
        map.put("page",page);

        return "/system/anthotychange/anthorty_changelist";
    }

    @RequestMapping("/changeAuth.do")
    public @ResponseBody String changeAnth(Integer roleId,Integer[] anthortyId){
        boolean con = true;
        try{
            //设置查询条件
            RoleAnthorityInfoCriteria criteria = new RoleAnthorityInfoCriteria();
            criteria.or()
                    .andRoleIdEqualTo(roleId);
            //获取拥有的权限集合
            List<RoleAnthorityInfo> raiList = roleAnthorityInfoService.selectByExample(criteria);
            //所拥有的权限id集合
            List<Integer> list = new ArrayList<>();

            if(anthortyId != null && anthortyId.length > 0){
                //排序
                Arrays.sort(anthortyId);
                //遍历-添加
                for (Integer id:anthortyId){
                    if(!list.contains(id)){
                        //添加该权限
                        RoleAnthorityInfo rai = new RoleAnthorityInfo();
                        rai.setRoleId(roleId);
                        rai.setAnthortyId(id);
                        roleAnthorityInfoService.insert(rai);
                    }
                }
            }

            //遍历-删除
            for (RoleAnthorityInfo rai:raiList){
                //获取权限id
                list.add(rai.getAnthortyId());
                if(anthortyId != null && anthortyId.length > 0) {
                    //判断是否包含这个权限
                    int i = Arrays.binarySearch(anthortyId, rai.getAnthortyId());
                    if (i < 0) {//不包含
                        //删除该权限
                        roleAnthorityInfoService.deleteByPrimaryKey(rai.getRoleAnthorityId());
                    }
                }else{
                    //删除全部权限
                    roleAnthorityInfoService.deleteByPrimaryKey(rai.getRoleAnthorityId());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            con = false;
        }

        if(con)
            return "权限变更成功!";
        else
            return "权限变更失败!";
    }


    /**
     * 加载权限资格
     * @param roleId
     * @param map
     * @return
     */
    @RequestMapping("load.do")
    public String load(Integer roleId,Map<String,Object> map){
        //设置查询条件
        RoleAnthorityInfoCriteria criteria = new RoleAnthorityInfoCriteria();
        criteria.or()
                .andRoleIdEqualTo(roleId);
        //获取拥有的权限集合
        List<RoleAnthorityInfo> raiList = roleAnthorityInfoService.selectByExample(criteria);
        //获取所有权限
        List<AnthortyInfo> aiList = anthortyInfoService.selectByExample(new AnthortyInfoCriteria());
        //创建菜单集合
        List<AnthortyDTO> dtoList = new ArrayList<>();
        //遍历所有权限
        for (AnthortyInfo ai:aiList) {
            //创建一级菜单
            if(ai != null && ai.getAnthortyPid() == 1){
                //创建菜单对象
                AnthortyDTO dto = new AnthortyDTO();
                //拥有的权限不为0
                if(raiList != null && raiList.size() > 0){
                    //遍历拥有的权限
                    for (RoleAnthorityInfo rai:raiList) {
                        //判断是否拥有一级菜单权限
                        if(ai.getAnthortyId() == rai.getAnthortyId()){
                            ai.setChecked(true);
                        }
                    }
                }
                dto.setAnth(ai);//构建一级菜单

                //创建子菜单集合
                List<AnthortyInfo> sublist = new ArrayList<>();
                //构建子菜单
                getAnthorty(raiList,sublist,aiList,ai.getAnthortyId());
                //把子菜单存入对应的一级菜单中
                dto.setList(sublist);
                //存入菜单集合中
                dtoList.add(dto);
            }
        }
        //获取角色信息
        RoleInfo roleInfo = roleInfoService.selectByPrimaryKey(roleId);

        map.put("roleinfo", roleInfo);
        map.put("dtolist",dtoList);

        return "/system/anthotychange/anthorty_change";
    }

    /**
     * 构建子菜单
     * @param raiList
     * @param sublist
     * @param aiList
     * @param anthortyId
     */
    public void getAnthorty(List<RoleAnthorityInfo> raiList,List<AnthortyInfo> sublist,
                            List<AnthortyInfo> aiList, Integer anthortyId) {

        for (AnthortyInfo ai:aiList) {
            //判断所有权限中属于该权限的子权限
            if(ai.getAnthortyPid() == anthortyId){
                //遍历拥有的权限集合
                for (RoleAnthorityInfo rai:raiList){
                    //判断是否拥有该权限
                    if(rai.getAnthortyId() == ai.getAnthortyId()){
                        ai.setChecked(true);
                    }
                }
                //存入子菜单中
                sublist.add(ai);
                //继续构建此菜单的子菜单
                getAnthorty(raiList,sublist,aiList,ai.getAnthortyId());
            }
        }
    }
}
