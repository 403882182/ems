package com.jyw.system.controller;

import com.jyw.model.AnthortyInfo;
import com.jyw.model.AnthortyInfoCriteria;
import com.jyw.model.RoleAnthorityInfo;
import com.jyw.model.RoleAnthorityInfoCriteria;
import com.jyw.system.service.AnthortyInfoService;
import com.jyw.system.service.RoleAnthorityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/anthorty")
public class AnthortyInfoController {

    @Autowired
    private AnthortyInfoService anthortyInfoService;
    @Autowired
    private RoleAnthorityInfoService roleAnthorityInfoService;

    /**
     *查询所有权限信息
     * @param map
     * @return
     */
    @RequestMapping("/list.do")
    public String list(Map<String,Object> map){
        //查询所有权限
        List<AnthortyInfo> list = anthortyInfoService.selectByExample(new AnthortyInfoCriteria());

        map.put("list", list);

        return "system/anthorty/anthorty_list";
    }

    /**
     * 查询权限信息
     * @param anthortyId
     * @param map
     * @return
     */
    @RequestMapping("/show.do")
    public String show(Integer anthortyId,Map<String,Object> map){
        if(anthortyId != 1) {
            //根据主键查询该权限信息
            AnthortyInfo anth = anthortyInfoService.selectByPrimaryKey(anthortyId);

            //获取上级权限
            AnthortyInfoCriteria criteria = new AnthortyInfoCriteria();
            criteria.or()
                    .andAnthortyIdEqualTo(anth.getAnthortyPid());
            String panthortyName = anthortyInfoService.selectByExample(criteria).get(0).getAnthortyName();

            map.put("anth", anth);
            map.put("panthortyName", panthortyName);
        }
        return "system/anthorty/anthorty_show";
    }

    /**
     * 加载添加权限
     * @param anthortyId
     * @param map
     * @return
     */
    @RequestMapping("/loadAdd.do")
    public String loadAdd(Integer anthortyId,Map<String,Object> map){
        //查询所有权限
        List<AnthortyInfo> list = anthortyInfoService.selectByExample(new AnthortyInfoCriteria());
        //获取一级目录
        List<Integer> idList = new ArrayList<>();
        for (AnthortyInfo anth:list){
            if(anth.getAnthortyPid() == 1){
                idList.add(anth.getAnthortyId());
            }
        }

        map.put("list",list);
        map.put("idList", idList);
        map.put("anthortyId",anthortyId);

        return "system/anthorty/anthorty_add";
    }

    /**
     * 添加权限
     * @param anthor
     * @return
     */
    @RequestMapping("/add.do")
    public @ResponseBody Map<String,Object> add(AnthortyInfo anthor){
        Map<String,Object> map = new HashMap<>();
        //更改权限
        int count = anthortyInfoService.insertSelective(anthor);
        if(count > 0){
            //查询所有权限
            List<AnthortyInfo> list = anthortyInfoService.selectByExample(new AnthortyInfoCriteria());
            map.put("list", list);
            map.put("message","权限信息添加成功!");
            map.put("state",true);
        }else{
            map.put("message","权限信息添加失败!");
            map.put("state",false);
        }
        return map;
    }

    /**
     * 加载修改权限
     * @param anthortyId
     * @param map
     * @return
     */
    @RequestMapping("/loadUpdate.do")
    public String loadUpdate(Integer anthortyId,Map<String,Object> map){
        //查询所有权限
        List<AnthortyInfo> list = anthortyInfoService.selectByExample(new AnthortyInfoCriteria());
        //根据主键查询该权限信息
        AnthortyInfo anth = anthortyInfoService.selectByPrimaryKey(anthortyId);

        map.put("list", list);
        map.put("anth", anth);

        return "system/anthorty/anthorty_update";
    }

    /**
     * 修改权限
     * @param anthor
     * @return
     */
    @RequestMapping("/update.do")
    public @ResponseBody Map<String,Object> update(AnthortyInfo anthor){
        Map<String, Object> map = new HashMap<>();
        //更新
        int count = anthortyInfoService.updateByPrimaryKeySelective(anthor);
        if(count > 0){
            //查询所有权限
            List<AnthortyInfo> authList = anthortyInfoService.selectByExample(new AnthortyInfoCriteria());
            map.put("list", authList);
            map.put("message", "权限信息修改成功!");
            map.put("state",true);
        }else{
            map.put("message", "权限信息修改失败!");
            map.put("state",false);
        }
        return map;
    }

    /**
     * 根据 ID 删除权限
     * @param anthortyId
     * @return
     */
    @RequestMapping("/delete.do")
    public @ResponseBody Map<String,Object> delete(Integer anthortyId) {
        Map<String, Object> map = new HashMap<>();
        //判断是否有子节点
        AnthortyInfoCriteria criteria = new AnthortyInfoCriteria();
        criteria.or()
                .andAnthortyPidEqualTo(anthortyId);
        List<AnthortyInfo> list = anthortyInfoService.selectByExample(criteria);
        if (list != null && list.size() > 0) {
            map.put("message", "请先删除下级菜单!");
            map.put("state",false);
            return map;
        }
        //判断此权限是否还有依赖
        List<RoleAnthorityInfo> roleAnthorityInfoList = roleAnthorityInfoService.selectByExample(new RoleAnthorityInfoCriteria());
        for (RoleAnthorityInfo item:roleAnthorityInfoList){
            if(item.getAnthortyId() == anthortyId){
                map.put("message", "还有角色拥有此权限，请先解除!");
                map.put("state",false);
                return map;
            }
        }
        //删除权限
        int count = anthortyInfoService.deleteByPrimaryKey(anthortyId);
        if (count > 0) {
            //查询所有权限
            List<AnthortyInfo> authList = anthortyInfoService.selectByExample(new AnthortyInfoCriteria());
            map.put("list", authList);
            map.put("message", "权限信息删除成功!");
            map.put("state",true);
        } else {
            map.put("message", "权限信息删除失败!");
            map.put("state",false);
        }
        return map;
    }
}
