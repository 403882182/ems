package com.jyw.marketing.service;

import com.jyw.model.TemplateInfo;
import com.jyw.model.TemplateInfoCriteria;
import java.util.List;

public interface TemplateInfoService {
    int countByExample(TemplateInfoCriteria example);

    TemplateInfo selectByPrimaryKey(Integer templateId);

    List<TemplateInfo> selectByExample(TemplateInfoCriteria example);

    int deleteByPrimaryKey(Integer templateId);

    int updateByPrimaryKeySelective(TemplateInfo record);

    int updateByPrimaryKey(TemplateInfo record);

    int deleteByExample(TemplateInfoCriteria example);

    int updateByExampleSelective(TemplateInfo record, TemplateInfoCriteria example);

    int updateByExample(TemplateInfo record, TemplateInfoCriteria example);

    int insert(TemplateInfo record);

    int insertSelective(TemplateInfo record);
}