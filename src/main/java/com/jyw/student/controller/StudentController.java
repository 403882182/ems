package com.jyw.student.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.*;
import com.jyw.recruitstudent.service.AuditionInfoService;
import com.jyw.recruitstudent.service.StudentInfoService;
import com.jyw.recruitstudent.service.TrackRecordInfoService;
import com.jyw.student.service.CommunicateInfoService;
import com.jyw.student.service.EvaluationInfoService;
import com.jyw.student.service.StudentWriteGradeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/25.
 */
@Controller
@RequestMapping("/student/")
@SessionAttributes("staff")
public class StudentController {
    @Resource(name="studentInfoServiceImpl")
    private StudentInfoService studentInfoService;
    @Autowired
    private CommunicateInfoService communicateInfoService;
    @Autowired
    private StudentWriteGradeService studentWriteGradeService;
    @Autowired
    private EvaluationInfoService evaluationInfoService;
    @Resource(name="trackRecordInfoServiceImpl")
    private TrackRecordInfoService trackRecordInfoService;
    @Resource(name="auditionInfoServiceImpl")
    private AuditionInfoService auditionInfoService;

    @RequestMapping("list.do")
    public String list(Map<String,Object> map, StudentInfo studentInfo, @RequestParam(required = false,defaultValue = "1") int pageNum,@ModelAttribute("staff") StaffInfo staffInfo ){
        System.out.println(studentInfo.getStudentSate()+"hahaha");
        System.out.println(staffInfo.getStaffId()+"fff");
        StudentInfoCriteria criteria=new StudentInfoCriteria();
        criteria.or()
                .andStaffIdEqualTo(staffInfo.getStaffId());
        if (studentInfo!=null){
            if(studentInfo.getStudentSate()!=null) {
                criteria.or()
                        .andStudentSateEqualTo(studentInfo.getStudentSate())
                        .andStaffIdEqualTo(staffInfo.getStaffId());
            }
            if(StringUtils.isNotEmpty(studentInfo.getStudentName())){
                criteria.or()
                        .andStudentNameLike("%" + studentInfo.getStudentName() + "%")
                        .andStaffIdEqualTo(staffInfo.getStaffId());//模糊查询
            }
        }
        PageHelper.startPage(pageNum,10);
        List<StudentInfo> list= studentInfoService.selectByExample(criteria);
        PageInfo page = new PageInfo(list);
        map.put("page",page);
        return "student/student/student_list";
    }

    /**
     * 添加学生
     * @param map
     * @return
     */
    @RequestMapping("add.do")
    public String add(StudentInfo studentInfo,Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){
        studentInfo.setStudentMark("0");
        int count=studentInfoService.insert(studentInfo);

        if (count>0){
            map.put("info","添加学员成功");
        }else {
            map.put("info","添加学员失败");
        }
        return list(map,null,1,staffInfo);
    }

    /**
     * 根据编号查询学员信息
     * @param studentId
     * @param map
     * @return
     */
    @RequestMapping("show.do")
    public String show(@RequestParam("id") Integer studentId, Map<String,Object> map){
        StudentInfo studentInfo=studentInfoService.selectByPrimaryKey(studentId);
        StudentInfo studentinfo=new StudentInfo();
        studentInfo.setStudentId(studentId);
        CommunicateInfoEx communicateInfoEx=new CommunicateInfoEx();
        communicateInfoEx.setStudentInfo(studentinfo);
        StudentWriteGradeEx studentWriteGradeEx=new StudentWriteGradeEx();
        studentWriteGradeEx.setStudentInfo(studentinfo);
        EvaluationInfoEx evaluationInfoEx=new EvaluationInfoEx();
        evaluationInfoEx.setStudentInfo(studentinfo);
        AuditionInfoCriteria ac=new AuditionInfoCriteria();
        ac.or()
                .andStudentIdEqualTo(studentId);
        TrackRecordInfoCriteria tc=new TrackRecordInfoCriteria();
        tc.or()
                .andStudentIdEqualTo(studentId);

        List<CommunicateInfoEx> communicateInfoExList=communicateInfoService.selectAllCommunicateInfo(communicateInfoEx);
        List<StudentWriteGradeEx > studentWriteGradeExList= studentWriteGradeService.Getstudentwritegrade(studentWriteGradeEx);
        List<EvaluationInfoEx> evaluationInfoices=evaluationInfoService.selectAllEvaluation(evaluationInfoEx);
        List<AuditionInfo> AuditionInfoList=auditionInfoService.selectByExample(ac);
        List<TrackRecordInfo> TrackRecordInfoList = trackRecordInfoService.selectByExample(tc);


        map.put("stuinfo",studentInfo);
        map.put("evaluationlist",evaluationInfoices);
        map.put("commlist",communicateInfoExList);
        map.put("swglist",studentWriteGradeExList);
        map.put("auditlist",AuditionInfoList);
        map.put("tracklist",TrackRecordInfoList);

        return "student/student/student_show";
    }

    /**
     * 加载修改页面
     * @param studentId
     * @param map
     * @return
     */
    @RequestMapping("load.do")
    public String load(@RequestParam("studentId") Integer studentId,Map<String ,Object> map){
        StudentInfo studentInfo=studentInfoService.selectByPrimaryKey(studentId);
        map.put("stuinfo",studentInfo);
        return "student/student/student_update";
    }


    /**
     * 修改学生
     * @param map
     * @return
     */
    @RequestMapping("update.do")
    public String update(StudentInfo studentInfo,Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){
        studentInfo.setStudentMark("0");
        int count=studentInfoService.updateByPrimaryKeySelective(studentInfo);

        if (count>0){
            map.put("info","修改学员成功");
        }else {
            map.put("info","修改学员失败");
        }
        return list(map,null,1,staffInfo);
    }

    /**
     * 删除学员信息，并不是数据库里删除
     * 而是把学员状态改成-1
     * //-1表示无效 0表示未分配学员 1已分配学员 2报名学员
     * @return
     */
    @RequestMapping("delete.do")
    public String delete(@RequestParam("studentId") Integer Id,StudentInfo studentInfo,Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){
        studentInfo.setStudentMark("-1");//-1表示无效 0表示未分配学员 1已分配学员 2报名学员
        studentInfo.setStudentId(Id);
        int count=studentInfoService.updateByPrimaryKeySelective(studentInfo);

        if (count>0){
            map.put("info","删除学员成功");
        }else {
            map.put("info","删除学员失败");
        }
        return list(map,null,1,staffInfo);
    }


}
