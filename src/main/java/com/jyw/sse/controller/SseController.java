package com.jyw.sse.controller;

import com.jyw.marketing.service.EmailInfoService;
import com.jyw.model.EmailInfo;
import com.jyw.model.EmailInfoCriteria;
import com.jyw.model.StaffInfo;
import com.jyw.system.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"staff","emailInfoList"})
public class SseController {

    @Autowired
    private EmailInfoService emailInfoService;
    @Autowired
    private StaffInfoService staffInfoService;

    @RequestMapping(value = "/push",produces = "text/event-stream")
    public @ResponseBody String push(@ModelAttribute("staff") StaffInfo staff,
                                     @ModelAttribute("emailInfoList") List<EmailInfo> emailInfoList){

        //邮箱查看
        EmailInfoCriteria emailInfoCriteria = new EmailInfoCriteria();
        emailInfoCriteria.or()
                .andEmailAddrEqualTo(staff.getStaffEamil())
                .andEmailStateEqualTo("未查看");
        List<EmailInfo> list =  emailInfoService.selectByExample(emailInfoCriteria);

        List<Integer> idList = new ArrayList<>();
        for (EmailInfo item:emailInfoList)  {
            idList.add(item.getEmailId());
        }

        for (EmailInfo item:list){
            if(!idList.contains(item.getEmailId())){
                String staffName = staffInfoService.selectByPrimaryKey(item.getStaffId()).getStaffName();
                return "retry:5000\ndata:标题："+item.getEmailTitle()+"\n"+"data:发送人："+staffName+"\n\n";
            }
        }
        return "retry:5000\n\n";
    }

}
