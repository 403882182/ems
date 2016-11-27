package com.jyw.classinfo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.classinfo.service.ClassroomInfoService;
import com.jyw.model.ClassroomInfo;
import com.jyw.model.ClassroomInfoCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XXXX on 2016-11-10.
 */
@Controller
@RequestMapping("/classroominfo")
public class ClassRoomInfoController {

    @Resource
    private ClassroomInfoService classroomInfoService;

    ClassroomInfoCriteria classroomInfoCriteria = null;

    /**
     * 加载所有教室信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/list.do")
    public String list(Model model,String classroomName,@RequestParam(required = false, defaultValue = "1")int pageNum) {
        classroomInfoCriteria=new ClassroomInfoCriteria();
        if(classroomName!=null){
            classroomInfoCriteria.or()
                    .andClassroomMarkEqualTo("1")
                    .andClassroomNameLike("%" + classroomName + "%")
            ;
        }else{
            classroomInfoCriteria.or().andClassroomMarkEqualTo("1");
        }
        PageHelper.startPage(pageNum, 10);
        List<ClassroomInfo> classroomInfos = classroomInfoService.selectByExample(classroomInfoCriteria);
        PageInfo page = new PageInfo(classroomInfos);
        model.addAttribute("page", page);

        return "classinfo/classroominfo/classroominfo_list";
    }

    /**
     * 根据id删除教室信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        ClassroomInfo classroomInfo=classroomInfoService.selectByPrimaryKey(id);
        classroomInfo.setClassroomMark("0");
        int count = classroomInfoService.updateByPrimaryKeySelective(classroomInfo);
        if (count > 0) {
            model.addAttribute("info", "删除成功");
        } else {
            model.addAttribute("info", "删除失败");
        }

        return "forward:/classroominfo/list";
    }


    /**
     * 添加教室信息
     *
     * @param classroomInfo
     * @return
     */
    @RequestMapping("/add")
    public String add(ClassroomInfo classroomInfo, Model model) {
        classroomInfo.setClassroomMark("1");
        int count = classroomInfoService.insert(classroomInfo);
        if (count > 0) {
            model.addAttribute("info", "添加成功");
        } else {
            model.addAttribute("info", "添加失败");
        }
        return list(model,null,1);
    }

    /**
     * 根据id查找教室信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/selectById/{id}")
    public String selectById(@PathVariable Integer id, Model model) {
        ClassroomInfo classroomInfo = classroomInfoService.selectByPrimaryKey(id);
        model.addAttribute("classroominfo", classroomInfo);

        return "classinfo/classroominfo/classroominfo_update";
    }

    /**
     * 修改教室信息
     *
     * @param classroomInfo
     * @return
     */
    @RequestMapping("/update")
    public String update(ClassroomInfo classroomInfo, Model model) {
        classroomInfo.setClassroomMark("1");
        int count = classroomInfoService.updateByPrimaryKey(classroomInfo);
        if (count > 0) {
            model.addAttribute("info", "修改成功");
        } else {
            model.addAttribute("info", "修改失败");
        }

        return list(model,null,1);
    }


}
