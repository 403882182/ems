package com.jyw.marketing.service;

import com.jyw.model.MarketActiveEx;
import com.jyw.model.MessafeInfo;
import com.jyw.model.MessafeInfoCriteria;
import com.jyw.model.MessfeInfoEx;

import java.util.List;

public interface MessafeInfoService {
    int countByExample(MessafeInfoCriteria example);

    MessafeInfo selectByPrimaryKey(Integer messafeId);

    List<MessafeInfo> selectByExample(MessafeInfoCriteria example);

    int deleteByPrimaryKey(Integer messafeId);

    int updateByPrimaryKeySelective(MessafeInfo record);

    int updateByPrimaryKey(MessafeInfo record);

    int deleteByExample(MessafeInfoCriteria example);

    int updateByExampleSelective(MessafeInfo record, MessafeInfoCriteria example);

    int updateByExample(MessafeInfo record, MessafeInfoCriteria example);

    int insert(MessafeInfo record);

    int insertSelective(MessafeInfo record);

    List<MessfeInfoEx> selectAllMesssfeInfo(MessfeInfoEx marketActiveEx);
}