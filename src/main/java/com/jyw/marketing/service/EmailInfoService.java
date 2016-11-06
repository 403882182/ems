package com.jyw.marketing.service;

import com.jyw.model.EmailInfo;
import com.jyw.model.EmailInfoCriteria;
import java.util.List;

public interface EmailInfoService {
    int countByExample(EmailInfoCriteria example);

    EmailInfo selectByPrimaryKey(Integer emailId);

    List<EmailInfo> selectByExample(EmailInfoCriteria example);

    int deleteByPrimaryKey(Integer emailId);

    int updateByPrimaryKeySelective(EmailInfo record);

    int updateByPrimaryKey(EmailInfo record);

    int deleteByExample(EmailInfoCriteria example);

    int updateByExampleSelective(EmailInfo record, EmailInfoCriteria example);

    int updateByExample(EmailInfo record, EmailInfoCriteria example);

    int insert(EmailInfo record);

    int insertSelective(EmailInfo record);
}