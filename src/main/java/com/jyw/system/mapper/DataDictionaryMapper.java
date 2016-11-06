
package com.jyw.system.mapper;

import com.jyw.model.DataDictionary;
import com.jyw.model.DataDictionaryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataDictionaryMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(DataDictionaryCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(DataDictionaryCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param dataId
     */
    int deleteByPrimaryKey(Integer dataId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(DataDictionary record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(DataDictionary record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<DataDictionary> selectByExample(DataDictionaryCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param dataId
     */
    DataDictionary selectByPrimaryKey(Integer dataId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") DataDictionary record, @Param("example") DataDictionaryCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") DataDictionary record, @Param("example") DataDictionaryCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(DataDictionary record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(DataDictionary record);
}