
package com.jyw.system.mapper;

import com.jyw.model.RoleInfo;
import com.jyw.model.RoleInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(RoleInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(RoleInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param roleId
     */
    int deleteByPrimaryKey(Integer roleId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(RoleInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(RoleInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<RoleInfo> selectByExample(RoleInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param roleId
     */
    RoleInfo selectByPrimaryKey(Integer roleId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") RoleInfo record, @Param("example") RoleInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") RoleInfo record, @Param("example") RoleInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(RoleInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(RoleInfo record);
}