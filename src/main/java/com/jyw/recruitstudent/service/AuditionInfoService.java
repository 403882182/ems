package com.jyw.recruitstudent.service;

import com.jyw.model.AuditionInfo;
import com.jyw.model.AuditionInfoCriteria;
import java.util.List;

public interface AuditionInfoService {
    int countByExample(AuditionInfoCriteria example);

    AuditionInfo selectByPrimaryKey(Integer auditionId);

    List<AuditionInfo> selectByExample(AuditionInfoCriteria example);

    int deleteByPrimaryKey(Integer auditionId);

    int updateByPrimaryKeySelective(AuditionInfo record);

    int updateByPrimaryKey(AuditionInfo record);

    int deleteByExample(AuditionInfoCriteria example);

    int updateByExampleSelective(AuditionInfo record, AuditionInfoCriteria example);

    int updateByExample(AuditionInfo record, AuditionInfoCriteria example);

    int insert(AuditionInfo record);

    int insertSelective(AuditionInfo record);
}