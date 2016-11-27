package com.jyw.finance.service;

import com.jyw.model.StaffSalary;
import com.jyw.model.StaffSalaryCriteria;
import java.util.List;

public interface StaffSalaryService {

    List<StaffSalary> getStaffSalaryList(String staffName);

    List<StaffSalary> selectByName(String staffName);

    int countByExample(StaffSalaryCriteria example);

    StaffSalary selectByPrimaryKey(Integer staffSalaryId);

    List<StaffSalary> selectByExample(StaffSalaryCriteria example);

    int deleteByPrimaryKey(Integer staffSalaryId);

    int updateByPrimaryKeySelective(StaffSalary record);

    int updateByPrimaryKey(StaffSalary record);

    int deleteByExample(StaffSalaryCriteria example);

    int updateByExampleSelective(StaffSalary record, StaffSalaryCriteria example);

    int updateByExample(StaffSalary record, StaffSalaryCriteria example);

    int insert(StaffSalary record);

    int insertSelective(StaffSalary record);
}