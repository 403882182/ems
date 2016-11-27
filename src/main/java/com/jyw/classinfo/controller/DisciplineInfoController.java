package com.jyw.classinfo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.classinfo.service.DisciplineInfoService;
import com.jyw.model.DisciplineInfo;
import com.jyw.model.DisciplineInfoCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.annotation.Resource;

import java.util.List;

/**
 * Created by XXXX on 2016-11-09.
 */
@Controller
@RequestMapping("/disciplineinfo")
public class DisciplineInfoController {

    @Resource
    private DisciplineInfoService disciplineInfoService;

    DisciplineInfoCriteria disciplineInfoCriteria = null;

    /**
     * 加载所有学科信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model,String disciplineName,@RequestParam(required = false, defaultValue = "1")int pageNum) {
        disciplineInfoCriteria=new DisciplineInfoCriteria();
        if(disciplineName!=null){
            disciplineInfoCriteria.or()
                    .andDisciplineIsuesdEqualTo("1")
                    .andDisciplineNameLike("%" + disciplineName + "%")
            ;
        }else{
            disciplineInfoCriteria.or().andDisciplineIsuesdEqualTo("1");
        }
        PageHelper.startPage(pageNum, 10);
        List<DisciplineInfo> discipline = disciplineInfoService.selectByExample(disciplineInfoCriteria);
        PageInfo page = new PageInfo(discipline);
        model.addAttribute("page", page);

        return "classinfo/disciplineinfo/disciplineinfo_list";
    }

    /**
     * 添加学科信息
     *
     * @param info
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(DisciplineInfo info, Model model) {
        info.setDisciplineIsuesd("1");
        int count = disciplineInfoService.insert(info);
        if (count > 0) {
            model.addAttribute("info", "添加成功");
        } else {
            model.addAttribute("info", "添加失败");
        }

        return list(model,null,1);
    }

    /**
     * 根据id删除学科信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        DisciplineInfo disciplineInfo=disciplineInfoService.selectByPrimaryKey(id);
        disciplineInfo.setDisciplineIsuesd("0");
        int count = disciplineInfoService.updateByPrimaryKeySelective(disciplineInfo);
        if (count > 0) {
            model.addAttribute("info", "删除成功");
        } else {
            model.addAttribute("info", "删除失败");
        }

        return "forward:/disciplineinfo/list";
    }

    /**
     * 根据id查询学科
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/selectById/{id}")
    public String selectById(@PathVariable Integer id, Model model) {
        DisciplineInfo disciplineInfo = disciplineInfoService.selectByPrimaryKey(id);
        model.addAttribute("disciplineInfo", disciplineInfo);

        return "classinfo/disciplineinfo/disciplineinfo_update";
    }

    /**
     * 修改学科信息
     *
     * @param disciplineInfo
     * @return
     */
    @RequestMapping("/update")
    public String update(DisciplineInfo disciplineInfo, Model model) {
        disciplineInfo.setDisciplineIsuesd("1");
        int count = disciplineInfoService.updateByPrimaryKey(disciplineInfo);
        if (count > 0) {
            model.addAttribute("info", "修改成功");
        } else {
            model.addAttribute("info", "修改失败");
        }

        return list(model,null,1);
    }
}
