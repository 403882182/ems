package com.jyw.marketing.service.impl;

import com.jyw.marketing.mapper.EmailInfoMapper;
import com.jyw.model.EmailInfo;
import com.jyw.model.EmailInfoCriteria;
import com.jyw.marketing.service.EmailInfoService;
import java.util.List;

import com.jyw.model.EmailInfoEx;
import com.jyw.model.StaffInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailInfoServiceImpl implements EmailInfoService {
    @Autowired
    private EmailInfoMapper emailInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(EmailInfoServiceImpl.class);

    public int countByExample(EmailInfoCriteria example) {
        int count = (int)this.emailInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public EmailInfo selectByPrimaryKey(Integer emailId) {
        return this.emailInfoMapper.selectByPrimaryKey(emailId);
    }

    public List<EmailInfo> selectByExample(EmailInfoCriteria example) {
        return this.emailInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer emailId) {
        return this.emailInfoMapper.deleteByPrimaryKey(emailId);
    }

    public int updateByPrimaryKeySelective(EmailInfo record) {
        return this.emailInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EmailInfo record) {
        return this.emailInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(EmailInfoCriteria example) {
        return this.emailInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(EmailInfo record, EmailInfoCriteria example) {
        return this.emailInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(EmailInfo record, EmailInfoCriteria example) {
        return this.emailInfoMapper.updateByExample(record, example);
    }

    public int insert(EmailInfo record) {
        return this.emailInfoMapper.insert(record);
    }

    public int insertSelective(EmailInfo record) {
        return this.emailInfoMapper.insertSelective(record);
    }

    /**
     * 获取Emial的封装信息
     * @return
     */
    @Override
    public List<EmailInfoEx> getAllEmailInfoEx(EmailInfoEx emailInfoEx)
    {
        return this.emailInfoMapper.getAllEmailInfoEx(emailInfoEx);
    }
}