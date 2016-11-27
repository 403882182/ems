package com.jyw.student.service.impl;

import com.jyw.model.CommunicateInfoEx;
import com.jyw.model.StudentInfo;
import com.jyw.student.mapper.CommunicateInfoMapper;
import com.jyw.model.CommunicateInfo;
import com.jyw.model.CommunicateInfoCriteria;
import com.jyw.student.service.CommunicateInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunicateInfoServiceImpl implements CommunicateInfoService {
    @Autowired
    private CommunicateInfoMapper communicateInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(CommunicateInfoServiceImpl.class);

    public int countByExample(CommunicateInfoCriteria example) {
        int count = (int)this.communicateInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public CommunicateInfo selectByPrimaryKey(Integer communicateId) {
        return this.communicateInfoMapper.selectByPrimaryKey(communicateId);
    }

    public List<CommunicateInfo> selectByExample(CommunicateInfoCriteria example) {
        return this.communicateInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer communicateId) {
        return this.communicateInfoMapper.deleteByPrimaryKey(communicateId);
    }

    public int updateByPrimaryKeySelective(CommunicateInfo record) {
        return this.communicateInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(CommunicateInfo record) {
        return this.communicateInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(CommunicateInfoCriteria example) {
        return this.communicateInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(CommunicateInfo record, CommunicateInfoCriteria example) {
        return this.communicateInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(CommunicateInfo record, CommunicateInfoCriteria example) {
        return this.communicateInfoMapper.updateByExample(record, example);
    }

    public int insert(CommunicateInfo record) {
        return this.communicateInfoMapper.insert(record);
    }

    public int insertSelective(CommunicateInfo record) {
        return this.communicateInfoMapper.insertSelective(record);
    }

    @Override
    public List<CommunicateInfoEx> selectAllCommunicateInfo(CommunicateInfoEx communicateInfoEx){
        return  this.communicateInfoMapper.selectAllCommunicateInfo(communicateInfoEx);
    }
    @Override
  public   List<StudentInfo> GetStdentBystaffId(Integer staffId){
      return  this.communicateInfoMapper.GetStdentBystaffId(staffId);
  }
}