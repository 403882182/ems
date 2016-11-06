package com.jyw.system.service;

import com.jyw.model.StaffInfo;
import com.jyw.model.StaffInfoCriteria;
import java.util.List;

public interface StaffInfoService {
    int countByExample(StaffInfoCriteria example);

    StaffInfo selectByPrimaryKey(Integer staffId);

    List<StaffInfo> selectByExample(StaffInfoCriteria example);

    int deleteByPrimaryKey(Integer staffId);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);

    int deleteByExample(StaffInfoCriteria example);

    int updateByExampleSelective(StaffInfo record, StaffInfoCriteria example);

    int updateByExample(StaffInfo record, StaffInfoCriteria example);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);
}