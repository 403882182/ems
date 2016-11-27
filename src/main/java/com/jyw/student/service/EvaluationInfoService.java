package com.jyw.student.service;

import com.jyw.model.EvaluationInfo;
import com.jyw.model.EvaluationInfoCriteria;
import com.jyw.model.EvaluationInfoEx;

import java.util.List;

public interface EvaluationInfoService {
    int countByExample(EvaluationInfoCriteria example);

    EvaluationInfo selectByPrimaryKey(Integer evaluationId);

    List<EvaluationInfo> selectByExample(EvaluationInfoCriteria example);

    int deleteByPrimaryKey(Integer evaluationId);

    int updateByPrimaryKeySelective(EvaluationInfo record);

    int updateByPrimaryKey(EvaluationInfo record);

    int deleteByExample(EvaluationInfoCriteria example);

    int updateByExampleSelective(EvaluationInfo record, EvaluationInfoCriteria example);

    int updateByExample(EvaluationInfo record, EvaluationInfoCriteria example);

    int insert(EvaluationInfo record);

    int insertSelective(EvaluationInfo record);

    List<EvaluationInfoEx> selectAllEvaluation(EvaluationInfoEx evaluationInfoEx);
}