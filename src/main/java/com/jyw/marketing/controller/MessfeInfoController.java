package com.jyw.marketing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.marketing.service.MessafeInfoService;
import com.jyw.marketing.service.TemplateInfoService;
import com.jyw.model.*;
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
 * Created by Administrator on 2016/11/11 .
 */
@Controller
@RequestMapping("messafeinfo")
public class MessfeInfoController {
    @Autowired
    private MessafeInfoService messafeInfoService;
    @Autowired
    private TemplateInfoService templateInfoService;
    @ModelAttribute
    public void getLoginer(Map<String,Object> map,HttpSession session)
    {
        StaffInfo staffInfo=(StaffInfo)session.getAttribute("staff");
        map.put("staffInfo",staffInfo);
    }
    @RequestMapping(value = "list.do")
    public String list(@RequestParam(required = false,defaultValue = "1") int pageNum,Map<String,Object> map, StaffInfo staffInfo, MessfeInfoEx  messfeInfoEx){
        messfeInfoEx.setStaffInfo(staffInfo);
        PageHelper.startPage(pageNum,10);
        List<MessfeInfoEx> messafeInfoList= messafeInfoService.selectAllMesssfeInfo(messfeInfoEx);
        PageInfo page = new PageInfo(messafeInfoList);
        map.put("page",page);
        map.put("messafeInfoList",messafeInfoList);
        map.put("messafeInfo",messfeInfoEx);
        return "/marketing/messafeinfo/messafeinfo_list";
    }
    @RequestMapping(value = "load.do")
    public  String load(Map<String,Object> map)
    {
        TemplateInfoCriteria templateInfoCriteria=new TemplateInfoCriteria();
        List<TemplateInfo> templist= templateInfoService.selectByExample(templateInfoCriteria);
        map.put("templist",templist);
       return  "/marketing/messafeinfo/messafeinfo_send";
    }
    @RequestMapping(value = "send.do")
    public String send(MessafeInfo messafeInfo,StaffInfo staffInfo)
    {
        messafeInfo.setStaffId(staffInfo.getStaffId());
        messafeInfo.setMessafeTime( new Date());
        messafeInfoService.insertSelective(messafeInfo);
        return  "redirect:/messafeinfo/list.do";
    }
    @RequestMapping(value="show.do/{messageid}")
    public  String  show(@PathVariable("messageid") Integer messageid,Map<String,Object> map)
    {
        MessfeInfoEx messafeInfoEx=new MessfeInfoEx();
        messafeInfoEx.setMessafeId(messageid);
        List<MessfeInfoEx> messafeInfoEx1= messafeInfoService.selectAllMesssfeInfo(messafeInfoEx);
        map.put("mess",messafeInfoEx1.get(0));
            return "/marketing/messafeinfo/messafeinfo_show";
    }
    @RequestMapping(value = "delete.do/{messageid}",method = RequestMethod.DELETE)
    public  String delete(@PathVariable("messageid") Integer id)
    {
        messafeInfoService.deleteByPrimaryKey(id);
        return "redirect:/messafeinfo/list.do";
    }
}
