package com.jyw.marketing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.marketing.service.MarketActiveService;
import com.jyw.model.*;
import com.jyw.system.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/11/10 .
 */
@Controller
@RequestMapping(value = "marketactive")
public class MarketActiveController {
    @Autowired
    private MarketActiveService marketActiveService;
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @ModelAttribute
    public void getLoginer(Map<String,Object> map,HttpSession session)
    {
        StaffInfo staffInfo=(StaffInfo)session.getAttribute("staff");
        map.put("staffInfo",staffInfo);


        DataDictionaryCriteria dataDictionaryCriteria= new  DataDictionaryCriteria();
        DataDictionaryCriteria.Criteria criteria=   dataDictionaryCriteria.createCriteria();
        criteria.andDataTypeEqualTo("active_state");
        List<DataDictionary>  dataDictionaryStateList= dataDictionaryService.selectByExample(dataDictionaryCriteria);

        DataDictionaryCriteria dataDictionaryCriteria1= new  DataDictionaryCriteria();
        DataDictionaryCriteria.Criteria criteria1=   dataDictionaryCriteria1.createCriteria();
        criteria1.andDataTypeEqualTo("active_type");
        List<DataDictionary>  dataDictionaryTypeList= dataDictionaryService.selectByExample(dataDictionaryCriteria1);

        DataDictionaryCriteria dataDictionaryCriteria2= new  DataDictionaryCriteria();
        DataDictionaryCriteria.Criteria criteria2=   dataDictionaryCriteria2.createCriteria();
        criteria2.andDataTypeEqualTo("active_refect_estimate");
        List<DataDictionary>  dataDictionaryStudent_sate= dataDictionaryService.selectByExample(dataDictionaryCriteria2);

        map.put("dataDictionaryStudent_sate",dataDictionaryStudent_sate);
        map.put("dataDictionaryStateList",dataDictionaryStateList);
        map.put("dataDictionaryTypeList",dataDictionaryTypeList);
    }
    @RequestMapping(value = "/list.do")
    public String list(@RequestParam(required = false,defaultValue = "1") int pageNum, StaffInfo staffInfo, Map<String,Object> map, MarketActiveEx marketActiveEx)
    {
        marketActiveEx.setStaffInfo(staffInfo);
        PageHelper.startPage(pageNum,10);
        List<MarketActiveEx> marketActiveExList= marketActiveService.selectAllMarketActionEx(marketActiveEx);
        PageInfo page = new PageInfo(marketActiveExList);
        map.put("page",page);
        map.put("marketActiveExList",marketActiveExList);
        return "/marketing/marketactive/marketactive_list";
    }
    @RequestMapping(value = "load.do/{id}",method = RequestMethod.GET)
    public String load(@PathVariable("id") Integer id, StaffInfo staffInfo, MarketActiveEx marketActiveEx,Map<String,Object> map)
    {   marketActiveEx.setStaffInfo(staffInfo);
        marketActiveEx.setActiveId(id);
        List<MarketActiveEx> list=  marketActiveService.selectAllMarketActionEx(marketActiveEx);
        map.put("market",list.get(0));
        return "/marketing/marketactive/marketactive_update";
    }
    @RequestMapping(value="update.do",method = RequestMethod.PUT)
    public String update(MarketActive marketActive)
    {
            marketActiveService.updateByPrimaryKeySelective(marketActive);
            return "redirect:/marketactive/list.do";
    }
    @RequestMapping(value = "loadadd.do")
    public String loadadd()
    {
        return "/marketing/marketactive/marketactive_add";
    }
    @RequestMapping("add.do")
    public String add(MarketActive marketActive,StaffInfo staffInfo)
    {
        marketActive.setStaffId(staffInfo.getStaffId());
        marketActiveService.insertSelective(marketActive);
        return "redirect:/marketactive/list.do";
    }
    @RequestMapping("delete.do/{marketActiveid}")
    public String delete(@PathVariable("marketActiveid") Integer id)
    {
        marketActiveService.deleteByPrimaryKey(id);
        return  "redirect:/marketactive/list.do";
    }
    /**
     * 日期转换
     * @param bin
     */

    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
