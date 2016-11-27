package com.jyw.educational.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.educational.service.ClassTransactionInfoService;
import com.jyw.model.ClassInfo;
import com.jyw.model.ClassTransactionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by john on 2016/11/25.
 */
@Controller
@RequestMapping("/classtransactioninfo")
public class TransactionInfoController {
@Autowired
    private ClassTransactionInfoService transactionInfoService;

    private  List<ClassTransactionInfo> list;
    List<ClassInfo> classlist;


    /**
     * 查询所有班级事务
     * @param classTransactionTitle
     * @param model
     * @return
     */
    @RequestMapping("/list.do")
    public String selectTransacionInfo(String classTransactionTitle, Model model, @RequestParam(required = false,defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum,10);
        list=transactionInfoService.selectTransactionInfo(classTransactionTitle);
        PageInfo page = new PageInfo(list);
        model.addAttribute("page",page);
        return "educational/classtransactioninfo/classtransactioninfo_list";
    }

    /**
     * 查询班级
     * @return
     */
    @RequestMapping("/selectClassInfo")
    public String selectClassInfo(Model model){
      classlist=transactionInfoService.selectClassInfo();
        model.addAttribute("classlist",classlist);
        return "educational/classtransactioninfo/classtransactioninfo_add";

    }

    /**
     * 添加班级事务信息
     */
    @RequestMapping("/insert")
    public String insert(ClassTransactionInfo transactionInfo,Model model){
        int row=transactionInfoService.insert(transactionInfo);
        if(row>0){
            model.addAttribute("info","添加成功");
            }else{
            model.addAttribute("info","添加失败");
            }
         return  selectTransacionInfo("",model,1);
    }

    /**
     * 加载更改页面的班级组
     * @param classTransactionId
     * @param model
     */
    @RequestMapping("/updateList")
    public String updateList(int classTransactionId,Model model){
        classlist=transactionInfoService.selectClassInfo();
        ClassTransactionInfo cti=transactionInfoService.selectByPrimaryKey(classTransactionId);
        model.addAttribute("transactinfo",cti);
        model.addAttribute("classlist",classlist);
        model.addAttribute("classTransactionId",classTransactionId);
        System.out.println(classTransactionId+"***************************8");

        return "educational/classtransactioninfo/classtransactioninfo_update";
    }

  /**
     * 修改班级事务
     */
    @RequestMapping("/updateByPrimaryKey")
    public String updateByPrimaryKey(ClassTransactionInfo transactionInfo,Model model){
int row=transactionInfoService.updateByPrimaryKey(transactionInfo);
        if(row>0){
           model.addAttribute("info","修改成功") ;
         }else {
            model.addAttribute("info","修改失败") ;
        }
        return selectTransacionInfo("",model,1);
    }
/**
 * 删除班级事务
 */
@RequestMapping("deleteByPrimaryKey")
public String deleteByPrimaryKey(int classTransactionId,Model model){
int row=transactionInfoService.deleteByPrimaryKey(classTransactionId);
    if(row>0){
        model.addAttribute("info","删除成功");
     }else {
        model.addAttribute("info","删除失败");
       }
     return selectTransacionInfo("",model,1);
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
