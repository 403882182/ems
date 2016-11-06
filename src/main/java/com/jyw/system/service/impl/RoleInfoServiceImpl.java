package com.jyw.system.service.impl;

import com.jyw.system.mapper.RoleInfoMapper;
import com.jyw.model.RoleInfo;
import com.jyw.model.RoleInfoCriteria;
import com.jyw.system.service.RoleInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    private RoleInfoMapper roleInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(RoleInfoServiceImpl.class);

    public int countByExample(RoleInfoCriteria example) {
        int count = (int)this.roleInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public RoleInfo selectByPrimaryKey(Integer roleId) {
        return this.roleInfoMapper.selectByPrimaryKey(roleId);
    }

    public List<RoleInfo> selectByExample(RoleInfoCriteria example) {
        return this.roleInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer roleId) {
        return this.roleInfoMapper.deleteByPrimaryKey(roleId);
    }

    public int updateByPrimaryKeySelective(RoleInfo record) {
        return this.roleInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RoleInfo record) {
        return this.roleInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(RoleInfoCriteria example) {
        return this.roleInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(RoleInfo record, RoleInfoCriteria example) {
        return this.roleInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(RoleInfo record, RoleInfoCriteria example) {
        return this.roleInfoMapper.updateByExample(record, example);
    }

    public int insert(RoleInfo record) {
        return this.roleInfoMapper.insert(record);
    }

    public int insertSelective(RoleInfo record) {
        return this.roleInfoMapper.insertSelective(record);
    }
}