package com.jyw.marketing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.marketing.service.TemplateInfoService;
import com.jyw.model.StaffInfo;
import com.jyw.model.TemplateInfo;
import com.jyw.model.TemplateInfoCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/11 .
 */

@Controller
@RequestMapping("template")
public class TemplateController {
    @Autowired
    private TemplateInfoService templateInfoService;
    @RequestMapping("list.do")
    public String list(@RequestParam(required = false,defaultValue = "1") int pageNum, Map<String,Object> map, TemplateInfo templateInfo)
    {   PageHelper.startPage(pageNum,10);
        TemplateInfoCriteria templateInfoCriteria=new TemplateInfoCriteria();
        TemplateInfoCriteria.Criteria  criteria=templateInfoCriteria.createCriteria();
        if(templateInfo!=null){
        if(templateInfo.getTemplateTitle()!=null&&templateInfo.getTemplateTitle()!="")
        {
            criteria.andTemplateTitleEqualTo(templateInfo.getTemplateTitle());
        }
        }
       List<TemplateInfo> templateInfoList= templateInfoService.selectByExample(templateInfoCriteria);
        PageInfo page = new PageInfo(templateInfoList);
        map.put("page",page);
        map.put("templateInfoList",templateInfoList);
        map.put("templateInfo",new  TemplateInfo());
        return "marketing/template/template_list";
    }
    @RequestMapping("load.do")
    public String load()
    {
        return "marketing/template/template_add";
    }
    @RequestMapping("add.do")
    public String add(TemplateInfo templateInfo)
    {
        templateInfoService.insertSelective(templateInfo);
        return "redirect:/template/list.do";
    }
    @RequestMapping("loadupdate.do/{templateInfoId}")
    public String loadupdate(@PathVariable("templateInfoId") Integer templateInfoId,Map<String,Object> map)
    {
        TemplateInfo templateInfo=templateInfoService.selectByPrimaryKey(templateInfoId);
        map.put("templateInfo",templateInfo);
        return "marketing/template/template_update";
    }
    @RequestMapping("update.do")
    public String update(TemplateInfo templateInfo)
    {
        templateInfoService.updateByPrimaryKeySelective(templateInfo);
        return "redirect:/template/list.do";
    }
    @RequestMapping("delete.do/{templateInfoId}")
    public String delete(@PathVariable("templateInfoId") Integer id)
    {   templateInfoService.deleteByPrimaryKey(id);
        return "redirect:/template/list.do";
    }
}
