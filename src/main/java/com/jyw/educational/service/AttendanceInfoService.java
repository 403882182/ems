package com.jyw.educational.service;

import com.jyw.model.AttendanceInfo;
import com.jyw.model.AttendanceInfoCriteria;
import com.jyw.model.StudentInfo;

import java.util.List;

public interface AttendanceInfoService {
//查询所有学员考勤信息
    List<AttendanceInfo> selectAttendance(String studentName,Integer staffId);
    //查找学生表中所有学员信息
    List<StudentInfo> selectStudent();

    int countByExample(AttendanceInfoCriteria example);

    AttendanceInfo selectByPrimaryKey(Integer attendanceId);

    List<AttendanceInfo> selectByExample(AttendanceInfoCriteria example);
    //根据id删除考勤信息
    int deleteByPrimaryKey(Integer attendanceId);

    int updateByPrimaryKeySelective(AttendanceInfo record);

    /**
     * 修改考勤
     * @param record
     * @return
     */
    int updateByPrimaryKey(AttendanceInfo record);

    int deleteByExample(AttendanceInfoCriteria example);

    int updateByExampleSelective(AttendanceInfo record, AttendanceInfoCriteria example);

    int updateByExample(AttendanceInfo record, AttendanceInfoCriteria example);

    int insert(AttendanceInfo record);

    int insertSelective(AttendanceInfo record);
}