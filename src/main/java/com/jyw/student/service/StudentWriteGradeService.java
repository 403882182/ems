package com.jyw.student.service;

import com.jyw.model.StudentWriteGrade;
import com.jyw.model.StudentWriteGradeCriteria;
import java.util.List;

public interface StudentWriteGradeService {
    int countByExample(StudentWriteGradeCriteria example);

    StudentWriteGrade selectByPrimaryKey(Integer writeGradeId);

    List<StudentWriteGrade> selectByExample(StudentWriteGradeCriteria example);

    int deleteByPrimaryKey(Integer writeGradeId);

    int updateByPrimaryKeySelective(StudentWriteGrade record);

    int updateByPrimaryKey(StudentWriteGrade record);

    int deleteByExample(StudentWriteGradeCriteria example);

    int updateByExampleSelective(StudentWriteGrade record, StudentWriteGradeCriteria example);

    int updateByExample(StudentWriteGrade record, StudentWriteGradeCriteria example);

    int insert(StudentWriteGrade record);

    int insertSelective(StudentWriteGrade record);
}