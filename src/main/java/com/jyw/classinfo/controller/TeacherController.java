package com.jyw.classinfo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.StaffInfo;
import com.jyw.model.StaffInfoCriteria;
import com.jyw.system.service.StaffInfoService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by XXXX on 2016-11-10.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private StaffInfoService staffInfoService;

    StaffInfoCriteria staffInfoCriteria = null;

    /**
     * 加载所有员工信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/list.do")
    public String list(Model model,StaffInfo staffInfo,@RequestParam(required = false, defaultValue = "1")int pageNum) {
        staffInfoCriteria = new StaffInfoCriteria();
        if(staffInfo != null ) {
            if (staffInfo.getStaffId() != null) {

                //根据编号查询教师信息
                staffInfoCriteria = new StaffInfoCriteria();
                staffInfoCriteria.or()
                        .andStaffStateEqualTo("2")
                        .andStaffIdEqualTo(staffInfo.getStaffId())
                ;
            } else if (staffInfo.getStaffName() != null) {

                //根据关键字查询教师信息
                staffInfoCriteria = new StaffInfoCriteria();
                staffInfoCriteria.or()
                        .andStaffStateEqualTo("2")
                        .andStaffNameLike("%" + staffInfo.getStaffName() + "%")
                ;
            } else if (staffInfo.getStaffMobilePhone() != null) {

                //根据手机号查询教师信息
                staffInfoCriteria = new StaffInfoCriteria();
                staffInfoCriteria.or()
                        .andStaffStateEqualTo("2")
                        .andStaffMobilePhoneLike("%" + staffInfo.getStaffMobilePhone() + "%")
                ;
            } else {
                staffInfoCriteria.or().andStaffStateEqualTo("2");
            }
        }else {
            staffInfoCriteria.or().andStaffStateEqualTo("2");
        }
        PageHelper.startPage(pageNum, 10);
        List<StaffInfo> staffInfos = staffInfoService.selectByExample(staffInfoCriteria);
        PageInfo page = new PageInfo(staffInfos);
        model.addAttribute("page", page);

        return "classinfo/teacher/teacher_list";
    }

    /**
     * 根据id删除员工信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        StaffInfo staffInfo=staffInfoService.selectByPrimaryKey(id);
        staffInfo.setStaffState("0");
        int count = staffInfoService.updateByPrimaryKey(staffInfo);
        if (count > 0) {
            model.addAttribute("info", "删除成功");
        } else {
            model.addAttribute("info", "删除成功");
        }

        return "forward:/staffInfo/list";
    }

    /**
     * 根据id查找要修改的员工信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/selectById/{id}")
    public String selectById(@PathVariable Integer id, Model model) {
        StaffInfo staffInfo = staffInfoService.selectByPrimaryKey(id);
        model.addAttribute("staffInfo", staffInfo);

        return "classinfo/teacher/teacher_update";
    }

    /**
     * 根据id查找要查看员工信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/selectByIds/{id}")
    public String selectByIds(@PathVariable Integer id, Model model) {
        StaffInfo staffInfo = staffInfoService.selectByPrimaryKey(id);
        model.addAttribute("staffInfo", staffInfo);

        return "classinfo/teacher/teacher_show";
    }

    /**
     * 添加员工信息
     *
     * @param staffInfo
     * @return
     */
    @RequestMapping("/add")
    public String add(StaffInfo staffInfo, Model model) {
        staffInfo.setStaffState("2");
        int count = staffInfoService.insert(staffInfo);
        if (count > 0) {
            model.addAttribute("info", "添加成功");
        } else {
            model.addAttribute("info", "添加失败");
        }

        return list(model,null,1);
    }

    /**
     * 修改员工信息
     *
     * @param staffInfo
     * @return
     */
    @RequestMapping("/update")
    public String update(StaffInfo staffInfo, Model model) {
        staffInfo.setStaffState("2");
        int count = staffInfoService.updateByPrimaryKey(staffInfo);
        if (count > 0) {
            model.addAttribute("info", "修改成功");
        } else {
            model.addAttribute("info", "修改失败");
        }

        return list(model,null,1);
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
