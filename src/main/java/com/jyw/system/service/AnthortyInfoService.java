package com.jyw.system.service;

import com.jyw.model.AnthortyInfo;
import com.jyw.model.AnthortyInfoCriteria;
import java.util.List;

public interface AnthortyInfoService {
    int countByExample(AnthortyInfoCriteria example);

    AnthortyInfo selectByPrimaryKey(Integer anthortyId);

    List<AnthortyInfo> selectByExample(AnthortyInfoCriteria example);

    int deleteByPrimaryKey(Integer anthortyId);

    int updateByPrimaryKeySelective(AnthortyInfo record);

    int updateByPrimaryKey(AnthortyInfo record);

    int deleteByExample(AnthortyInfoCriteria example);

    int updateByExampleSelective(AnthortyInfo record, AnthortyInfoCriteria example);

    int updateByExample(AnthortyInfo record, AnthortyInfoCriteria example);

    int insert(AnthortyInfo record);

    int insertSelective(AnthortyInfo record);
}