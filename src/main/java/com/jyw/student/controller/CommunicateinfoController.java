package com.jyw.student.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.*;
import com.jyw.student.service.CommunicateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/12 .
 */
@Controller
@RequestMapping( value ="communicateinfo")
public class CommunicateinfoController {
    @Autowired
    private CommunicateInfoService communicateInfoService;
    @ModelAttribute
    public void getLoginer(Map<String,Object> map,HttpSession session)
    {
        StaffInfo staffInfo=(StaffInfo)session.getAttribute("staff");

        List<StudentInfo> studentInfoList= communicateInfoService.GetStdentBystaffId(staffInfo.getStaffId());
        map.put("stulist",studentInfoList);
        map.put("staffInfo",staffInfo);
    }
    @RequestMapping(value = "list.do")
    public String listdo(@RequestParam(required = false,defaultValue = "1") int pageNum
            ,StaffInfo staffInfo , Map<String,Object> map, CommunicateInfoEx communicateInfoEx)
    {    PageHelper.startPage(pageNum,10);
        communicateInfoEx.setStaffInfo(staffInfo);
        List<CommunicateInfoEx> communicateInfoExList=communicateInfoService.selectAllCommunicateInfo(communicateInfoEx);
        PageInfo page = new PageInfo(communicateInfoExList);
        map.put("page",page);
        map.put("communicateInfo",communicateInfoEx);
        map.put("communicateInfoExList",communicateInfoExList);
        return "student/communicateinfo/communicateinfo_list";
    }
    @RequestMapping("loadadd.do")
    public String loadadd(Map<String,Object> map,StaffInfo staffInfo)
    {
        return "student/communicateinfo/communicateinfo_add";
    }
    @RequestMapping("add.do")
    public String add(CommunicateInfo communicateInfo,StaffInfo staffInfo)
    {   communicateInfo.setStaffId(staffInfo.getStaffId());
        communicateInfoService.insertSelective(communicateInfo);
        return "redirect:/communicateinfo/list.do";
    }
    @RequestMapping("loadupdate.do/{comid}")
    public  String loadUpdate(@PathVariable("comid") Integer id,Map<String,Object> map)
    {
        CommunicateInfo communicateInfo=communicateInfoService.selectByPrimaryKey(id);
        map.put("commum",communicateInfo);
        return  "student/communicateinfo/communicateinfo_update";
    }
    @RequestMapping(value = "update.do")
    public  String update(CommunicateInfo communicateInfo)
    {
        communicateInfoService.updateByPrimaryKeySelective(communicateInfo);
        return "redirect:/communicateinfo/list.do";
    }
    @RequestMapping(value = "delete.do/{comid}")
    public String delete(@PathVariable("comid") Integer id)
    {
        communicateInfoService.deleteByPrimaryKey(id);
        return "redirect:/communicateinfo/list.do";
    }
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
