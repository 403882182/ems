
package com.jyw.recruitstudent.mapper;

import com.jyw.model.TrackRecordInfo;
import com.jyw.model.TrackRecordInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrackRecordInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(TrackRecordInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(TrackRecordInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param trackRecordId
     */
    int deleteByPrimaryKey(Integer trackRecordId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(TrackRecordInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(TrackRecordInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<TrackRecordInfo> selectByExample(TrackRecordInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param trackRecordId
     */
    TrackRecordInfo selectByPrimaryKey(Integer trackRecordId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") TrackRecordInfo record, @Param("example") TrackRecordInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") TrackRecordInfo record, @Param("example") TrackRecordInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(TrackRecordInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(TrackRecordInfo record);

    /**
     * 三表查询跟踪记录
     */
    List<TrackRecordInfo> selectByTrackRecordInfo(@Param("studentName") String name,@Param("enrollment") TrackRecordInfo trackRecordInfo,@Param("staffId") Integer staffId);

    /**
     * 根据学员id来查
     */
    List<TrackRecordInfo> selectByStudentId(@Param("track") TrackRecordInfo trackRecordInfo);
}