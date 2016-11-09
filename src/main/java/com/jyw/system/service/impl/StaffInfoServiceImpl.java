package com.jyw.system.service.impl;

import com.jyw.system.mapper.StaffInfoMapper;
import com.jyw.model.StaffInfo;
import com.jyw.model.StaffInfoCriteria;
import com.jyw.system.service.StaffInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffInfoServiceImpl implements StaffInfoService {
    @Autowired
    private StaffInfoMapper staffInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(StaffInfoServiceImpl.class);

    public int countByExample(StaffInfoCriteria example) {
        int count = (int)this.staffInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public StaffInfo selectByPrimaryKey(Integer staffId) {
        return this.staffInfoMapper.selectByPrimaryKey(staffId);
    }

    public List<StaffInfo> selectByExample(StaffInfoCriteria example) {
        return this.staffInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer staffId) {
        return this.staffInfoMapper.deleteByPrimaryKey(staffId);
    }

    public int updateByPrimaryKeySelective(StaffInfo record) {
        return this.staffInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(StaffInfo record) {
        return this.staffInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(StaffInfoCriteria example) {
        return this.staffInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(StaffInfo record, StaffInfoCriteria example) {
        return this.staffInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(StaffInfo record, StaffInfoCriteria example) {
        return this.staffInfoMapper.updateByExample(record, example);
    }

    public int insert(StaffInfo record) {
        return this.staffInfoMapper.insert(record);
    }

    public int insertSelective(StaffInfo record) {
        return this.staffInfoMapper.insertSelective(record);
    }

    @Override
    public List<StaffInfo> getStaffList(StaffInfo record) {
        return this.staffInfoMapper.getStaffInfoList(record);
    }
}