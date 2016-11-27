package com.jyw.classinfo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.classinfo.service.SyllabusInfoService;
import com.jyw.model.SyllabusInfo;
import com.jyw.model.SyllabusInfoCriteria;
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
@RequestMapping("/syllabusinfo")
public class SyllabusInfoController {

    @Resource
    private SyllabusInfoService syllabusInfoService;

    SyllabusInfoCriteria syllabusInfoCriteria = null;

    /**
     * 加载所有课程信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/list.do")
    public String list(Model model,String syllabusName,@RequestParam(required = false, defaultValue = "1")int pageNum) {
        syllabusInfoCriteria=new SyllabusInfoCriteria();
        if(syllabusName!=null){
            syllabusInfoCriteria.or()
                    .andIsUesdEqualTo("1")
                    .andSyllabusNameLike("%" + syllabusName + "%")
            ;
        }else{
            syllabusInfoCriteria.or().andIsUesdEqualTo("1");
        }
        PageHelper.startPage(pageNum, 10);
        List<SyllabusInfo> syllabusInfos = syllabusInfoService.selectByExample(syllabusInfoCriteria);
        PageInfo page = new PageInfo(syllabusInfos);
        model.addAttribute("page", page);

        return "classinfo/syllabusinfo/syllabusinfo_list";
    }

    /**
     * 根据id删除课程信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        SyllabusInfo syllabusInfo=syllabusInfoService.selectByPrimaryKey(id);
        syllabusInfo.setIsUesd("0");
        int count = syllabusInfoService.updateByPrimaryKeySelective(syllabusInfo);
        if (count > 0) {
            model.addAttribute("info", "删除成功");
        } else {
            model.addAttribute("info", "删除失败");
        }

        return "forward:/syllabusInfo/list";
    }

    /**
     * 根据id查询课程信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/selectById/{id}")
    public String selectById(@PathVariable Integer id, Model model) {
        SyllabusInfo syllabusInfo = syllabusInfoService.selectByPrimaryKey(id);
        model.addAttribute("syllabusInfo", syllabusInfo);

        return "classinfo/syllabusinfo/syllabusinfo_update";
    }

    /**
     * 修改课程信息
     *
     * @param syllabusInfo
     * @return
     */
    @RequestMapping("/update")
    public String update(SyllabusInfo syllabusInfo, Model model) {
        syllabusInfo.setIsUesd("1");
        int count = syllabusInfoService.updateByPrimaryKey(syllabusInfo);
        if (count > 0) {
            model.addAttribute("info", "修改成功");
        } else {
            model.addAttribute("info", "修改失败");
        }

        return list(model,null,1);
    }

    /**
     * 添加课程信息
     *
     * @param syllabusInfo
     * @return
     */
    @RequestMapping("/add")
    public String add(SyllabusInfo syllabusInfo, Model model) {
        syllabusInfo.setIsUesd("1");
        int count = syllabusInfoService.insert(syllabusInfo);
        if (count > 0) {
            model.addAttribute("info", "添加成功");
        } else {
            model.addAttribute("info", "添加失败");
        }

        return list(model,null,1);
    }

}
