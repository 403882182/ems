package com.jyw.system.service.impl;

import com.jyw.system.mapper.RoleAnthorityInfoMapper;
import com.jyw.model.RoleAnthorityInfo;
import com.jyw.model.RoleAnthorityInfoCriteria;
import com.jyw.system.service.RoleAnthorityInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleAnthorityInfoServiceImpl implements RoleAnthorityInfoService {
    @Autowired
    private RoleAnthorityInfoMapper roleAnthorityInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(RoleAnthorityInfoServiceImpl.class);

    public int countByExample(RoleAnthorityInfoCriteria example) {
        int count = (int)this.roleAnthorityInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public RoleAnthorityInfo selectByPrimaryKey(Integer roleAnthorityId) {
        return this.roleAnthorityInfoMapper.selectByPrimaryKey(roleAnthorityId);
    }

    public List<RoleAnthorityInfo> selectByExample(RoleAnthorityInfoCriteria example) {
        return this.roleAnthorityInfoMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer roleAnthorityId) {
        return this.roleAnthorityInfoMapper.deleteByPrimaryKey(roleAnthorityId);
    }

    public int updateByPrimaryKeySelective(RoleAnthorityInfo record) {
        return this.roleAnthorityInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RoleAnthorityInfo record) {
        return this.roleAnthorityInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(RoleAnthorityInfoCriteria example) {
        return this.roleAnthorityInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(RoleAnthorityInfo record, RoleAnthorityInfoCriteria example) {
        return this.roleAnthorityInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(RoleAnthorityInfo record, RoleAnthorityInfoCriteria example) {
        return this.roleAnthorityInfoMapper.updateByExample(record, example);
    }

    public int insert(RoleAnthorityInfo record) {
        return this.roleAnthorityInfoMapper.insert(record);
    }

    public int insertSelective(RoleAnthorityInfo record) {
        return this.roleAnthorityInfoMapper.insertSelective(record);
    }
}