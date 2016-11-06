
package com.jyw.system.mapper;

import com.jyw.model.AnthortyInfo;
import com.jyw.model.AnthortyInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnthortyInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(AnthortyInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(AnthortyInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param anthortyId
     */
    int deleteByPrimaryKey(Integer anthortyId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(AnthortyInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(AnthortyInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<AnthortyInfo> selectByExample(AnthortyInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param anthortyId
     */
    AnthortyInfo selectByPrimaryKey(Integer anthortyId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") AnthortyInfo record, @Param("example") AnthortyInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") AnthortyInfo record, @Param("example") AnthortyInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(AnthortyInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(AnthortyInfo record);
}