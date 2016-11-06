package com.jyw.system.service.impl;

import com.jyw.system.mapper.DataDictionaryMapper;
import com.jyw.model.DataDictionary;
import com.jyw.model.DataDictionaryCriteria;
import com.jyw.system.service.DataDictionaryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    private static final Logger logger = LoggerFactory.getLogger(DataDictionaryServiceImpl.class);

    public int countByExample(DataDictionaryCriteria example) {
        int count = (int)this.dataDictionaryMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public DataDictionary selectByPrimaryKey(Integer dataId) {
        return this.dataDictionaryMapper.selectByPrimaryKey(dataId);
    }

    public List<DataDictionary> selectByExample(DataDictionaryCriteria example) {
        return this.dataDictionaryMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer dataId) {
        return this.dataDictionaryMapper.deleteByPrimaryKey(dataId);
    }

    public int updateByPrimaryKeySelective(DataDictionary record) {
        return this.dataDictionaryMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DataDictionary record) {
        return this.dataDictionaryMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(DataDictionaryCriteria example) {
        return this.dataDictionaryMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(DataDictionary record, DataDictionaryCriteria example) {
        return this.dataDictionaryMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(DataDictionary record, DataDictionaryCriteria example) {
        return this.dataDictionaryMapper.updateByExample(record, example);
    }

    public int insert(DataDictionary record) {
        return this.dataDictionaryMapper.insert(record);
    }

    public int insertSelective(DataDictionary record) {
        return this.dataDictionaryMapper.insertSelective(record);
    }
}