package com.jyw.student.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.StaffInfo;
import com.jyw.model.StudentInfo;
import com.jyw.model.StudentWriteGrade;
import com.jyw.model.StudentWriteGradeEx;
import com.jyw.student.service.CommunicateInfoService;
import com.jyw.student.service.StudentWriteGradeService;
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
 * Created by Administrator on 2016/11/21 .
 */
@Controller
@RequestMapping("/studentwritegrade/")
public class StudentwritegradeController {
@Autowired
private StudentWriteGradeService studentWriteGradeService;
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
    @RequestMapping("list.do")
    public String list(@RequestParam(required = false,defaultValue = "1") int pageNum, Map<String,Object> map , StaffInfo staffInfo, StudentWriteGradeEx studentWriteGradeEx)
    {
        studentWriteGradeEx.setStaffInfo(staffInfo);
        PageHelper.startPage(pageNum,10);
        List<StudentWriteGradeEx > studentWriteGradeExList= studentWriteGradeService.Getstudentwritegrade(studentWriteGradeEx);
        PageInfo page = new PageInfo(studentWriteGradeExList);
        map.put("swglist",studentWriteGradeExList);
        map.put("swg",studentWriteGradeEx);
        map.put("page",page);
        return "student/studentwritegrade/studentwritegrade_list";
    }
    @RequestMapping("loadadd.do")
    public String loadadd()
    {
        return "student/studentwritegrade/studentwritegrade_add";
    }
    @RequestMapping("add.do")
    public String add(StudentWriteGrade studentwritegrade_add,StaffInfo staffInfo)
    {
        studentwritegrade_add.setStaffId(staffInfo.getStaffId());
        studentWriteGradeService.insertSelective(studentwritegrade_add);
        return "redirect:/studentwritegrade/list.do";
    }
    @RequestMapping("loadupdate.do/{swgid}")
    public String loadupdate(@PathVariable("swgid")Integer Id,Map<String,Object> map)
    {
         StudentWriteGrade studentWriteGrade=studentWriteGradeService.selectByPrimaryKey(Id);
        map.put("swg",studentWriteGrade);
        return "student/studentwritegrade/studentwritegrade_update";
    }
    @RequestMapping("update.do")
    public String update(StudentWriteGrade studentWriteGrade)
    {
        studentWriteGradeService.updateByPrimaryKeySelective(studentWriteGrade);
        return "redirect:/studentwritegrade/list.do";
    }
    @RequestMapping("delete.do/{swgid}")
    public String delete(@PathVariable("swgid")Integer Id)
    {
        studentWriteGradeService.deleteByPrimaryKey(Id);
        return "redirect:/studentwritegrade/list.do";
    }
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
