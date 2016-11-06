package com.jyw.recruitstudent.service;

import com.jyw.model.StudentInfo;
import com.jyw.model.StudentInfoCriteria;
import java.util.List;

public interface StudentInfoService {
    int countByExample(StudentInfoCriteria example);

    StudentInfo selectByPrimaryKey(Integer studentId);

    List<StudentInfo> selectByExample(StudentInfoCriteria example);

    int deleteByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);

    int deleteByExample(StudentInfoCriteria example);

    int updateByExampleSelective(StudentInfo record, StudentInfoCriteria example);

    int updateByExample(StudentInfo record, StudentInfoCriteria example);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);
}