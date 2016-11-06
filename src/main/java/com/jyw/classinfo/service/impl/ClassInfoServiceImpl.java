package com.jyw.classinfo.service.impl;

import com.jyw.classinfo.mapper.ClassInfoMapper;
import com.jyw.model.ClassInfo;
import com.jyw.model.ClassInfoCriteria;
import com.jyw.classinfo.service.ClassInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(ClassInfoServiceImpl.class);

    public int countByExample(ClassInfoCriteria example) {
        int count = (int)this.classInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public ClassInfo selectByPrimaryKey(Integer classId) {
        return this.classInfoMapper.selectByPrimaryKey(classId);
    }

    public List<ClassInfo> selectByExample(ClassInfoCriteria example) {
        return this.classInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer classId) {
        return this.classInfoMapper.deleteByPrimaryKey(classId);
    }

    public int updateByPrimaryKeySelective(ClassInfo record) {
        return this.classInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ClassInfo record) {
        return this.classInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(ClassInfoCriteria example) {
        return this.classInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(ClassInfo record, ClassInfoCriteria example) {
        return this.classInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(ClassInfo record, ClassInfoCriteria example) {
        return this.classInfoMapper.updateByExample(record, example);
    }

    public int insert(ClassInfo record) {
        return this.classInfoMapper.insert(record);
    }

    public int insertSelective(ClassInfo record) {
        return this.classInfoMapper.insertSelective(record);
    }
}