package com.jyw.educational.service;

import com.jyw.model.ClassTransactionInfo;
import com.jyw.model.ClassTransactionInfoCriteria;
import java.util.List;

public interface ClassTransactionInfoService {
    int countByExample(ClassTransactionInfoCriteria example);

    ClassTransactionInfo selectByPrimaryKey(Integer classTransactionId);

    List<ClassTransactionInfo> selectByExample(ClassTransactionInfoCriteria example);

    int deleteByPrimaryKey(Integer classTransactionId);

    int updateByPrimaryKeySelective(ClassTransactionInfo record);

    int updateByPrimaryKey(ClassTransactionInfo record);

    int deleteByExample(ClassTransactionInfoCriteria example);

    int updateByExampleSelective(ClassTransactionInfo record, ClassTransactionInfoCriteria example);

    int updateByExample(ClassTransactionInfo record, ClassTransactionInfoCriteria example);

    int insert(ClassTransactionInfo record);

    int insertSelective(ClassTransactionInfo record);
}