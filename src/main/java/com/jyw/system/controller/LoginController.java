package com.jyw.system.controller;

import com.jyw.marketing.service.EmailInfoService;
import com.jyw.model.*;
import com.jyw.system.dto.AnthortyDTO;
import com.jyw.system.service.AnthortyInfoService;
import com.jyw.system.service.ReportService;
import com.jyw.system.service.StaffInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"staff","emailInfoList"})
public class LoginController {

    @Autowired
    private AnthortyInfoService anthortyInfoService;
    @Autowired
    private StaffInfoService staffInfoService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private EmailInfoService emailInfoService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/index")
    public String login(String userNumber,String userPassowrd, Map<String, Object> map) {
        //非空验证
        if(StringUtils.isNotEmpty(userNumber) && StringUtils.isNotEmpty(userPassowrd)){
            //构造查询条件
            StaffInfoCriteria criteria = new StaffInfoCriteria();
            criteria.or()
                    .andUserNumberEqualTo(userNumber)
                    .andUserPassowrdEqualTo(userPassowrd);
            //查询
            List<StaffInfo> staffList = staffInfoService.selectByExample(criteria);
            //判断是否验证成功
            if (staffList != null && staffList.size() > 0) {
                //保存当前用户到session
                StaffInfo staff = staffList.get(0);
                map.put("staff",staff);
                //邮箱查看
                EmailInfoCriteria emailInfoCriteria = new EmailInfoCriteria();
                emailInfoCriteria.or()
                                 .andEmailAddrEqualTo(staff.getStaffEamil())
                                 .andEmailStateEqualTo("未查看");
                List<EmailInfo> emailInfoList =  emailInfoService.selectByExample(emailInfoCriteria);
                map.put("emailInfoList",emailInfoList);

                //判断是否拥有权限
                if (staff.getRoleId() != null) {
                    //通过角色id获取到权限列表
                    List<AnthortyInfo> anthList = anthortyInfoService.getAnthList(staff.getRoleId());

                    // 构建菜单（一级和二级）
                    List<AnthortyDTO> dtoList = new ArrayList<>();
                    for (AnthortyInfo anth : anthList) {
                        if (anth != null && anth.getAnthortyPid() == 1) {
                            //一级菜单
                            AnthortyDTO dto = new AnthortyDTO();
                            dto.setAnth(anth);

                            //二级菜单
                            List<AnthortyInfo> subList = new ArrayList<>();
                            getAnthorty(subList, anthList, anth.getAnthortyId());
                            dto.setList(subList);
                            dtoList.add(dto);
                        }
                    }
                    map.put("dtoList", dtoList);
                    return "index";
                }
            } else {
                map.put("info", "用户名或密码错误");
            }
        }else{
            map.put("info", "用户名或密码不能为空");
        }
        System.out.println("fff");
        return "login";
    }

    /**
     * 用户注销，返回登录页面
     */
    @RequestMapping(value = "/logout")
    public String logout(SessionStatus sessionStatus) {

        //只清空使用了@SessionAttributes的session对象
        sessionStatus.setComplete();
        return "login";
    }
    /**
     * 递归方法实现添加二级菜单
     * @param subList
     * @param list
     * @param anthortyId
     */
    public void getAnthorty(List<AnthortyInfo> subList, List<AnthortyInfo> list, Integer anthortyId) {
        if (list != null && list.size() > 0) {
            for (AnthortyInfo anth : list) {
                if (anth != null && anth.getAnthortyPid() != null && anth.getAnthortyPid().equals(anthortyId)) {
                    subList.add(anth);
                    //继续构建下级菜单
                    getAnthorty(subList, list, anth.getAnthortyId());
                }
            }
        }
    }

    /**
     * 邮箱更新
     * @param staff
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateEmail")
    public @ResponseBody List<EmailInfo> updateEmail(@ModelAttribute("staff") StaffInfo staff,Map<String,Object> map){
        //邮箱查看
        EmailInfoCriteria emailInfoCriteria = new EmailInfoCriteria();
        emailInfoCriteria.or()
                .andEmailAddrEqualTo(staff.getStaffEamil())
                .andEmailStateEqualTo("未查看");
        List<EmailInfo> emailInfoList =  emailInfoService.selectByExample(emailInfoCriteria);
        map.put("emailInfoList",emailInfoList);
        return emailInfoList;
    }

    /**
     * 控制台
     */
    @RequestMapping("/bootm")
    public String getBootm(Map<String,Object> map){
        bootm(map);
        return "bootm";
    }

    /**
     * 控制台数据
     */
    public void bootm(Map<String,Object> map){
        map.put("studentSateList",reportService.selectStudentList());
        map.put("studentMarkList",reportService.selectStudentMarkList());
        map.put("studentProList",reportService.selectStudentProList());
        map.put("studentSateList",reportService.selectStudentSateList());
    }
}
