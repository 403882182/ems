package com.jyw.recruitstudent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.*;
import com.jyw.recruitstudent.service.AuditionInfoService;
import com.jyw.recruitstudent.service.StudentInfoService;
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
 * 试听记录
 * Created by 59545 on 2016/11/22.
 */
@Controller
@RequestMapping("/auditioninfo/")
@SessionAttributes("staff")
public class AuditionInfoController {

    //学员管理的Service业务逻辑接口
    @Resource(name="studentInfoServiceImpl")
    private StudentInfoService studentInfoService;

    //加载试听记录业务逻辑
    @Resource(name="auditionInfoServiceImpl")
    private AuditionInfoService auditionInfoService;

    /**
     * 试听记录查询
     * @return
     */
    @RequestMapping("list.do")
    public String list(String studentName, AuditionInfo auditionInfo,Map<String,Object> map,@RequestParam(required = false,defaultValue = "1") int pageNum,@ModelAttribute("staff") StaffInfo staffInfo){
        //学员姓名的模糊查询
        if(StringUtils.isEmpty(studentName)){
            studentName="%%";
        }else {
            studentName="%"+studentName+"%";
        }

        //课程名称的模糊查询
        if (StringUtils.isEmpty(auditionInfo.getAuditionCourse())){
            auditionInfo.setAuditionCourse("%%");
        }else {
            auditionInfo.setAuditionCourse("%"+auditionInfo.getAuditionCourse()+"%");
        }
        PageHelper.startPage(pageNum,10);
        List<AuditionInfo> list=auditionInfoService.getAuditionList(studentName,auditionInfo,staffInfo.getStaffId());
        PageInfo page = new PageInfo(list);
        map.put("page",page);
//        for(Map.Entry<String, Object> entry:map.entrySet()){
//            System.out.println(entry.getKey()+"--->"+entry.getValue());
//        }
        return "recruitstudent/auditioninfo/auditioninfo_list";
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
        criteria.or().andStudentMarkEqualTo("1");//-1表示无效 0表示未分配学员 1已分配学员 2报名学员

        List<StudentInfo> list = studentInfoService.selectByExample(criteria);
        map.put("list", list);
        return "recruitstudent/auditioninfo/auditioninfo_add";
    }

    /**
     * 添加试听记录
     * @param info
     * @param map
     * @return
     */
    @RequestMapping("add.do")
    public String add(AuditionInfo info,Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){

        //添加方法
        int count=auditionInfoService.insertSelective(info);
        //判断
        if(count>0){
            map.put("info","添加试听记录成功");
        }else {
            map.put("info","添加试听记录失败");
        }
        return list("",info,map,1,staffInfo);
    }

    /**
     * 加载修改页面
     * @return
     */
    @RequestMapping("loadupdate.do")
    public String loadupdate(@RequestParam("auditionId") Integer auditionId, Map<String ,Object> map,@ModelAttribute("staff") StaffInfo staffInfo) {
        StudentInfoCriteria criteria = new StudentInfoCriteria();

        StudentInfo stuinfo=new StudentInfo();
        if (staffInfo != null) {
            //获取领取学员人的信息，也就是当前登录用户的信息
            criteria.or().andStaffIdEqualTo(staffInfo.getStaffId());
        }
        criteria.or().andStudentMarkEqualTo("1");

        List<StudentInfo> list = studentInfoService.selectByExample(criteria);
        map.put("list", list);

        AuditionInfo auditionInfo = auditionInfoService.selectByPrimaryKey(auditionId);
        map.put("audit",auditionInfo);
        return "recruitstudent/auditioninfo/auditioninfo_update";
    }

    /**
     * 修改信息
     * @param info
     * @param map
     *
     * @return
     */
    @RequestMapping("update.do")
    public String update(AuditionInfo info, Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){

        //添加方法
        int count = auditionInfoService.updateByPrimaryKeySelective(info);
        //判断
        if (count > 0) {
            map.put("info", "修改学员试听记录信息成功");
        } else {
            map.put("info", "修改学员试听记录信息失败");
        }

        return list("",info,map,1,staffInfo);
    }

    @RequestMapping("delete.do")
    public String delete(@RequestParam("auditionId") Integer auditionId,AuditionInfo info,Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){
        //删除方法
        int count=auditionInfoService.deleteByPrimaryKey(auditionId);
        //判断
        if (count > 0) {
            map.put("info", "删除学员试听记录信息成功");
        } else {
            map.put("info", "删除学员试听记录信息失败");
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
