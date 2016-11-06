package com.jyw.classinfo.service;

import com.jyw.model.ClassInfo;
import com.jyw.model.ClassInfoCriteria;
import java.util.List;

public interface ClassInfoService {
    int countByExample(ClassInfoCriteria example);

    ClassInfo selectByPrimaryKey(Integer classId);

    List<ClassInfo> selectByExample(ClassInfoCriteria example);

    int deleteByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);

    int deleteByExample(ClassInfoCriteria example);

    int updateByExampleSelective(ClassInfo record, ClassInfoCriteria example);

    int updateByExample(ClassInfo record, ClassInfoCriteria example);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);
}