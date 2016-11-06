package com.jyw.classinfo.service.impl;

import com.jyw.classinfo.mapper.SyllabusInfoMapper;
import com.jyw.model.SyllabusInfo;
import com.jyw.model.SyllabusInfoCriteria;
import com.jyw.classinfo.service.SyllabusInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyllabusInfoServiceImpl implements SyllabusInfoService {
    @Autowired
    private SyllabusInfoMapper syllabusInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(SyllabusInfoServiceImpl.class);

    public int countByExample(SyllabusInfoCriteria example) {
        int count = (int)this.syllabusInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public SyllabusInfo selectByPrimaryKey(Integer syllabusId) {
        return this.syllabusInfoMapper.selectByPrimaryKey(syllabusId);
    }

    public List<SyllabusInfo> selectByExample(SyllabusInfoCriteria example) {
        return this.syllabusInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer syllabusId) {
        return this.syllabusInfoMapper.deleteByPrimaryKey(syllabusId);
    }

    public int updateByPrimaryKeySelective(SyllabusInfo record) {
        return this.syllabusInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SyllabusInfo record) {
        return this.syllabusInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(SyllabusInfoCriteria example) {
        return this.syllabusInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(SyllabusInfo record, SyllabusInfoCriteria example) {
        return this.syllabusInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SyllabusInfo record, SyllabusInfoCriteria example) {
        return this.syllabusInfoMapper.updateByExample(record, example);
    }

    public int insert(SyllabusInfo record) {
        return this.syllabusInfoMapper.insert(record);
    }

    public int insertSelective(SyllabusInfo record) {
        return this.syllabusInfoMapper.insertSelective(record);
    }
}