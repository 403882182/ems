package com.jyw.educational.service.impl;

import com.jyw.educational.mapper.ClassTransactionInfoMapper;
import com.jyw.model.ClassTransactionInfo;
import com.jyw.model.ClassTransactionInfoCriteria;
import com.jyw.educational.service.ClassTransactionInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassTransactionInfoServiceImpl implements ClassTransactionInfoService {
    @Autowired
    private ClassTransactionInfoMapper classTransactionInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(ClassTransactionInfoServiceImpl.class);

    public int countByExample(ClassTransactionInfoCriteria example) {
        int count = (int)this.classTransactionInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public ClassTransactionInfo selectByPrimaryKey(Integer classTransactionId) {
        return this.classTransactionInfoMapper.selectByPrimaryKey(classTransactionId);
    }

    public List<ClassTransactionInfo> selectByExample(ClassTransactionInfoCriteria example) {
        return this.classTransactionInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer classTransactionId) {
        return this.classTransactionInfoMapper.deleteByPrimaryKey(classTransactionId);
    }

    public int updateByPrimaryKeySelective(ClassTransactionInfo record) {
        return this.classTransactionInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ClassTransactionInfo record) {
        return this.classTransactionInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(ClassTransactionInfoCriteria example) {
        return this.classTransactionInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(ClassTransactionInfo record, ClassTransactionInfoCriteria example) {
        return this.classTransactionInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(ClassTransactionInfo record, ClassTransactionInfoCriteria example) {
        return this.classTransactionInfoMapper.updateByExample(record, example);
    }

    public int insert(ClassTransactionInfo record) {
        return this.classTransactionInfoMapper.insert(record);
    }

    public int insertSelective(ClassTransactionInfo record) {
        return this.classTransactionInfoMapper.insertSelective(record);
    }
}