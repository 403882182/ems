package com.jyw.marketing.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.marketing.service.EmailInfoService;
import com.jyw.marketing.service.TemplateInfoService;
import com.jyw.model.*;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

/**
 * Created by Administrator on 2016/11/8 .
 */
@Controller
@RequestMapping("/email")
public class EmailInfoController {
    @Autowired
    private EmailInfoService emailInfoService;
    @Autowired
    private TemplateInfoService templateInfoService;
    /**
     * 获取数据保存在request域中
     * @return
     * 在实现分页时使用用的
     *  @RequestMapping(value ="/getEmailInfoList/{pageNum}")
     * String getEmailInfoList(@PathVariable(value="pageNum") Integer id, Map<String,Object> map)
     */
    @ModelAttribute
    public void getLoginer(Map<String,Object> map,HttpSession session)
    {
       /* StaffInfo staffInfo =new StaffInfo();
        staffInfo.setStaffId(15);
        staffInfo.setStaffName("白龙马");*/
        StaffInfo staffInfo=(StaffInfo)session.getAttribute("staff");
        map.put("staffInfo",staffInfo);
    }
    @RequestMapping(value ="/list.do")
    public  String getEmailInfoList(@RequestParam(required = false,defaultValue = "1") int pageNum,
                                    EmailInfoEx emailInfoEx,StaffInfo  staffInfo,Map<String,Object> map)
    {       //在实现分页时使用用的
        PageHelper.startPage(pageNum,10);
        emailInfoEx.setStaffInfo(staffInfo);
        List<EmailInfoEx> emailInfoExList=emailInfoService.getAllEmailInfoEx(emailInfoEx);
        PageInfo page = new PageInfo(emailInfoExList);
        map.put("page",page);
        map.put("EmailInfoEx",emailInfoEx);
        return "/marketing/emailinfo/emailinfo_list";
    }
    //跳转映射
    @RequestMapping(value = "load.do",method = RequestMethod.GET)
    public String ReEmaildo( Map<String,Object> map)
    {
        TemplateInfoCriteria templateInfoCriteria=new TemplateInfoCriteria();
        List<TemplateInfo> templist= templateInfoService.selectByExample(templateInfoCriteria);
        map.put("templist",templist);
        map.put("EmailInfo",new EmailInfo());
        return "/marketing/emailinfo/emailinfo_send";
    }

    @RequestMapping(value = "send.do",method = RequestMethod.POST)
    public String sendEmail(@Valid EmailInfo emailInfo,Errors result,Map<String,Object> map,StaffInfo staffInfo)
    {
        if(result.getErrorCount() > 0)
        {
            System.out.println("*********************************************errors: " + result.getErrorCount());
            TemplateInfoCriteria templateInfoCriteria=new TemplateInfoCriteria();
            List<TemplateInfo> templist= templateInfoService.selectByExample(templateInfoCriteria);
            map.put("templist",templist);
            map.put("EmailInfo",new EmailInfo());
            return "/marketing/emailinfo/emailinfo_send";
        }
        //设置发送人
        emailInfo.setStaffId(staffInfo.getStaffId());
        //设置时间
        emailInfo.setEmailTime( new Date());
        emailInfoService.insertSelective(emailInfo);
        return  "redirect:/email/list.do";
    }

    @RequestMapping(value = "show.do/{Emailid}",method = RequestMethod.GET)
    public String showEmail(@PathVariable("Emailid")Integer id , Map<String,Object> map)
    {
        EmailInfoEx emailInfoEx=new EmailInfoEx();
        emailInfoEx.setEmailId(id);
        List<EmailInfoEx> list=emailInfoService.getAllEmailInfoEx(emailInfoEx);
                map.put("emailInfo",list.get(0));
        emailInfoEx.setEmailState("已查看");
        emailInfoService.updateByPrimaryKeySelective(emailInfoEx);
        return "/marketing/emailinfo/emailinfo_show";
    }

    @RequestMapping( value = "delete.do/{Emialid}",method = RequestMethod.DELETE)
    public String deleteEmail(@PathVariable("Emialid")Integer id,StaffInfo  staffInfo)
    {   emailInfoService.deleteByPrimaryKey(id);
       return "redirect:/email/list.do";
    }
}
