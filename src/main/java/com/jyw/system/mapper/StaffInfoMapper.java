
package com.jyw.system.mapper;

import com.jyw.model.StaffInfo;
import com.jyw.model.StaffInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(StaffInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(StaffInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param staffId
     */
    int deleteByPrimaryKey(Integer staffId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(StaffInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(StaffInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<StaffInfo> selectByExample(StaffInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param staffId
     */
    StaffInfo selectByPrimaryKey(Integer staffId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") StaffInfo record, @Param("example") StaffInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") StaffInfo record, @Param("example") StaffInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(StaffInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(StaffInfo record);

    /**
     * 根据员工信息获取员工列表
     * @param record
     * @return
     */
    List<StaffInfo> getStaffInfoList(StaffInfo record);
}