package com.jyw.classinfo.service.impl;

import com.jyw.classinfo.mapper.DisciplineInfoMapper;
import com.jyw.model.DisciplineInfo;
import com.jyw.model.DisciplineInfoCriteria;
import com.jyw.classinfo.service.DisciplineInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineInfoServiceImpl implements DisciplineInfoService {
    @Autowired
    private DisciplineInfoMapper disciplineInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(DisciplineInfoServiceImpl.class);

    public int countByExample(DisciplineInfoCriteria example) {
        int count = (int)this.disciplineInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public DisciplineInfo selectByPrimaryKey(Integer disciplineId) {
        return this.disciplineInfoMapper.selectByPrimaryKey(disciplineId);
    }

    public List<DisciplineInfo> selectByExample(DisciplineInfoCriteria example) {
        return this.disciplineInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer disciplineId) {
        return this.disciplineInfoMapper.deleteByPrimaryKey(disciplineId);
    }

    public int updateByPrimaryKeySelective(DisciplineInfo record) {
        return this.disciplineInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DisciplineInfo record) {
        return this.disciplineInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(DisciplineInfoCriteria example) {
        return this.disciplineInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(DisciplineInfo record, DisciplineInfoCriteria example) {
        return this.disciplineInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(DisciplineInfo record, DisciplineInfoCriteria example) {
        return this.disciplineInfoMapper.updateByExample(record, example);
    }

    public int insert(DisciplineInfo record) {
        return this.disciplineInfoMapper.insert(record);
    }

    public int insertSelective(DisciplineInfo record) {
        return this.disciplineInfoMapper.insertSelective(record);
    }
}