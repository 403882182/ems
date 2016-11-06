
package com.jyw.system.mapper;

import com.jyw.model.RoleAnthorityInfo;
import com.jyw.model.RoleAnthorityInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAnthorityInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(RoleAnthorityInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(RoleAnthorityInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param roleAnthorityId
     */
    int deleteByPrimaryKey(Integer roleAnthorityId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(RoleAnthorityInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(RoleAnthorityInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<RoleAnthorityInfo> selectByExample(RoleAnthorityInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param roleAnthorityId
     */
    RoleAnthorityInfo selectByPrimaryKey(Integer roleAnthorityId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") RoleAnthorityInfo record, @Param("example") RoleAnthorityInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") RoleAnthorityInfo record, @Param("example") RoleAnthorityInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(RoleAnthorityInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(RoleAnthorityInfo record);
}