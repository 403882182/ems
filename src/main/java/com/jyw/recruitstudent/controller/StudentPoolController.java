package com.jyw.recruitstudent.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.StaffInfo;
import com.jyw.model.StudentInfo;
import com.jyw.model.StudentInfoCriteria;
import com.jyw.recruitstudent.service.StudentInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 学员池的信息管理控制器
 * Created by 59545 on 2016/11/11.
 */
@Controller
@RequestMapping("/studentpool/")
@SessionAttributes("staff")
public class StudentPoolController {
    /**
     *
     */
    @Resource(name="studentInfoServiceImpl")
    private StudentInfoService studentInfoService;

    /**
     * 查询学生信息表里面标识为0，
     * 也就是来咨询，但是未报名分配班级的学员信息
     * @param map
     * @return
     */
    @RequestMapping("list.do")
    public String list(Map<String,Object> map,String studentName,@RequestParam(required = false,defaultValue = "1") int pageNum){
        StudentInfoCriteria criteria=new StudentInfoCriteria();
        if (StringUtils.isNotEmpty(studentName)){
            criteria.or()
                    .andStudentMarkEqualTo("0")
                    .andStudentNameLike("%"+studentName+"%");//模糊查询
        }else{
            criteria.or().andStudentMarkEqualTo("0");//-1表示无效 0表示未分配学员 1已分配学员 2报名学员
        }
        PageHelper.startPage(pageNum,10);
       List<StudentInfo> list= studentInfoService.selectByExample(criteria);
        PageInfo page = new PageInfo(list);
       map.put("page",page);
        return "recruitstudent/studentpool/studentpool_list";
    }

    /**
     * 添加学生
     * @param map
     * @return
     */
    @RequestMapping("add.do")
    public String add(StudentInfo studentInfo,Map<String,Object> map){
        studentInfo.setStudentMark("0");
        int count=studentInfoService.insert(studentInfo);

        if (count>0){
            map.put("info","添加学员成功");
        }else {
            map.put("info","添加学员失败");
        }
        return list(map,"",1);
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
        map.put("stuinfo",studentInfo);
        return "recruitstudent/studentpool/studentpool_show";
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
        return "recruitstudent/studentpool/studentpool_update";
    }


    /**
     * 修改学生
     * @param map
     * @return
     */
    @RequestMapping("update.do")
    public String update(StudentInfo studentInfo,Map<String,Object> map){
        studentInfo.setStudentMark("0");
        int count=studentInfoService.updateByPrimaryKeySelective(studentInfo);

        if (count>0){
            map.put("info","修改学员成功");
        }else {
            map.put("info","修改学员失败");
        }
        return list(map,"",1);
    }

    /**
     * 删除学员信息，并不是数据库里删除
     * 而是把学员状态改成-1
     * //-1表示无效 0表示未分配学员 1已分配学员 2报名学员
     * @return
     */
    @RequestMapping("delete.do")
    public String delete(@RequestParam("studentId") Integer Id,StudentInfo studentInfo,Map<String,Object> map){
        studentInfo.setStudentMark("-1");//-1表示无效 0表示未分配学员 1已分配学员 2报名学员
        studentInfo.setStudentId(Id);
        int count=studentInfoService.updateByPrimaryKeySelective(studentInfo);

        if (count>0){
            map.put("info","删除学员成功");
        }else {
            map.put("info","删除学员失败");
        }
        return list(map,"",1);
    }

    /**
     * 领取学员
     * @param Id
     * @param studentInfo
     * @param map
     * @param staffInfo
     * @return
     */
    @RequestMapping("receive.do")
    public String receive(@RequestParam("studentId") Integer Id, StudentInfo studentInfo, Map<String,Object> map,@ModelAttribute("staff") StaffInfo staffInfo){
        if (staffInfo!=null){
            //获取领取学员人的信息，也就是当前登录用户的信息
            studentInfo.setStaffId(staffInfo.getStaffId());
        }

        studentInfo.setStudentMark("1");//-1表示无效 0表示未分配学员 1已分配学员 2报名学员
        studentInfo.setStudentId(Id);
        int count=studentInfoService.updateByPrimaryKeySelective(studentInfo);

        if (count>0){
            map.put("info","领取学员成功");
        }else {
            map.put("info","领取学员失败");
        }
        return list(map,"",1);
    }
}
