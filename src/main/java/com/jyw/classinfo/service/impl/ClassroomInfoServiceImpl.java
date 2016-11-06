package com.jyw.classinfo.service.impl;

import com.jyw.classinfo.mapper.ClassroomInfoMapper;
import com.jyw.model.ClassroomInfo;
import com.jyw.model.ClassroomInfoCriteria;
import com.jyw.classinfo.service.ClassroomInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomInfoServiceImpl implements ClassroomInfoService {
    @Autowired
    private ClassroomInfoMapper classroomInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(ClassroomInfoServiceImpl.class);

    public int countByExample(ClassroomInfoCriteria example) {
        int count = (int)this.classroomInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public ClassroomInfo selectByPrimaryKey(Integer classroomId) {
        return this.classroomInfoMapper.selectByPrimaryKey(classroomId);
    }

    public List<ClassroomInfo> selectByExample(ClassroomInfoCriteria example) {
        return this.classroomInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer classroomId) {
        return this.classroomInfoMapper.deleteByPrimaryKey(classroomId);
    }

    public int updateByPrimaryKeySelective(ClassroomInfo record) {
        return this.classroomInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ClassroomInfo record) {
        return this.classroomInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(ClassroomInfoCriteria example) {
        return this.classroomInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(ClassroomInfo record, ClassroomInfoCriteria example) {
        return this.classroomInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(ClassroomInfo record, ClassroomInfoCriteria example) {
        return this.classroomInfoMapper.updateByExample(record, example);
    }

    public int insert(ClassroomInfo record) {
        return this.classroomInfoMapper.insert(record);
    }

    public int insertSelective(ClassroomInfo record) {
        return this.classroomInfoMapper.insertSelective(record);
    }
}