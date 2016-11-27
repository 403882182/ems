
package com.jyw.student.mapper;

import com.jyw.model.CommunicateInfo;
import com.jyw.model.CommunicateInfoCriteria;
import java.util.List;

import com.jyw.model.CommunicateInfoEx;
import com.jyw.model.StudentInfo;
import org.apache.ibatis.annotations.Param;

public interface CommunicateInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(CommunicateInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(CommunicateInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param communicateId
     */
    int deleteByPrimaryKey(Integer communicateId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(CommunicateInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(CommunicateInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<CommunicateInfo> selectByExample(CommunicateInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param communicateId
     */
    CommunicateInfo selectByPrimaryKey(Integer communicateId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") CommunicateInfo record, @Param("example") CommunicateInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") CommunicateInfo record, @Param("example") CommunicateInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(CommunicateInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(CommunicateInfo record);

    /**
     * 获取所有的咨询信息
     * @param communicateInfoEx
     * @return
     */
    List<CommunicateInfoEx> selectAllCommunicateInfo(CommunicateInfoEx communicateInfoEx);

    /**
     * 获取负责人的负责的学生
     * @param staffId
     * @return
     */
    List<StudentInfo> GetStdentBystaffId(Integer staffId);
}