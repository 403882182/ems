
package com.jyw.finance.mapper;

import com.jyw.model.StudentPayment;
import com.jyw.model.StudentPaymentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentPaymentMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(StudentPaymentCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(StudentPaymentCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param paymentId
     */
    int deleteByPrimaryKey(Integer paymentId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(StudentPayment record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(StudentPayment record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<StudentPayment> selectByExample(StudentPaymentCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param paymentId
     */
    StudentPayment selectByPrimaryKey(Integer paymentId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") StudentPayment record, @Param("example") StudentPaymentCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") StudentPayment record, @Param("example") StudentPaymentCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(StudentPayment record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(StudentPayment record);
}