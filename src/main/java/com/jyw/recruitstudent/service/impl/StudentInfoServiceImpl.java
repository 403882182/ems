package com.jyw.recruitstudent.service.impl;

import com.jyw.recruitstudent.mapper.StudentInfoMapper;
import com.jyw.model.StudentInfo;
import com.jyw.model.StudentInfoCriteria;
import com.jyw.recruitstudent.service.StudentInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    /**
     *
     */
    @Autowired
    private StudentInfoMapper studentInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(StudentInfoServiceImpl.class);

    public int countByExample(StudentInfoCriteria example) {
        int count = (int)this.studentInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public StudentInfo selectByPrimaryKey(Integer studentId) {
        return this.studentInfoMapper.selectByPrimaryKey(studentId);
    }

    public List<StudentInfo> selectByExample(StudentInfoCriteria example) {
        return this.studentInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer studentId) {
        return this.studentInfoMapper.deleteByPrimaryKey(studentId);
    }

    public int updateByPrimaryKeySelective(StudentInfo record) {
        return this.studentInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(StudentInfo record) {
        return this.studentInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(StudentInfoCriteria example) {
        return this.studentInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(StudentInfo record, StudentInfoCriteria example) {
        return this.studentInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(StudentInfo record, StudentInfoCriteria example) {
        return this.studentInfoMapper.updateByExample(record, example);
    }

    public int insert(StudentInfo record) {
        return this.studentInfoMapper.insert(record);
    }

    public int insertSelective(StudentInfo record) {
        return this.studentInfoMapper.insertSelective(record);
    }
}