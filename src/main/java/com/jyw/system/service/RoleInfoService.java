package com.jyw.system.service;

import com.jyw.model.RoleInfo;
import com.jyw.model.RoleInfoCriteria;
import java.util.List;

public interface RoleInfoService {
    int countByExample(RoleInfoCriteria example);

    RoleInfo selectByPrimaryKey(Integer roleId);

    List<RoleInfo> selectByExample(RoleInfoCriteria example);

    int deleteByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

    int deleteByExample(RoleInfoCriteria example);

    int updateByExampleSelective(RoleInfo record, RoleInfoCriteria example);

    int updateByExample(RoleInfo record, RoleInfoCriteria example);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);
}