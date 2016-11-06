package com.jyw.system.service;

import com.jyw.model.DataDictionary;
import com.jyw.model.DataDictionaryCriteria;
import java.util.List;

public interface DataDictionaryService {
    int countByExample(DataDictionaryCriteria example);

    DataDictionary selectByPrimaryKey(Integer dataId);

    List<DataDictionary> selectByExample(DataDictionaryCriteria example);

    int deleteByPrimaryKey(Integer dataId);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);

    int deleteByExample(DataDictionaryCriteria example);

    int updateByExampleSelective(DataDictionary record, DataDictionaryCriteria example);

    int updateByExample(DataDictionary record, DataDictionaryCriteria example);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);
}