package com.jyw.marketing.service.impl;

import com.jyw.marketing.mapper.MarketActiveMapper;
import com.jyw.model.MarketActive;
import com.jyw.model.MarketActiveCriteria;
import com.jyw.marketing.service.MarketActiveService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketActiveServiceImpl implements MarketActiveService {
    @Autowired
    private MarketActiveMapper marketActiveMapper;

    private static final Logger logger = LoggerFactory.getLogger(MarketActiveServiceImpl.class);

    public int countByExample(MarketActiveCriteria example) {
        int count = (int)this.marketActiveMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public MarketActive selectByPrimaryKey(Integer activeId) {
        return this.marketActiveMapper.selectByPrimaryKey(activeId);
    }

    public List<MarketActive> selectByExample(MarketActiveCriteria example) {
        return this.marketActiveMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer activeId) {
        return this.marketActiveMapper.deleteByPrimaryKey(activeId);
    }

    public int updateByPrimaryKeySelective(MarketActive record) {
        return this.marketActiveMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MarketActive record) {
        return this.marketActiveMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(MarketActiveCriteria example) {
        return this.marketActiveMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(MarketActive record, MarketActiveCriteria example) {
        return this.marketActiveMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(MarketActive record, MarketActiveCriteria example) {
        return this.marketActiveMapper.updateByExample(record, example);
    }

    public int insert(MarketActive record) {
        return this.marketActiveMapper.insert(record);
    }

    public int insertSelective(MarketActive record) {
        return this.marketActiveMapper.insertSelective(record);
    }
}