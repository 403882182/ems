
package com.jyw.student.mapper;

import com.jyw.model.EvaluationInfo;
import com.jyw.model.EvaluationInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluationInfoMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(EvaluationInfoCriteria example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(EvaluationInfoCriteria example);

    /** 
     * 根据主键删除数据库的记录
     * @param evaluationId
     */
    int deleteByPrimaryKey(Integer evaluationId);

    /** 
     * 插入数据库记录
     * @param record
     */
    int insert(EvaluationInfo record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(EvaluationInfo record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<EvaluationInfo> selectByExample(EvaluationInfoCriteria example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param evaluationId
     */
    EvaluationInfo selectByPrimaryKey(Integer evaluationId);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") EvaluationInfo record, @Param("example") EvaluationInfoCriteria example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") EvaluationInfo record, @Param("example") EvaluationInfoCriteria example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(EvaluationInfo record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(EvaluationInfo record);
}