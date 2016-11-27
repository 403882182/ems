package com.jyw.classinfo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.classinfo.service.ClassInfoService;
import com.jyw.classinfo.service.ClassroomInfoService;
import com.jyw.classinfo.service.DisciplineInfoService;
import com.jyw.classinfo.service.SyllabusInfoService;
import com.jyw.model.*;
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
 * Created by XXXX on 2016-11-08.
 */
@Controller
@RequestMapping("/classinfo")
public class ClassInfoController {

    @Resource
    private ClassInfoService classInfoService;
    @Resource
    private ClassroomInfoService classroomInfoService;
    @Resource
    private StaffInfoService staffInfoService;
    @Resource
    private DisciplineInfoService disciplineInfoService;
    @Resource
    private SyllabusInfoService syllabusInfoService;

    ClassInfoCriteria classInfoCriteria = null;

    StaffInfoCriteria staffInfoCriteria = null;

    /**
     * 加载班级所有信息
     * @param model
     * @return
     */
    @RequestMapping("/list.do")
    public String list(Model model,String className,@RequestParam(required = false, defaultValue = "1")int pageNum) {
        classInfoCriteria = new ClassInfoCriteria();

        if(className!=null){
            classInfoCriteria.or()
                    .andClassIsuesdEqualTo("1")
                    .andClassNameLike("%" + className + "%")
            ;
        }else{
            classInfoCriteria.or().andClassIsuesdEqualTo("1");
        }
        PageHelper.startPage(pageNum, 10);
        List<ClassInfo> classInfos = classInfoService.selectByExample(classInfoCriteria);
        PageInfo page = new PageInfo(classInfos);
        model.addAttribute("page", page);

        return "classinfo/classinfo/classinfo_list";
    }
    /**
     * 添加班级信息
     *
     * @param classInfo
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(ClassInfo classInfo, Model model) {
        classInfo.setClassIsuesd("1");
        int count = classInfoService.insert(classInfo);
        if (count > 0) {
            model.addAttribute("info", "添加成功");
        } else {
            model.addAttribute("info", "添加失败");
        }

        return list(model,null,1);
    }
    /**
     * 根据 id 删除班级信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        ClassInfo classInfo = classInfoService.selectByPrimaryKey(id);
        classInfo.setClassIsuesd("0");
        int count = classInfoService.updateByPrimaryKeySelective(classInfo);
        if (count > 0) {
            model.addAttribute("info", "删除成功");
        } else {
            model.addAttribute("info", "删除失败");
        }

        return "forward:/classInfo/list";
    }

    /**
     * 加载所有教室、学科、教师、课程名称，并根据id查找班级信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/selectById/{id}")
    public String selectById(@PathVariable Integer id, Model model) {
        //查询所有教师信息
        staffInfoCriteria = new StaffInfoCriteria();
        staffInfoCriteria.or().andStaffStateEqualTo("2");
        List<StaffInfo> staffInfos = staffInfoService.selectByExample(staffInfoCriteria);
        model.addAttribute("staffInfo", staffInfos);

        //查询所有教室信息
        List<ClassroomInfo> classroomInfos = classroomInfoService.selectByExample(null);
        model.addAttribute("classroomInfo", classroomInfos);

        //查询所有学科信息
        List<DisciplineInfo> disciplineInfos = disciplineInfoService.selectByExample(null);
        model.addAttribute("disciplineInfo", disciplineInfos);

        //查询所有课程名称
        List<SyllabusInfo> syllabusInfos = syllabusInfoService.selectByExample(null);
        model.addAttribute("syllabusInfo", syllabusInfos);

        //根据id查询班级信息
        ClassInfo classInfo = classInfoService.selectByPrimaryKey(id);
        model.addAttribute("classInfo", classInfo);

        return "classinfo/classinfo/classinfo_update";
    }

    /**
     * 加载所有教室、学科、教师、课程名称
     *
     * @param model
     * @return
     */
    @RequestMapping("/addload")
    public String addload(Model model) {
        //查询所有教师名称
        staffInfoCriteria = new StaffInfoCriteria();
        staffInfoCriteria.or().andStaffStateEqualTo("2");
        List<StaffInfo> staffInfos = staffInfoService.selectByExample(staffInfoCriteria);
        model.addAttribute("staffInfo", staffInfos);

        //查询所有教室名称
        List<ClassroomInfo> classroomInfos = classroomInfoService.selectByExample(null);
        model.addAttribute("classroomInfo", classroomInfos);

        //查询所有学科名称
        List<DisciplineInfo> disciplineInfos = disciplineInfoService.selectByExample(null);
        model.addAttribute("disciplineInfo", disciplineInfos);

        //查询所有课程名称
        List<SyllabusInfo> syllabusInfos = syllabusInfoService.selectByExample(null);
        model.addAttribute("syllabusInfo", syllabusInfos);

        return "classinfo/classinfo/classinfo_add";
    }



    /**
     * 修改班级信息
     *
     * @param classInfo
     * @param model
     * @return
     */
    @RequestMapping("/update")
    public String update(ClassInfo classInfo, Model model) {
        classInfo.setClassIsuesd("1");
        int count = classInfoService.updateByPrimaryKey(classInfo);
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
