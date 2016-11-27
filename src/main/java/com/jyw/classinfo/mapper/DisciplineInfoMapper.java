
package com.jyw.classinfo.mapper;

import com.jyw.model.DisciplineInfo;
import com.jyw.model.DisciplineInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DisciplineInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(DisciplineInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(DisciplineInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param disciplineId
     */
    int deleteByPrimaryKey(Integer disciplineId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(DisciplineInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(DisciplineInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<DisciplineInfo> selectByExample(DisciplineInfoCriteria example);


    /** 
     * 根据指定主键获取一条数据库记录
     * @param disciplineId
     */
    DisciplineInfo selectByPrimaryKey(Integer disciplineId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") DisciplineInfo record, @Param("example") DisciplineInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") DisciplineInfo record, @Param("example") DisciplineInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(DisciplineInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(DisciplineInfo record);
}