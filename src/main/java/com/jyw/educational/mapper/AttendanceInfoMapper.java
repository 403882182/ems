
package com.jyw.educational.mapper;

import com.jyw.model.AttendanceInfo;
import com.jyw.model.AttendanceInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendanceInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(AttendanceInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(AttendanceInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param attendanceId
     */
    int deleteByPrimaryKey(Integer attendanceId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(AttendanceInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(AttendanceInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<AttendanceInfo> selectByExample(AttendanceInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param attendanceId
     */
    AttendanceInfo selectByPrimaryKey(Integer attendanceId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") AttendanceInfo record, @Param("example") AttendanceInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") AttendanceInfo record, @Param("example") AttendanceInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(AttendanceInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(AttendanceInfo record);
}