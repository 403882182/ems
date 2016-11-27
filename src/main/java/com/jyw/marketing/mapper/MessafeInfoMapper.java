
package com.jyw.marketing.mapper;

import com.jyw.model.MarketActiveEx;
import com.jyw.model.MessafeInfo;
import com.jyw.model.MessafeInfoCriteria;
import java.util.List;

import com.jyw.model.MessfeInfoEx;
import org.apache.ibatis.annotations.Param;

public interface MessafeInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(MessafeInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(MessafeInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param messafeId
     */
    int deleteByPrimaryKey(Integer messafeId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(MessafeInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(MessafeInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<MessafeInfo> selectByExample(MessafeInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param messafeId
     */
    MessafeInfo selectByPrimaryKey(Integer messafeId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") MessafeInfo record, @Param("example") MessafeInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") MessafeInfo record, @Param("example") MessafeInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(MessafeInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(MessafeInfo record);

    List<MessfeInfoEx>  selectAllMesssfeInfo(MessfeInfoEx marketActiveEx);

}