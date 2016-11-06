package com.jyw.student.service.impl;

import com.jyw.student.mapper.EvaluationInfoMapper;
import com.jyw.model.EvaluationInfo;
import com.jyw.model.EvaluationInfoCriteria;
import com.jyw.student.service.EvaluationInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationInfoServiceImpl implements EvaluationInfoService {
    @Autowired
    private EvaluationInfoMapper evaluationInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(EvaluationInfoServiceImpl.class);

    public int countByExample(EvaluationInfoCriteria example) {
        int count = (int)this.evaluationInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public EvaluationInfo selectByPrimaryKey(Integer evaluationId) {
        return this.evaluationInfoMapper.selectByPrimaryKey(evaluationId);
    }

    public List<EvaluationInfo> selectByExample(EvaluationInfoCriteria example) {
        return this.evaluationInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer evaluationId) {
        return this.evaluationInfoMapper.deleteByPrimaryKey(evaluationId);
    }

    public int updateByPrimaryKeySelective(EvaluationInfo record) {
        return this.evaluationInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EvaluationInfo record) {
        return this.evaluationInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(EvaluationInfoCriteria example) {
        return this.evaluationInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(EvaluationInfo record, EvaluationInfoCriteria example) {
        return this.evaluationInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(EvaluationInfo record, EvaluationInfoCriteria example) {
        return this.evaluationInfoMapper.updateByExample(record, example);
    }

    public int insert(EvaluationInfo record) {
        return this.evaluationInfoMapper.insert(record);
    }

    public int insertSelective(EvaluationInfo record) {
        return this.evaluationInfoMapper.insertSelective(record);
    }
}