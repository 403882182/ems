package com.jyw.finance.service.impl;

import com.jyw.finance.mapper.StaffSalaryMapper;
import com.jyw.model.StaffSalary;
import com.jyw.model.StaffSalaryCriteria;
import com.jyw.finance.service.StaffSalaryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffSalaryServiceImpl implements StaffSalaryService {
    @Autowired
    private StaffSalaryMapper staffSalaryMapper;

    private static final Logger logger = LoggerFactory.getLogger(StaffSalaryServiceImpl.class);

    public int countByExample(StaffSalaryCriteria example) {
        int count = (int)this.staffSalaryMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public StaffSalary selectByPrimaryKey(Integer staffSalaryId) {
        return this.staffSalaryMapper.selectByPrimaryKey(staffSalaryId);
    }

    public List<StaffSalary> selectByExample(StaffSalaryCriteria example) {
        return this.staffSalaryMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer staffSalaryId) {
        return this.staffSalaryMapper.deleteByPrimaryKey(staffSalaryId);
    }

    public int updateByPrimaryKeySelective(StaffSalary record) {
        return this.staffSalaryMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(StaffSalary record) {
        return this.staffSalaryMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(StaffSalaryCriteria example) {
        return this.staffSalaryMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(StaffSalary record, StaffSalaryCriteria example) {
        return this.staffSalaryMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(StaffSalary record, StaffSalaryCriteria example) {
        return this.staffSalaryMapper.updateByExample(record, example);
    }

    public int insert(StaffSalary record) {
        return this.staffSalaryMapper.insert(record);
    }

    public int insertSelective(StaffSalary record) {
        return this.staffSalaryMapper.insertSelective(record);
    }
}