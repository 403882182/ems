package com.jyw.marketing.service;

import com.jyw.model.MarketActive;
import com.jyw.model.MarketActiveCriteria;
import java.util.List;

public interface MarketActiveService {
    int countByExample(MarketActiveCriteria example);

    MarketActive selectByPrimaryKey(Integer activeId);

    List<MarketActive> selectByExample(MarketActiveCriteria example);

    int deleteByPrimaryKey(Integer activeId);

    int updateByPrimaryKeySelective(MarketActive record);

    int updateByPrimaryKey(MarketActive record);

    int deleteByExample(MarketActiveCriteria example);

    int updateByExampleSelective(MarketActive record, MarketActiveCriteria example);

    int updateByExample(MarketActive record, MarketActiveCriteria example);

    int insert(MarketActive record);

    int insertSelective(MarketActive record);
}