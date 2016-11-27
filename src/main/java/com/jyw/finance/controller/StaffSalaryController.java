package com.jyw.finance.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.finance.service.StaffSalaryService;
import com.jyw.model.StaffInfo;
import com.jyw.model.StaffInfoCriteria;
import com.jyw.model.StaffSalary;
import com.jyw.model.StaffSalaryCriteria;
import com.jyw.system.service.StaffInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staffsalary/")
public class StaffSalaryController {

    @Resource
    private StaffSalaryService staffSalaryService;

    @Resource
    private StaffInfoService staffInfoService;
    private StaffSalaryCriteria staffSalaryCriteria;
    private StaffSalary staffSalary;
    List<StaffSalary> list;

    public StaffSalary getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(StaffSalary staffSalary) {
        this.staffSalary = staffSalary;
    }

    @RequestMapping("list")
    public String show(StaffSalary info, Model model, String staffName, @RequestParam(required = false,defaultValue = "1")int pageNum){
        PageHelper.startPage(pageNum,10);
        list = staffSalaryService.getStaffSalaryList(staffName);
        if(list!=null && list.size()>0){
            for(StaffSalary ss:list){
                if("0".equals(ss.getIsUesd())){

                    ss.setUrl("<a href='staffsalary/update?staffSalaryId="+ss.getStaffSalaryId()+"' >领取工资</a>");
                }else{
                    ss.setUrl("已领取");
                }
            }

        }

        PageInfo page=new PageInfo(list);
        model.addAttribute("page",page);
        return "finance/staffsalary/staffsalary_list";
    }
    @RequestMapping("update")
    public String update(StaffSalary info,Model model){

        if(info!=null){
            //1已发放 0 未发放
            info.setIsUesd("1");
            info.setStaffSalaryTime(new Date());
        }

        int mark = staffSalaryService.updateByPrimaryKeySelective(info);
        if(mark>0){
            model.addAttribute("info", "领取成功!");
        }else{
            model.addAttribute("info", "领取失败!");
        }

        return show(info,model,null,1);
    }
    @RequestMapping("loadadd")
    public String loadAdd(Model model){

        StaffInfoCriteria staffInfoCriteria=new StaffInfoCriteria();
        staffInfoCriteria.or();
        List<StaffInfo> stafflist=staffInfoService.selectByExample(staffInfoCriteria);
        model.addAttribute("stafflist",stafflist);
        return "finance/staffsalary/staffsalary_add";
    }

    @RequestMapping("add")
    public String add(StaffSalary info,Model model){
        info.setStaffSalaryTime(new Date());
        int mark = staffSalaryService.insertSelective(info);
        if(mark>0){
            model.addAttribute("info", "添加纪录成功!");
        }else{
            model.addAttribute("info", "添加纪录失败!");
        }

        return show(info,model,null,1);
    }
}
