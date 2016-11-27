package com.jyw.student.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.EvaluationInfo;
import com.jyw.model.EvaluationInfoEx;
import com.jyw.model.StaffInfo;
import com.jyw.model.StudentInfo;
import com.jyw.student.service.CommunicateInfoService;
import com.jyw.student.service.EvaluationInfoService;
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
 * Created by Administrator on 2016/11/13 .
 */
@Controller
@RequestMapping(value = "/evaluationinfo/")
public class EvaluationInfoController {
    @Autowired
    private EvaluationInfoService evaluationInfoService;
    @Autowired
    private CommunicateInfoService communicateInfoService;
    @ModelAttribute
    public void getLoginer(Map<String,Object> map,HttpSession session) {
        StaffInfo staffInfo=(StaffInfo)session.getAttribute("staff");

        List<StudentInfo> studentInfoList= communicateInfoService.GetStdentBystaffId(staffInfo.getStaffId());
        map.put("stulist",studentInfoList);
        map.put("staffInfo",staffInfo);
    }
    @RequestMapping(value = "list.do")
    public String list(@RequestParam(required = false,defaultValue = "1") int pageNum, StaffInfo staffInfo, EvaluationInfoEx evaluationInfoEx, Map<String,Object> map)
    {
        PageHelper.startPage(pageNum,10);
        if(evaluationInfoEx.getStudentInfo()==null) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStaffId(staffInfo.getStaffId());
            evaluationInfoEx.setStudentInfo(studentInfo);
        }
        StudentInfo si=new StudentInfo();
        si.setStaffId(staffInfo.getStaffId());
        evaluationInfoEx.setStudentInfo(si);
        List<EvaluationInfoEx> evaluationInfoices=evaluationInfoService.selectAllEvaluation(evaluationInfoEx);
        PageInfo page = new PageInfo(evaluationInfoices);
        map.put("page",page);
        map.put("evaluationInfoices",evaluationInfoices);
        map.put("evaluationInfoEx",evaluationInfoEx);
        return "student/evaluationinfo/evaluationinfo_list";
    }
    @RequestMapping("loadadd.do")
    public String loadadd()
    {
        return "student/evaluationinfo/evaluationinfo_add";
    }
    @RequestMapping("add.do")
    public String add(EvaluationInfo evaluationInfo,StaffInfo staffInfo)
    {
        evaluationInfoService.insertSelective(evaluationInfo);
        return "redirect:/evaluationinfo/list.do";
    }
    @RequestMapping("loadupdate.do/{evid}")
    public  String loadupdate(@PathVariable("evid") Integer id,Map<String,Object> map)
    {

        EvaluationInfo evaluationInfo= evaluationInfoService.selectByPrimaryKey(id);
        map.put("evaluation",evaluationInfo);
        return "student/evaluationinfo/evaluationinfo_update";
    }
    @RequestMapping("update.do")
    public String update(EvaluationInfo evaluationInfo)
    {
        evaluationInfoService.updateByPrimaryKey(evaluationInfo);
        return "redirect:/evaluationinfo/list.do";
    }
    @RequestMapping("delete.do/{evid}")
    public String delete(@PathVariable("evid") Integer id)
    {
        evaluationInfoService.deleteByPrimaryKey(id);
        return "redirect:/evaluationinfo/list.do";
    }
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
