package com.jyw.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.RoleInfo;
import com.jyw.model.StaffInfo;
import com.jyw.system.service.RoleInfoService;
import com.jyw.system.service.StaffInfoService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by rayya on 2016/11/9.
 */
@Controller
@RequestMapping("/roleinfo")
public class RoleInfoController {
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private StaffInfoService staffInfoService;
    /**
     * 角色管理页面
     * 查询角色信息
     * @return
     */
    @RequestMapping(value = "/list.do",method = RequestMethod.GET)
    public String getRoleList(RoleInfo roleInfo, ModelMap map,@RequestParam(required = false,defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum,10);
        List<RoleInfo> list=roleInfoService.getRoleInfoList(roleInfo);
        PageInfo page = new PageInfo(list);
        //存入
        map.put("page",page);
        return "system/roleinfo/roleinfo_list";
    }

    /**
     * form表单提交post对应的动作方法
     * @version 1.0 by rayya 同样是无法通过角色名进行查询，结果均为空
     * @param roleInfo
     * @param map
     * @return
     */
    @RequestMapping(value = "/query.do",method = RequestMethod.POST)
    public String query(RoleInfo roleInfo, ModelMap map,@RequestParam(required = false,defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum,10);
        List<RoleInfo> list=roleInfoService.getRoleInfoList(roleInfo);
        PageInfo page = new PageInfo(list);
        //存入
        map.put("page",page);
        return "system/roleinfo/roleinfo_list";
    }

    /**
     * 角色变更页面
     * @param staff
     * @param map
     * @return
     */
    @RequestMapping("/staffinforolelist.do")
    public String staffInfoRoleList(StaffInfo staff, ModelMap map,@RequestParam(required = false,defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<StaffInfo> list = staffInfoService.getStaffList(staff);
        PageInfo page = new PageInfo(list);
        //存入
        map.put("page",page);
        return "system/roleinfo/staffinfo_role_list";
    }

    /**
     * @version 1.0 By rayya——20161127
     * 显示添加成功，结果为乱码
     * @param roleInfo
     * @param map
     * @return
     */
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public String addRoleInfo(RoleInfo roleInfo,ModelMap map){
        int count=roleInfoService.insertSelective(roleInfo);
        if(count>0){
            map.addAttribute("info","添加成功");
        }else{
            map.addAttribute("info","添加失败");
        }
        return this.getRoleList(null,map,1);
    }

    /**
     * @version 1.0 by rayya 未能删除——20161127
     * @param roleId
     * @param map
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteRoleInfo(@PathVariable("id") Integer roleId,ModelMap map){
        RoleInfo roleInfo=roleInfoService.selectByPrimaryKey(roleId);
        roleInfo.setRoleState("0");
        int count=roleInfoService.deleteByPrimaryKey(roleId);
        if(count>0){
            map.addAttribute("info","删除成功");
        }else{
            map.addAttribute("info","删除失败");
        }
        return this.getRoleList(null,map,1);
    }

    /**
     * 单纯跳转到编辑页面
     * @param roleId
     * @param map
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String updateRoleInfo(@PathVariable("id") Integer roleId,ModelMap map){
        RoleInfo roleInfo=roleInfoService.selectByPrimaryKey(roleId);
        map.addAttribute("roleInfo",roleInfo);
        return "system/roleinfo/roleinfo_update";
    }

    /**
     *
     * @param roleInfo
     * @param map
     * @return
     */
    @RequestMapping(value = "/update.do")
    public String updateRole(RoleInfo roleInfo,ModelMap map){
        int count=roleInfoService.updateByPrimaryKeySelective(roleInfo);
        if(count>0){
            map.addAttribute("info","修改成功");
        }else {
            map.addAttribute("info","修改失败");
        }
        return this.getRoleList(null,map,1);
    }


    @RequestMapping(value = "/roleChange/{id}",method = RequestMethod.GET)
    public String roleChange(@PathVariable("id") Integer staffId,ModelMap map){
        StaffInfo staff=staffInfoService.selectByPrimaryKey(staffId);
        List<RoleInfo> list=roleInfoService.getRoleInfoList(new RoleInfo());
        map.addAttribute("roleList",list);
        map.addAttribute("staffInfo",staff);

        return "system/roleinfo/roleinfo_change";
    }

    @RequestMapping(value = "/show/{id}",method = RequestMethod.GET)
    public String getStaffDetail(@PathVariable("id") Integer staffId,ModelMap map){
        StaffInfo staff=staffInfoService.selectByPrimaryKey(staffId);
        map.addAttribute("staffInfo",staff);
        return "system/staffinfo/staffinfo_show";
    }


    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    public String updateStaffInfo(StaffInfo staffInfo,ModelMap map){
        staffInfoService.updateByPrimaryKey(staffInfo);
        return this.staffInfoRoleList(null,map,1);
    }
}
