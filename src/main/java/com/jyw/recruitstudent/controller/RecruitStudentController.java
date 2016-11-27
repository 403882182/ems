package com.jyw.recruitstudent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.*;
import com.jyw.recruitstudent.service.AuditionInfoService;
import com.jyw.recruitstudent.service.StudentInfoService;
import com.jyw.recruitstudent.service.TrackRecordInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 招生线索
 * Created by 59545 on 2016/11/13.
 */
@Controller
@RequestMapping("/recruitstudent/")
@SessionAttributes("staff")
public class RecruitStudentController {
    /**
     * 学员信息的业务逻辑接口
     */
    @Resource(name = "studentInfoServiceImpl")
    private StudentInfoService studentInfoService;

    /**
     * 跟踪记录的业务逻辑接口
     */
    @Resource(name = "trackRecordInfoServiceImpl")
    private TrackRecordInfoService trackRecordInfoService;

    /**
     * 试听记录的逻辑接口
     */
    @Resource(name = "auditionInfoServiceImpl")
    private AuditionInfoService auditionInfoService;

    /**
     * 查询学生信息表里面标识为0，
     * 也就是来咨询，但是未报名分配班级的学员信息
     *
     * @param map
     * @return
     */
    @RequestMapping("list.do")
    public String list(Map<String, Object> map,@ModelAttribute("staff") StaffInfo staffInfo, StudentInfo stuinfo,@RequestParam(required = false,defaultValue = "1") int pageNum) {

        StudentInfoCriteria criteria = new StudentInfoCriteria();
        if (staffInfo != null) {
            //获取领取学员人的信息，也就是当前登录用户的信息
            criteria.or().andStaffIdEqualTo(staffInfo.getStaffId());
        }
        //判断输入的姓名和学员意向是否为空
        if (StringUtils.isNotEmpty(stuinfo.getStudentName()) && stuinfo.getStudentSate() != null) {
            criteria.or()
                    .andStudentSateEqualTo(stuinfo.getStudentSate())
                    .andStudentNameLike("%" + stuinfo.getStudentName() + "%")
                    .andStaffIdEqualTo(staffInfo.getStaffId())
                    .andStudentMarkEqualTo("1");
        } else if (stuinfo.getStudentSate() != null) {  //根据学员意向查询
            criteria.or()
                    .andStudentSateEqualTo(stuinfo.getStudentSate())
                    .andStudentMarkEqualTo("1")
                    .andStaffIdEqualTo(staffInfo.getStaffId());
        } else if (StringUtils.isNotEmpty(stuinfo.getStudentName())) {
            criteria.or()
                    .andStudentMarkEqualTo("1")
                    .andStaffIdEqualTo(staffInfo.getStaffId())
                    .andStudentNameLike("%" + stuinfo.getStudentName() + "%");//模糊查询
        } else {
            criteria.or()
                    .andStudentMarkEqualTo("1")
                    .andStaffIdEqualTo(staffInfo.getStaffId());//-1表示无效 0表示未分配学员 1已分配学员 2报名学员
        }
        PageHelper.startPage(pageNum,10);
        List<StudentInfo> list = studentInfoService.selectByExample(criteria);
        PageInfo page = new PageInfo(list);
        map.put("page", page);
        return "recruitstudent/recruitstudent/recruitstudent_list";
    }

    /**
     * 添加学员
     *
     * @param map
     * @return
     */
    @RequestMapping("add.do")
    public String add(StudentInfo studentInfo, Map<String, Object> map,@ModelAttribute("staff") StaffInfo staffInfo) {
        studentInfo.setStudentMark("1");
        int count = studentInfoService.insert(studentInfo);

        if (count > 0) {
            map.put("info", "添加学员成功");
        } else {
            map.put("info", "添加学员失败");
        }
        return list(map, staffInfo, studentInfo,1);
    }

    /**
     * 根据编号查询学员信息
     *  与跟踪记录和试听记录相关联
     * @param studentId
     * @param map
     * @return
     */
    @RequestMapping("show.do")
    public String show(@RequestParam("studentId") Integer studentId, Map<String, Object> map) {
        StudentInfo studentInfo = studentInfoService.selectByPrimaryKey(studentId);
        map.put("stuinfo", studentInfo);

        TrackRecordInfo trackRecordInfo=new TrackRecordInfo();
        trackRecordInfo.setStudentId(studentId);

        //获取跟踪记录相关信息
        List<TrackRecordInfo> tracklist=trackRecordInfoService.selectByStudentId(trackRecordInfo);
        map.put("tracklist",tracklist);

        //获取试听记录相关信息
        AuditionInfoCriteria criteria1=new AuditionInfoCriteria();
        criteria1.or().andStudentIdEqualTo(studentId);

        List<AuditionInfo>  auditlist=auditionInfoService.selectByExample(criteria1);
        map.put("auditlist",auditlist);

        return "recruitstudent/recruitstudent/recruitstudent_show";
    }

    /**
     * 加载修改页面
     *
     * @param studentId
     * @param map
     * @return
     */
    @RequestMapping("load.do")
    public String load(@RequestParam("studentId") Integer studentId, Map<String, Object> map) {
        StudentInfo studentInfo = studentInfoService.selectByPrimaryKey(studentId);
        map.put("stuinfo", studentInfo);
        return "recruitstudent/recruitstudent/recruitstudent_update";
    }


    /**
     * 修改学生信息
     *
     * @param map
     * @return
     */
    @RequestMapping("update.do")
    public String update(StudentInfo studentInfo, Map<String, Object> map,@ModelAttribute("staff") StaffInfo staffInfo) {
        //studentInfo.setStudentMark("1");
        int count = studentInfoService.updateByPrimaryKeySelective(studentInfo);

        if (count > 0) {
            map.put("info", "修改学员成功");
        } else {
            map.put("info", "修改学员失败");
        }
        return list(map, staffInfo, studentInfo,1);
    }

    /**
     * 删除学员信息，并不是数据库里删除
     * 而是把学员状态改成-1
     * //-1表示无效 0表示未分配学员 1已分配学员 2报名学员
     */
    @RequestMapping("delete.do")
    public String delete(@RequestParam("studentId") Integer Id, StudentInfo studentInfo, Map<String, Object> map,@ModelAttribute("staff") StaffInfo staffInfo) {
        studentInfo.setStudentMark("-1");//-1表示无效 0表示未分配学员 1已分配学员 2报名学员
        studentInfo.setStudentId(Id);
        int count = studentInfoService.updateByPrimaryKeySelective(studentInfo);

        if (count > 0) {
            map.put("info", "删除学员成功");
        } else {
            map.put("info", "删除学员失败");
        }
        return list(map, staffInfo, studentInfo,1);
    }

    /**
     * 时间属性的编辑器
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }


}
