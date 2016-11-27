package com.jyw.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.StaffInfo;
import com.jyw.system.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by rayya on 2016/11/9.
 */
@Controller
@RequestMapping("/system")
public class StaffInfoController {
    @Autowired
    private StaffInfoService staffInfoService;

    /**
     * 获取员工列表
     * @param staffInfo
     * @param map
     * @return
     */
    @RequestMapping(value = "/list.do",method = RequestMethod.GET)
    public String getStaffList(StaffInfo staffInfo,ModelMap map,@RequestParam(required = false,defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum,10);
        List<StaffInfo> list = staffInfoService.getStaffList(staffInfo);
        PageInfo page = new PageInfo(list);
        //存入
        map.put("page",page);
        return "system/staffinfo/staffinfo_list";
    }

    /**
     * 通过条件进行查询员工信息
     * 20161127,可通过编号和手机查询——通过姓名查询结果都为空
     * @param staffInfo
     * @param map
     * @return
     */
    @RequestMapping(value = "/query.do",method = RequestMethod.POST)
    public String query(StaffInfo staffInfo,ModelMap map,@RequestParam(required = false,defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum,10);
        List<StaffInfo> list = staffInfoService.getStaffList(staffInfo);
        PageInfo page = new PageInfo(list);
        //存入
        map.put("page",page);
        return "system/staffinfo/staffinfo_list";
    }

    //2016.11.27添加员工仍然失败
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public String addStaffInfo(StaffInfo staffInfo, ModelMap map){
        int count=staffInfoService.insertSelective(staffInfo);
        if(count>0){
            map.addAttribute("info","添加成功");
        }
        else{
            map.addAttribute("info","添加失败");
        }
        return this.getStaffList(null,map,1);
    }

    /**
     * 可以正常跳转到编辑页面
     * @param staffId
     * @param map
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String updateStaffInfo(@PathVariable("id") Integer staffId,ModelMap map){
        StaffInfo staff=staffInfoService.selectByPrimaryKey(staffId);
        map.addAttribute("staffInfo",staff);
        return "system/staffinfo/staffinfo_update";
    }

    //20161127提交修改失败
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    public String updateStaffInfo(StaffInfo staffInfo,ModelMap map){
        staffInfoService.updateByPrimaryKey(staffInfo);
        return this.getStaffList(null,map,1);
    }

    /**
     * 通过id实现删除员工，在创建数据库的时候创建on delete cascade级联删除
     * @param staffId
     * @param map
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteStaffInfo(@PathVariable("id") Integer staffId,ModelMap map){
        StaffInfo staff=staffInfoService.selectByPrimaryKey(staffId);
        staff.setStaffState("0");
        int count=staffInfoService.deleteByPrimaryKey(staffId);
        if(count>0){
            map.addAttribute("info","删除成功");
        }else{
            map.addAttribute("info","删除失败");
        }
        return this.getStaffList(null,map,1);
    }

    /**
     * 通过id获取员工详情页面
     * @param staffId
     * @param map
     * @return
     */
    @RequestMapping(value = "/show/{id}",method = RequestMethod.GET)
    public String getStaffDetail(@PathVariable("id") Integer staffId,ModelMap map){
        StaffInfo staff=staffInfoService.selectByPrimaryKey(staffId);
        map.addAttribute("staffInfo",staff);
        return "system/staffinfo/staffinfo_show";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
