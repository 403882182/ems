package com.jyw.educational.service;

import com.jyw.model.AttendanceInfo;
import com.jyw.model.AttendanceInfoCriteria;
import java.util.List;

public interface AttendanceInfoService {
    int countByExample(AttendanceInfoCriteria example);

    AttendanceInfo selectByPrimaryKey(Integer attendanceId);

    List<AttendanceInfo> selectByExample(AttendanceInfoCriteria example);

    int deleteByPrimaryKey(Integer attendanceId);

    int updateByPrimaryKeySelective(AttendanceInfo record);

    int updateByPrimaryKey(AttendanceInfo record);

    int deleteByExample(AttendanceInfoCriteria example);

    int updateByExampleSelective(AttendanceInfo record, AttendanceInfoCriteria example);

    int updateByExample(AttendanceInfo record, AttendanceInfoCriteria example);

    int insert(AttendanceInfo record);

    int insertSelective(AttendanceInfo record);
}