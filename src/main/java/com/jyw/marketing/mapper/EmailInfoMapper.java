
package com.jyw.marketing.mapper;

import com.jyw.model.EmailInfo;
import com.jyw.model.EmailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(EmailInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(EmailInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param emailId
     */
    int deleteByPrimaryKey(Integer emailId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(EmailInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(EmailInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<EmailInfo> selectByExample(EmailInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param emailId
     */
    EmailInfo selectByPrimaryKey(Integer emailId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") EmailInfo record, @Param("example") EmailInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") EmailInfo record, @Param("example") EmailInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(EmailInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(EmailInfo record);
}