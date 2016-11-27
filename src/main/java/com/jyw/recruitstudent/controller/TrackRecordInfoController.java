package com.jyw.recruitstudent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.*;
import com.jyw.recruitstudent.service.StudentInfoService;
import com.jyw.recruitstudent.service.TrackRecordInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.ServletRequestDataBinder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 跟踪记录的控制器
 * Created by 59545 on 2016/11/14.
 */
@Controller
@RequestMapping("/trackrecordinfo/")
@SessionAttributes("staff")
public class TrackRecordInfoController {

    //跟踪记录的Service
    @Resource(name="trackRecordInfoServiceImpl")
    private TrackRecordInfoService trackRecordInfoService;

    //学员管理的Service
    @Resource(name="studentInfoServiceImpl")
    private StudentInfoService studentInfoService;

    /**
     * 查询跟踪记录信息
     * @return
     */
    @RequestMapping("list.do")
    public String list(String studentName,TrackRecordInfo trackRecordInfo,Map<String ,Object> map,@RequestParam(required = false,defaultValue = "1") int pageNum,@ModelAttribute("staff") StaffInfo staffInfo){
        if (StringUtils.isEmpty(studentName)){
            studentName="%%";
        }else {
            studentName="%"+studentName+"%";
        }
        PageHelper.startPage(pageNum,10);
        List<TrackRecordInfo> list = trackRecordInfoService.selectByTrackRecordInfo(studentName,trackRecordInfo,staffInfo.getStaffId());
        PageInfo page = new PageInfo(list);
        map.put("page", page);

        return "recruitstudent/trackrecord/trackrecord_list";
    }

    /**
     * 加载添加页面
     * @return
     */
    @RequestMapping("loadadd.do")
    public String loadAdd(Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){
        StudentInfoCriteria criteria = new StudentInfoCriteria();

        StudentInfo stuinfo=new StudentInfo();
        if (staffInfo != null) {
            //获取领取学员人的信息，也就是当前登录用户的信息
            criteria.or().andStaffIdEqualTo(staffInfo.getStaffId());
        }
        criteria.or().andStudentMarkEqualTo("1");

        List<StudentInfo> list = studentInfoService.selectByExample(criteria);
        map.put("list", list);
        return "recruitstudent/trackrecord/trackrecord_add";
    }

    /**
     * 添加信息
     * @param info
     * @param map
     *
     * @return
     */
    @RequestMapping("add.do")
    public String add(TrackRecordInfo info, Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){

        //添加方法
        int count = trackRecordInfoService.insertSelective(info);
        //判断
        if (count > 0) {
            map.put("info", "添加学员跟踪记录信息成功");
        } else {
            map.put("info", "添加学员跟踪记录信息失败");
        }

        return list("",info,map,1,staffInfo);
    }

    /**
     * 根据编号查询跟踪记录信息
     * @param trackRecordId
     * @param map
     * @param staffInfo
     * @return
     */
    @RequestMapping("load.do")
    public String loadUpdate(@RequestParam("trackRecordId") Integer trackRecordId, Map<String, Object> map,@ModelAttribute("staff") StaffInfo staffInfo){
        StudentInfoCriteria criteria = new StudentInfoCriteria();

        StudentInfo stuinfo=new StudentInfo();
        if (staffInfo != null) {
            //获取领取学员人的信息，也就是当前登录用户的信息
            criteria.or().andStaffIdEqualTo(staffInfo.getStaffId());
        }
        criteria.or().andStudentMarkEqualTo("1");

        List<StudentInfo> list = studentInfoService.selectByExample(criteria);
        map.put("list", list);

        TrackRecordInfo trackRecordInfo=trackRecordInfoService.selectByPrimaryKey(trackRecordId);
        map.put("trackinfo",trackRecordInfo);


        return "recruitstudent/trackrecord/trackrecord_update";
    }

    /**
     * 修改信息
     * @param info
     * @param map
     *
     * @return
     */
    @RequestMapping("update.do")
    public String update(TrackRecordInfo info, Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){

        //添加方法
        int count = trackRecordInfoService.updateByPrimaryKeySelective(info);
        //判断
        if (count > 0) {
            map.put("info", "修改学员跟踪记录信息成功");
        } else {
            map.put("info", "修改学员跟踪记录信息失败");
        }

        return list("",info,map,1,staffInfo);
    }

    /**
     * 删除信息
     * @return
     */
    @RequestMapping("delete.do")
    public String detele(@RequestParam("trackRecordId") Integer trackRecordId,TrackRecordInfo info, Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){

        //添加方法
        int count = trackRecordInfoService.deleteByPrimaryKey(trackRecordId);
        //判断
        if (count > 0) {
            map.put("info", "删除学员跟踪记录信息成功");
        } else {
            map.put("info", "删除学员跟踪记录信息失败");
        }

        return list("",info,map,1,staffInfo);
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
