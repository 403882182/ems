package com.jyw.classinfo.service;

import com.jyw.model.SyllabusInfo;
import com.jyw.model.SyllabusInfoCriteria;
import java.util.List;

public interface SyllabusInfoService {
    int countByExample(SyllabusInfoCriteria example);

    SyllabusInfo selectByPrimaryKey(Integer syllabusId);

    List<SyllabusInfo> selectByExample(SyllabusInfoCriteria example);

    int deleteByPrimaryKey(Integer syllabusId);

    int updateByPrimaryKeySelective(SyllabusInfo record);

    int updateByPrimaryKey(SyllabusInfo record);

    int deleteByExample(SyllabusInfoCriteria example);

    int updateByExampleSelective(SyllabusInfo record, SyllabusInfoCriteria example);

    int updateByExample(SyllabusInfo record, SyllabusInfoCriteria example);

    int insert(SyllabusInfo record);

    int insertSelective(SyllabusInfo record);
}