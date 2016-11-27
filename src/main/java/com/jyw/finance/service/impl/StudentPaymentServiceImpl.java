package com.jyw.finance.service.impl;

import com.jyw.finance.mapper.StudentPaymentMapper;
import com.jyw.model.StudentInfo;
import com.jyw.model.StudentPayment;
import com.jyw.model.StudentPaymentCriteria;
import com.jyw.finance.service.StudentPaymentService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentPaymentServiceImpl implements StudentPaymentService {
    @Autowired
    private StudentPaymentMapper studentPaymentMapper;

    private static final Logger logger = LoggerFactory.getLogger(StudentPaymentServiceImpl.class);

   /* @Override
    public List<StudentPayment> getList(StudentPayment info) {
        // TODO Auto-generated method stub
        return studentPaymentMapper.getStudentPaymentList(info);
    }*/

   public  List<StudentInfo> selectByKeyName(String keyword, int studentSate,Integer staffId){

     return  studentPaymentMapper.selectByKeyName(keyword,studentSate,staffId);
   }
    public int countByExample(StudentPaymentCriteria example) {
        int count = (int)this.studentPaymentMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public StudentPayment selectByPrimaryKey(Integer paymentId) {
        return this.studentPaymentMapper.selectByPrimaryKey(paymentId);
    }

    public List<StudentPayment> selectByExample(StudentPaymentCriteria example) {
        return this.studentPaymentMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer paymentId) {
        return this.studentPaymentMapper.deleteByPrimaryKey(paymentId);
    }

    public int updateByPrimaryKeySelective(StudentPayment record) {
        return this.studentPaymentMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(StudentPayment record) {
        return this.studentPaymentMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(StudentPaymentCriteria example) {
        return this.studentPaymentMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(StudentPayment record, StudentPaymentCriteria example) {
        return this.studentPaymentMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(StudentPayment record, StudentPaymentCriteria example) {
        return this.studentPaymentMapper.updateByExample(record, example);
    }

    public int insert(StudentPayment record) {
        return this.studentPaymentMapper.insert(record);
    }

    public int insertSelective(StudentPayment record) {
        return this.studentPaymentMapper.insertSelective(record);
    }
}