package com.jyw.finance.service;

import com.jyw.model.StudentPayment;
import com.jyw.model.StudentPaymentCriteria;
import java.util.List;

public interface StudentPaymentService {
    int countByExample(StudentPaymentCriteria example);

    StudentPayment selectByPrimaryKey(Integer paymentId);

    List<StudentPayment> selectByExample(StudentPaymentCriteria example);

    int deleteByPrimaryKey(Integer paymentId);

    int updateByPrimaryKeySelective(StudentPayment record);

    int updateByPrimaryKey(StudentPayment record);

    int deleteByExample(StudentPaymentCriteria example);

    int updateByExampleSelective(StudentPayment record, StudentPaymentCriteria example);

    int updateByExample(StudentPayment record, StudentPaymentCriteria example);

    int insert(StudentPayment record);

    int insertSelective(StudentPayment record);
}