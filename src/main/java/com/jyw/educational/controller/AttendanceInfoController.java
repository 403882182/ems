package com.jyw.educational.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.*;
import com.jyw.recruitstudent.service.StudentInfoService;
import com.jyw.system.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import com.jyw.educational.service.AttendanceInfoService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by john on 2016/11/12.
 * 查询所有考勤信息
 */
@Controller
@RequestMapping("/attendanceinfo")
@SessionAttributes("staff")
public class AttendanceInfoController {
    @Autowired
    private AttendanceInfoService attendanceInfoService;
    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/list.do")
    public String selectAttendance(String studentName, Model model,
                                   @RequestParam(required = false,defaultValue = "1") int pageNum,
                                   @ModelAttribute("staff") StaffInfo staffInfo) {
        PageHelper.startPage(pageNum,10);
        if(studentName!=null) {
            studentName = "%" + studentName + "%";
        }else{
            studentName = "%%";
        }
        List<AttendanceInfo> list = attendanceInfoService.selectAttendance(studentName,staffInfo.getStaffId());
        PageInfo page = new PageInfo(list);
        model.addAttribute("page", page);

        return "educational/attendanceinfo/attendanceinfo_list";
    }

    /*所有学生信息*/
    private List<StudentInfo> stulist;

    public List<StudentInfo> getStulist() {
        return stulist;
    }

    public void setStulist(List<StudentInfo> stulist) {
        this.stulist = stulist;
    }

    /**
     * 查询学员表中所有学员姓名
     */
    @RequestMapping("/selectStudent")
    public String selectStudent(Model model,@ModelAttribute("staff") StaffInfo staffInfo) {
        StudentInfoCriteria sic=new StudentInfoCriteria();
        sic.or().andStaffIdEqualTo(staffInfo.getStaffId());
        stulist = studentInfoService.selectByExample(sic);
        model.addAttribute("stulist", stulist);

        return "educational/attendanceinfo/attendanceinfo_add";
    }

    /**
     * 添加考勤信息
     * @param record
     * @return
     */
    @RequestMapping("/insert")
    public String insert(AttendanceInfo record, Model model,@ModelAttribute("staff") StaffInfo staffInfo) {
        int no = attendanceInfoService.insert(record);

        if (no > 0) {
            model.addAttribute("info", "添加成功");
        } else {
            model.addAttribute("info", "添加失败");

        }
        return selectAttendance("", model,1,staffInfo);
    }

    /**
     * 修改考勤
     * @param
     */
    @RequestMapping("/updatePage")
    public String updatePage(int attendanceId, Model model,@ModelAttribute("staff") StaffInfo staffInfo) {
        StudentInfoCriteria sic=new StudentInfoCriteria();
        sic.or().andStaffIdEqualTo(staffInfo.getStaffId());
        stulist = studentInfoService.selectByExample(sic);

        AttendanceInfo attendance=attendanceInfoService.selectByPrimaryKey(attendanceId);
        model.addAttribute("attendance", attendance);
        model.addAttribute("stulist", stulist);
        model.addAttribute("attendanceId", attendanceId);

        return "educational/attendanceinfo/attendanceinfo_update";
    }

    @RequestMapping("updateByPrimaryKey")
    public String updateByPrimaryKey(AttendanceInfo record, Model model,@ModelAttribute("staff") StaffInfo staffInfo){
        int no = attendanceInfoService.updateByPrimaryKey(record);

        if (no > 0) {
            model.addAttribute("info", "修改成功");
        } else {
            model.addAttribute("info", "修改失败");

        }
            return selectAttendance("", model,1,staffInfo);
}

    /**
     * 根据id删除考勤
     * @param attendanceId
     * @param model
     * @return
     */
    @RequestMapping("deleteByPrimaryKey")
    public String deleteByPrimaryKey(Integer attendanceId,Model model,@ModelAttribute("staff") StaffInfo staffInfo){
        int row=attendanceInfoService.deleteByPrimaryKey(attendanceId);
        if(row>0){
            model.addAttribute("info","删除成功");
         }else {

            model.addAttribute("info","删除失败");
        }

        return selectAttendance("",model,1,staffInfo);
    }

    /**
     * 日期转换
     * @param bin
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder  bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}



