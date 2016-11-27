package com.jyw.student.controller;

import com.jyw.finance.service.StudentPaymentService;
import com.jyw.model.*;
import com.jyw.recruitstudent.service.StudentInfoService;
import com.jyw.student.service.EvaluationInfoService;
import com.jyw.student.service.StudentWriteGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/23 .
 */
@RequestMapping(value = {"studentphone","studentscore"})
@Controller
public class StudentPhoneController {
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private EvaluationInfoService evaluationInfoService;
    @Autowired
    private StudentPaymentService studentPaymentService;
    @Autowired
    private StudentWriteGradeService studentWriteGradeService;
    @RequestMapping(value = "login.do")
    public String loging(StudentInfo studentInfo, HttpSession session)
    {
        StudentInfoCriteria studentInfoCriteria=new StudentInfoCriteria();
        StudentInfoCriteria.Criteria criteria=studentInfoCriteria.createCriteria();
        criteria.andStudentNumberEqualTo(studentInfo.getStudentNumber());
        criteria.andStudentPasswordEqualTo(studentInfo.getStudentPassword());
        int size=studentInfoService.selectByExample(studentInfoCriteria).size();
        if(size==0)
        {
            return "login_phone";
        }
         studentInfo=studentInfoService.selectByExample(studentInfoCriteria).get(0);
         session.setAttribute("stuinfo",studentInfo);
        return "studentphone/student_index";
    }
    @RequestMapping("list.do/{sid}")
    public  String  loadevaluation(@PathVariable("sid") Integer sid,Map<String,Object> map)
    {
        EvaluationInfoCriteria evaluationInfoCriteria=new EvaluationInfoCriteria();
        EvaluationInfoCriteria.Criteria criteria=evaluationInfoCriteria.createCriteria();
        criteria.andStudentIdEqualTo(sid);
        List<EvaluationInfo> evaluationInfoList=evaluationInfoService.selectByExample(evaluationInfoCriteria);
        map.put("list",evaluationInfoList);
        return "studentphone/evaluation_list";
    }
    @RequestMapping("info")
    public String loadinfo()
    {
        return "studentphone/student_info";
    }
    @RequestMapping("studentpayment/{sid}")
    public  String loadPayment(@PathVariable("sid") Integer sid,Map<String,Object> map)
    {
        StudentPaymentCriteria studentPaymentCriteria=new StudentPaymentCriteria();
        StudentPaymentCriteria.Criteria criteria=studentPaymentCriteria.createCriteria();
        List<StudentPayment> listp=studentPaymentService.selectByExample(studentPaymentCriteria);
        map.put("listp",listp);
        return "studentphone/student_payment";
    }
    @RequestMapping("studentWriteGrade/{sid}")
    public  String swglist(@PathVariable("sid")Integer sid,Map<String,Object> map)
    {
        StudentWriteGradeEx studentWriteGradeEx=new StudentWriteGradeEx();
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setStaffId(sid);
        studentWriteGradeEx.setStudentInfo(studentInfo);
        List<StudentWriteGradeEx>  lists=studentWriteGradeService.Getstudentwritegrade(studentWriteGradeEx);
        map.put("lists",lists);
        return "studentphone/student_score";
    }
    @ResponseBody
    @RequestMapping("add.do")
    public String add(EvaluationInfo evaluationInfo)
    {
       int size= evaluationInfoService.insertSelective(evaluationInfo);
        if(size>0)
        {
            return "添加成功";
        }
        return  "添加失败";
    }

}
