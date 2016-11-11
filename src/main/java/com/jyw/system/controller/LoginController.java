package com.jyw.system.controller;

import com.jyw.model.*;
import com.jyw.system.dto.AnthortyDTO;
import com.jyw.system.service.AnthortyInfoService;
import com.jyw.system.service.RoleAnthorityInfoService;
import com.jyw.system.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rayya on 2016/11/8.
 */
@Controller
public class LoginController {
    @Autowired
    private AnthortyInfoService anthortyInfoService;

    @Autowired
    private StaffInfoService staffInfoService;

    /**
     * 用户登录
     *
     * @param staffInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/index")
    public String login(StaffInfo staffInfo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<StaffInfo> staffList = staffInfoService.getStaffList(staffInfo);
        if (staffList.size() > 0 && staffList != null) {
            //保存当前用户到session
            StaffInfo staff = staffList.get(0);
            session.setAttribute("staff", staff);
            if (staff.getRoleId() != null) {
                //通过角色id获取到权限列表
                List<AnthortyInfo> anthList = anthortyInfoService.getAnthList(staff.getRoleId());

                // 构建菜单（一级和二级）
                List<AnthortyDTO> dtoList = new ArrayList<AnthortyDTO>();
                for (AnthortyInfo anth : anthList) {
                    if (anth != null && anth.getAnthortyPid() == 1) {
                        //一级菜单
                        AnthortyDTO dto = new AnthortyDTO();
                        dto.setAnth(anth);

                        //二级菜单
                        List<AnthortyInfo> subList = new ArrayList<AnthortyInfo>();
                        getAnthorty(subList, anthList, anth.getAnthortyId());
                        dto.setList(subList);
                        dtoList.add(dto);
                    }
                }
                request.setAttribute("dtoList", dtoList);
                return "index";
            }
        } else {
            request.setAttribute("loginInfo", "用户名或密码错误");
        }
        return "login";
    }

    /**
     * 用户注销，返回登录页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("staff");
        return "login";
    }
    /**
     * 递归方法实现添加二级菜单
     *
     * @param subList
     * @param list
     * @param anthortyId
     */
    public void getAnthorty(List<AnthortyInfo> subList, List<AnthortyInfo> list, Integer anthortyId) {
        if (list != null && list.size() > 0) {
            for (AnthortyInfo anth : list) {
                if (anth != null && anth.getAnthortyPid() != null && anth.getAnthortyPid().equals(anthortyId)) {
                    subList.add(anth);
                    /**
                     * 若有多级菜单可用递归法调用
                     * getAnthorth(subList,list,anth.getAnthortyId())
                     */
                }
            }
        }
    }

}
