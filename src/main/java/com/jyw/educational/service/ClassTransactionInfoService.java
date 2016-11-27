package com.jyw.educational.service;

import com.jyw.model.ClassInfo;
import com.jyw.model.ClassTransactionInfo;
import com.jyw.model.ClassTransactionInfoCriteria;
import java.util.List;

public interface ClassTransactionInfoService {
    int countByExample(ClassTransactionInfoCriteria example);

    ClassTransactionInfo selectByPrimaryKey(Integer classTransactionId);

    /**
     * 查询所有班级事务
     * @param class_transaction_title
     * @return
     */
    List<ClassTransactionInfo> selectTransactionInfo(String class_transaction_title);

    /**
     * 查询班级信息
     * @param classTransactionId
     * @return
     */
    List<ClassInfo> selectClassInfo();

    /**
     * 删除班级事务
     * @param classTransactionId
     * @return
     */
    int deleteByPrimaryKey(Integer classTransactionId);

    int updateByPrimaryKeySelective(ClassTransactionInfo record);

    /**
     * 修改班级事务
     * @param record
     * @return
     */
    int updateByPrimaryKey(ClassTransactionInfo record);

    int deleteByExample(ClassTransactionInfoCriteria example);

    int updateByExampleSelective(ClassTransactionInfo record, ClassTransactionInfoCriteria example);

    int updateByExample(ClassTransactionInfo record, ClassTransactionInfoCriteria example);

    /**
     * 添加班级事务信息
     * @param transactionInfo
     * @return
     */
    int insert(ClassTransactionInfo transactionInfo);

    int insertSelective(ClassTransactionInfo record);
}