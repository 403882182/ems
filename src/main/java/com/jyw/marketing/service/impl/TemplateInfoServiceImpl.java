package com.jyw.marketing.service.impl;

import com.jyw.marketing.mapper.TemplateInfoMapper;
import com.jyw.model.TemplateInfo;
import com.jyw.model.TemplateInfoCriteria;
import com.jyw.marketing.service.TemplateInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateInfoServiceImpl implements TemplateInfoService {
    @Autowired
    private TemplateInfoMapper templateInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(TemplateInfoServiceImpl.class);

    public int countByExample(TemplateInfoCriteria example) {
        int count = (int)this.templateInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TemplateInfo selectByPrimaryKey(Integer templateId) {
        return this.templateInfoMapper.selectByPrimaryKey(templateId);
    }

    public List<TemplateInfo> selectByExample(TemplateInfoCriteria example) {
        return this.templateInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer templateId) {
        return this.templateInfoMapper.deleteByPrimaryKey(templateId);
    }

    public int updateByPrimaryKeySelective(TemplateInfo record) {
        return this.templateInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TemplateInfo record) {
        return this.templateInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(TemplateInfoCriteria example) {
        return this.templateInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(TemplateInfo record, TemplateInfoCriteria example) {
        return this.templateInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(TemplateInfo record, TemplateInfoCriteria example) {
        return this.templateInfoMapper.updateByExample(record, example);
    }

    public int insert(TemplateInfo record) {
        return this.templateInfoMapper.insert(record);
    }

    public int insertSelective(TemplateInfo record) {
        return this.templateInfoMapper.insertSelective(record);
    }
}