package com.jyw.marketing.service.impl;

import com.jyw.marketing.mapper.MessafeInfoMapper;
import com.jyw.model.MessafeInfo;
import com.jyw.model.MessafeInfoCriteria;
import com.jyw.marketing.service.MessafeInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessafeInfoServiceImpl implements MessafeInfoService {
    @Autowired
    private MessafeInfoMapper messafeInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(MessafeInfoServiceImpl.class);

    public int countByExample(MessafeInfoCriteria example) {
        int count = (int)this.messafeInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public MessafeInfo selectByPrimaryKey(Integer messafeId) {
        return this.messafeInfoMapper.selectByPrimaryKey(messafeId);
    }

    public List<MessafeInfo> selectByExample(MessafeInfoCriteria example) {
        return this.messafeInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer messafeId) {
        return this.messafeInfoMapper.deleteByPrimaryKey(messafeId);
    }

    public int updateByPrimaryKeySelective(MessafeInfo record) {
        return this.messafeInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MessafeInfo record) {
        return this.messafeInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(MessafeInfoCriteria example) {
        return this.messafeInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(MessafeInfo record, MessafeInfoCriteria example) {
        return this.messafeInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(MessafeInfo record, MessafeInfoCriteria example) {
        return this.messafeInfoMapper.updateByExample(record, example);
    }

    public int insert(MessafeInfo record) {
        return this.messafeInfoMapper.insert(record);
    }

    public int insertSelective(MessafeInfo record) {
        return this.messafeInfoMapper.insertSelective(record);
    }
}