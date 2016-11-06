
package com.jyw.classinfo.mapper;

import com.jyw.model.ClassInfo;
import com.jyw.model.ClassInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(ClassInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(ClassInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param classId
     */
    int deleteByPrimaryKey(Integer classId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(ClassInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(ClassInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<ClassInfo> selectByExample(ClassInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param classId
     */
    ClassInfo selectByPrimaryKey(Integer classId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ClassInfo record, @Param("example") ClassInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ClassInfo record, @Param("example") ClassInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(ClassInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(ClassInfo record);
}