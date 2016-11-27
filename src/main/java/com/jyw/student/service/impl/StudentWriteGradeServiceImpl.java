package com.jyw.student.service.impl;

import com.jyw.model.StudentWriteGradeEx;
import com.jyw.student.mapper.StudentWriteGradeMapper;
import com.jyw.model.StudentWriteGrade;
import com.jyw.model.StudentWriteGradeCriteria;
import com.jyw.student.service.StudentWriteGradeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentWriteGradeServiceImpl implements StudentWriteGradeService {
    @Autowired
    private StudentWriteGradeMapper studentWriteGradeMapper;

    private static final Logger logger = LoggerFactory.getLogger(StudentWriteGradeServiceImpl.class);

    public int countByExample(StudentWriteGradeCriteria example) {
        int count = (int)this.studentWriteGradeMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public StudentWriteGrade selectByPrimaryKey(Integer writeGradeId) {
        return this.studentWriteGradeMapper.selectByPrimaryKey(writeGradeId);
    }

    public List<StudentWriteGrade> selectByExample(StudentWriteGradeCriteria example) {
        return this.studentWriteGradeMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer writeGradeId) {
        return this.studentWriteGradeMapper.deleteByPrimaryKey(writeGradeId);
    }

    public int updateByPrimaryKeySelective(StudentWriteGrade record) {
        return this.studentWriteGradeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(StudentWriteGrade record) {
        return this.studentWriteGradeMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(StudentWriteGradeCriteria example) {
        return this.studentWriteGradeMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(StudentWriteGrade record, StudentWriteGradeCriteria example) {
        return this.studentWriteGradeMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(StudentWriteGrade record, StudentWriteGradeCriteria example) {
        return this.studentWriteGradeMapper.updateByExample(record, example);
    }

    public int insert(StudentWriteGrade record) {
        return this.studentWriteGradeMapper.insert(record);
    }

    public int insertSelective(StudentWriteGrade record) {
        return this.studentWriteGradeMapper.insertSelective(record);
    }
    public List<StudentWriteGradeEx> Getstudentwritegrade (StudentWriteGradeEx studentWriteGradeEx){
        return  this.studentWriteGradeMapper.Getstudentwritegrade(studentWriteGradeEx);
    }
}