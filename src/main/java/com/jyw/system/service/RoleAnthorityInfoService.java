package com.jyw.system.service;

import com.jyw.model.RoleAnthorityInfo;
import com.jyw.model.RoleAnthorityInfoCriteria;
import java.util.List;

public interface RoleAnthorityInfoService {
    int countByExample(RoleAnthorityInfoCriteria example);

    RoleAnthorityInfo selectByPrimaryKey(Integer roleAnthorityId);

    List<RoleAnthorityInfo> selectByExample(RoleAnthorityInfoCriteria example);

    int deleteByPrimaryKey(Integer roleAnthorityId);

    int updateByPrimaryKeySelective(RoleAnthorityInfo record);

    int updateByPrimaryKey(RoleAnthorityInfo record);

    int deleteByExample(RoleAnthorityInfoCriteria example);

    int updateByExampleSelective(RoleAnthorityInfo record, RoleAnthorityInfoCriteria example);

    int updateByExample(RoleAnthorityInfo record, RoleAnthorityInfoCriteria example);

    int insert(RoleAnthorityInfo record);

    int insertSelective(RoleAnthorityInfo record);
}