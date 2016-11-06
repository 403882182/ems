
package com.jyw.student.mapper;

import com.jyw.model.StudentWriteGrade;
import com.jyw.model.StudentWriteGradeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentWriteGradeMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(StudentWriteGradeCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(StudentWriteGradeCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param writeGradeId
     */
    int deleteByPrimaryKey(Integer writeGradeId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(StudentWriteGrade record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(StudentWriteGrade record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<StudentWriteGrade> selectByExample(StudentWriteGradeCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param writeGradeId
     */
    StudentWriteGrade selectByPrimaryKey(Integer writeGradeId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") StudentWriteGrade record, @Param("example") StudentWriteGradeCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") StudentWriteGrade record, @Param("example") StudentWriteGradeCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(StudentWriteGrade record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(StudentWriteGrade record);
}