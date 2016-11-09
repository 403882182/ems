package com.jyw.system.service.impl;

import com.jyw.system.mapper.AnthortyInfoMapper;
import com.jyw.model.AnthortyInfo;
import com.jyw.model.AnthortyInfoCriteria;
import com.jyw.system.service.AnthortyInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnthortyInfoServiceImpl implements AnthortyInfoService {
    @Autowired
    private AnthortyInfoMapper anthortyInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(AnthortyInfoServiceImpl.class);

    public int countByExample(AnthortyInfoCriteria example) {
        int count = (int)this.anthortyInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public AnthortyInfo selectByPrimaryKey(Integer anthortyId) {
        return this.anthortyInfoMapper.selectByPrimaryKey(anthortyId);
    }

    public List<AnthortyInfo> selectByExample(AnthortyInfoCriteria example) {
        return this.anthortyInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer anthortyId) {
        return this.anthortyInfoMapper.deleteByPrimaryKey(anthortyId);
    }

    public int updateByPrimaryKeySelective(AnthortyInfo record) {
        return this.anthortyInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AnthortyInfo record) {
        return this.anthortyInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(AnthortyInfoCriteria example) {
        return this.anthortyInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(AnthortyInfo record, AnthortyInfoCriteria example) {
        return this.anthortyInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(AnthortyInfo record, AnthortyInfoCriteria example) {
        return this.anthortyInfoMapper.updateByExample(record, example);
    }

    public int insert(AnthortyInfo record) {
        return this.anthortyInfoMapper.insert(record);
    }

    public int insertSelective(AnthortyInfo record) {
        return this.anthortyInfoMapper.insertSelective(record);
    }

    public List<AnthortyInfo> getAnthList(Integer roleId) {
        return this.anthortyInfoMapper.getAnthortyByRoleIdList(roleId);
    }
}