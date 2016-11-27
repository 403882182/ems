package com.jyw.recruitstudent.service.impl;

import com.jyw.recruitstudent.mapper.AuditionInfoMapper;
import com.jyw.model.AuditionInfo;
import com.jyw.model.AuditionInfoCriteria;
import com.jyw.recruitstudent.service.AuditionInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditionInfoServiceImpl implements AuditionInfoService {
    @Autowired
    private AuditionInfoMapper auditionInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(AuditionInfoServiceImpl.class);

    public int countByExample(AuditionInfoCriteria example) {
        int count = (int)this.auditionInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public AuditionInfo selectByPrimaryKey(Integer auditionId) {
        return this.auditionInfoMapper.selectByPrimaryKey(auditionId);
    }

    public List<AuditionInfo> selectByExample(AuditionInfoCriteria example) {
        return this.auditionInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer auditionId) {
        return this.auditionInfoMapper.deleteByPrimaryKey(auditionId);
    }

    public int updateByPrimaryKeySelective(AuditionInfo record) {
        return this.auditionInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AuditionInfo record) {
        return this.auditionInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(AuditionInfoCriteria example) {
        return this.auditionInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(AuditionInfo record, AuditionInfoCriteria example) {
        return this.auditionInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(AuditionInfo record, AuditionInfoCriteria example) {
        return this.auditionInfoMapper.updateByExample(record, example);
    }

    public int insert(AuditionInfo record) {
        return this.auditionInfoMapper.insert(record);
    }

    public int insertSelective(AuditionInfo record) {
        return this.auditionInfoMapper.insertSelective(record);
    }

    public List<AuditionInfo> getAuditionList(String name,AuditionInfo info,Integer staffId){return this.auditionInfoMapper.getAuditionList(name,info,staffId);}
}