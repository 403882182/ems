package com.jyw.student.service;

import com.jyw.model.CommunicateInfo;
import com.jyw.model.CommunicateInfoCriteria;
import java.util.List;

public interface CommunicateInfoService {
    int countByExample(CommunicateInfoCriteria example);

    CommunicateInfo selectByPrimaryKey(Integer communicateId);

    List<CommunicateInfo> selectByExample(CommunicateInfoCriteria example);

    int deleteByPrimaryKey(Integer communicateId);

    int updateByPrimaryKeySelective(CommunicateInfo record);

    int updateByPrimaryKey(CommunicateInfo record);

    int deleteByExample(CommunicateInfoCriteria example);

    int updateByExampleSelective(CommunicateInfo record, CommunicateInfoCriteria example);

    int updateByExample(CommunicateInfo record, CommunicateInfoCriteria example);

    int insert(CommunicateInfo record);

    int insertSelective(CommunicateInfo record);
}