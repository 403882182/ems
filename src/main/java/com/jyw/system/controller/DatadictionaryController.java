package com.jyw.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyw.model.DataDictionary;
import com.jyw.model.DataDictionaryCriteria;
import com.jyw.system.service.DataDictionaryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/datadictionary")
public class DatadictionaryController {

    @Autowired
    private DataDictionaryService dataDictionaryService;

    /**
     * 查询数据字典信息
     * @param pageNum
     * @param dataDictionary
     * @param map
     * @return
     */
    @RequestMapping("/list.do")
    public String list(@RequestParam(required = false,defaultValue = "1") int pageNum,
                       DataDictionary dataDictionary,Map<String,Object> map){
        DataDictionaryCriteria criteria = new DataDictionaryCriteria();
        //如果类型不为空则设置模糊查询条件
        if(StringUtils.isNotEmpty(dataDictionary.getDataType())){
            criteria.or()
                    .andDataTypeLike("%" + dataDictionary.getDataType() + "%");
        }
        //分页
        PageHelper.startPage(pageNum,10);
        //查询
        List<DataDictionary> list = dataDictionaryService.selectByExample(criteria);
        //存入分页类中
        PageInfo page = new PageInfo(list);
        //存入
        map.put("page",page);
        map.put("DataDictionary",dataDictionary);

        return "/system/datadictionary/datadictionary_list";
    }

    /**
     * 添加数据字典信息
     * @param dataDictionary
     * @return
     */
    @RequestMapping("/add.do")
    public @ResponseBody String add(@Valid DataDictionary dataDictionary, Errors errors){
        if(errors.getErrorCount() > 0){
            return "请填写完整信息";
        }else {
            int count = dataDictionaryService.insert(dataDictionary);
            if (count > 0)
                return "添加成功";
            else
                return "添加失败";
        }
    }

    /**
     * 删除数据字典信息
     * @param dataId
     * @param pageNum
     * @param dataDictionary
     * @param map
     * @return
     */
    @RequestMapping("/delete.do")
    public String delete(Integer dataId,int pageNum,DataDictionary dataDictionary,Map<String,Object> map){
        int count = dataDictionaryService.deleteByPrimaryKey(dataId);

        if(count > 0){
            map.put("info","删除成功");
        }else{
            map.put("info", "删除失败");
        }

        return list(pageNum,dataDictionary,map);
    }

    /**
     * 加载修改数据字典信息页面
     * @param dataId
     * @param map
     * @return
     */
    @RequestMapping("/load.do")
    public String load(Integer dataId,Map<String,Object> map){

        DataDictionary dataDictionary = dataDictionaryService.selectByPrimaryKey(dataId);
        map.put("data",dataDictionary);
        return "system/datadictionary/datadictionary_update";
    }

    /**
     * 更新数据字典信息
     * @param dataDictionary
     * @param errors
     * @return
     */
    @RequestMapping("/update.do")
    public @ResponseBody String update(@Valid DataDictionary dataDictionary, Errors errors){
        if(errors.getErrorCount() > 0){
            return "请填写完整信息";
        }else {
            int count = dataDictionaryService.updateByPrimaryKey(dataDictionary);
            if (count > 0)
                return "添加成功";
            else
                return "添加失败";
        }
    }
}
