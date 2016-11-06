package com.jyw.classinfo.service;

import com.jyw.model.ClassroomInfo;
import com.jyw.model.ClassroomInfoCriteria;
import java.util.List;

public interface ClassroomInfoService {
    int countByExample(ClassroomInfoCriteria example);

    ClassroomInfo selectByPrimaryKey(Integer classroomId);

    List<ClassroomInfo> selectByExample(ClassroomInfoCriteria example);

    int deleteByPrimaryKey(Integer classroomId);

    int updateByPrimaryKeySelective(ClassroomInfo record);

    int updateByPrimaryKey(ClassroomInfo record);

    int deleteByExample(ClassroomInfoCriteria example);

    int updateByExampleSelective(ClassroomInfo record, ClassroomInfoCriteria example);

    int updateByExample(ClassroomInfo record, ClassroomInfoCriteria example);

    int insert(ClassroomInfo record);

    int insertSelective(ClassroomInfo record);
}