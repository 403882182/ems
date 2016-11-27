
package com.jyw.finance.mapper;

import com.jyw.model.StaffSalary;
import com.jyw.model.StaffSalaryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffSalaryMapper {

    List<StaffSalary> selectByName(@Param("staffName")String staffName);

    List<StaffSalary> getStaffSalaryList(@Param("staffName")String staffName);
    /**
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(StaffSalaryCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(StaffSalaryCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param staffSalaryId
     */
    int deleteByPrimaryKey(Integer staffSalaryId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(StaffSalary record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(StaffSalary record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<StaffSalary> selectByExample(StaffSalaryCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param staffSalaryId
     */
    StaffSalary selectByPrimaryKey(Integer staffSalaryId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") StaffSalary record, @Param("example") StaffSalaryCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") StaffSalary record, @Param("example") StaffSalaryCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(StaffSalary record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(StaffSalary record);
}