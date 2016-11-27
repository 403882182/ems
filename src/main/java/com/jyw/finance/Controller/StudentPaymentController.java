package com.jyw.finance.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.classinfo.service.ClassInfoService;
import com.jyw.finance.service.StudentPaymentService;
import com.jyw.model.*;
import com.jyw.recruitstudent.service.StudentInfoService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/11/11 0011.
 */
@Controller
@RequestMapping("/studentpayment/")
@SessionAttributes("staff")
public class StudentPaymentController {
    @Resource(name="studentInfoServiceImpl")
    private StudentInfoService studentInfoService;
    @Resource
    private ClassInfoService classInfoService;

   @Resource(name="studentPaymentServiceImpl")
    private StudentPaymentService studentPaymentService;

    private StudentPayment studentPayment;

    private StudentInfo studentInfo;

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public StudentPayment getStudentPayment() {
        return studentPayment;
    }

    public void setStudentPayment(StudentPayment studentPayment) {
        this.studentPayment = studentPayment;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    private List<StudentInfo> list ;

    public List<StudentInfo> getList() {
        return list;
    }

    public void setList(List<StudentInfo> list) {
        this.list = list;
    }

    private Map<String,PageInfo> map=new HashMap<String,PageInfo>();

    public void setMap(Map<String, PageInfo> map) {
        this.map = map;
    }

    public Map<String, PageInfo> getMap() {
        return map;
    }



    /*
   * 查询所有学员信息
   *
   * */
    @RequestMapping("list")
    public String show(StudentPayment info, Model model,String studentName, @RequestParam(required = false,defaultValue = "1")int pageNum,@RequestParam(required = false,defaultValue = "0") int studentSate,@ModelAttribute("staff") StaffInfo staffInfo){
        String key="";
        if(studentName!=null){
            key="%"+studentName+"%";
        }else{
            key="%%";
        }
        PageHelper.startPage(pageNum,10);
        list=studentPaymentService.selectByKeyName(key,studentSate,staffInfo.getStaffId());
        PageInfo page=new PageInfo(list);
        model.addAttribute("page",page);
        return "finance/studentpayment/studentpayment_list";
    }
    /**
     * 根据编号查询学员信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("loadpayment/{id}")
    public String loadpayment(@PathVariable Integer id, Model model) {
        StudentInfo stuinfo =studentInfoService.selectByPrimaryKey(id);
        model.addAttribute("stuinfo",stuinfo);
        StudentPayment studentPayment=new StudentPayment();
        studentPayment.setPaymentTime(new java.util.Date());
        model.addAttribute("studentPayment",studentPayment);
        return "finance/studentpayment/student_payment";
    }
  /**
     * 学员缴费
     *@RequestMapping("payment/{id}")
     */
    @RequestMapping("payment/{id}")
    public String payment(@PathVariable Integer id,Model model){
        StudentInfo stuinfo =studentInfoService.selectByPrimaryKey(id);
        model.addAttribute("stuinfo",stuinfo);
        StudentPaymentCriteria studentPaymentCriteria=new StudentPaymentCriteria();
        studentPaymentCriteria.or().andStudentIdEqualTo(id);
        List<StudentPayment> list=studentPaymentService.selectByExample(studentPaymentCriteria);

        model.addAttribute("list",list);
        return "finance/studentpayment/studentpayment_show";
    }
    /*
    *新增缴费信息
    */
    @RequestMapping("insertPayment")
    public String insertPayment(StudentPayment studentPayment, Model model,@ModelAttribute("staff") StaffInfo staffInfo) {
        int mark = studentPaymentService.insert(studentPayment);
        if (mark > 0) {
            StudentInfo stuinfo = new StudentInfo();
            stuinfo.setStudentId(studentPayment.getStudentId());
            StudentInfo studentInfo=studentInfoService.selectByPrimaryKey(stuinfo.getStudentId());
            System.out.println(studentInfo.getStudentName());
            if (studentPayment.getDebtAmount() > 0) {
                stuinfo.setStudentIspay("1");//部分缴费
            } else {
                stuinfo.setStudentIspay("2");//已经交清费用
            }
            int count=studentInfoService.updateByPrimaryKeySelective(stuinfo);
            System.out.println(count);
            if(count>0){
                model.addAttribute("info", "缴费成功");
            } else {
                model.addAttribute("info", "缴费失败");
            }
        }


            return show(null,model,null,1,1,staffInfo);
        }



    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model,@ModelAttribute("staff") StaffInfo staffInfo){
        int mark = studentPaymentService.deleteByPrimaryKey(id);
        if(mark>0){
            model.addAttribute("info", "删除缴费信息成功");
        }else{
            model.addAttribute("info", "删除缴费信息失败");
        }

        return show(null,model,null,1,1,staffInfo);
    }


    /**
     * 时间属性的编辑器SimpleDateFormat
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
