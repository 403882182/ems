package com.jyw.classinfo.service;

import com.jyw.model.DisciplineInfo;
import com.jyw.model.DisciplineInfoCriteria;
import java.util.List;

public interface DisciplineInfoService {
    int countByExample(DisciplineInfoCriteria example);

    DisciplineInfo selectByPrimaryKey(Integer disciplineId);

    List<DisciplineInfo> selectByExample(DisciplineInfoCriteria example);

    int deleteByPrimaryKey(Integer disciplineId);

    int updateByPrimaryKeySelective(DisciplineInfo record);

    int updateByPrimaryKey(DisciplineInfo record);

    int deleteByExample(DisciplineInfoCriteria example);

    int updateByExampleSelective(DisciplineInfo record, DisciplineInfoCriteria example);

    int updateByExample(DisciplineInfo record, DisciplineInfoCriteria example);

    int insert(DisciplineInfo record);

    int insertSelective(DisciplineInfo record);
}