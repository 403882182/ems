package com.jyw.recruitstudent.service.impl;

import com.jyw.recruitstudent.mapper.TrackRecordInfoMapper;
import com.jyw.model.TrackRecordInfo;
import com.jyw.model.TrackRecordInfoCriteria;
import com.jyw.recruitstudent.service.TrackRecordInfoService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TrackRecordInfoServiceImpl implements TrackRecordInfoService {
    @Autowired
    private TrackRecordInfoMapper trackRecordInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(TrackRecordInfoServiceImpl.class);

    public int countByExample(TrackRecordInfoCriteria example) {
        int count = (int) this.trackRecordInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TrackRecordInfo selectByPrimaryKey(Integer trackRecordId) {
        return this.trackRecordInfoMapper.selectByPrimaryKey(trackRecordId);
    }

    public List<TrackRecordInfo> selectByExample(TrackRecordInfoCriteria example) {
        return this.trackRecordInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer trackRecordId) {
        return this.trackRecordInfoMapper.deleteByPrimaryKey(trackRecordId);
    }

    public int updateByPrimaryKeySelective(TrackRecordInfo record) {
        return this.trackRecordInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TrackRecordInfo record) {
        return this.trackRecordInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(TrackRecordInfoCriteria example) {
        return this.trackRecordInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(TrackRecordInfo record, TrackRecordInfoCriteria example) {
        return this.trackRecordInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(TrackRecordInfo record, TrackRecordInfoCriteria example) {
        return this.trackRecordInfoMapper.updateByExample(record, example);
    }

    public int insert(TrackRecordInfo record) {
        return this.trackRecordInfoMapper.insert(record);
    }

    public int insertSelective(TrackRecordInfo record) {
        return this.trackRecordInfoMapper.insertSelective(record);
    }

    public List<TrackRecordInfo> selectByTrackRecordInfo(String name, TrackRecordInfo trackRecordInfo,Integer staffId) {
        return this.trackRecordInfoMapper.selectByTrackRecordInfo(name, trackRecordInfo,staffId);
    }

    public List<TrackRecordInfo> selectByStudentId(TrackRecordInfo trackRecordInfo) {
        return this.trackRecordInfoMapper.selectByStudentId(trackRecordInfo);
    }
}