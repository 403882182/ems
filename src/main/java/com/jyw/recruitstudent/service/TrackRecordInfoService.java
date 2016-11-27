package com.jyw.recruitstudent.service;

import com.jyw.model.TrackRecordInfo;
import com.jyw.model.TrackRecordInfoCriteria;
import java.util.List;

public interface TrackRecordInfoService {
    int countByExample(TrackRecordInfoCriteria example);

    TrackRecordInfo selectByPrimaryKey(Integer trackRecordId);

    List<TrackRecordInfo> selectByExample(TrackRecordInfoCriteria example);

    int deleteByPrimaryKey(Integer trackRecordId);

    int updateByPrimaryKeySelective(TrackRecordInfo record);

    int updateByPrimaryKey(TrackRecordInfo record);

    int deleteByExample(TrackRecordInfoCriteria example);

    int updateByExampleSelective(TrackRecordInfo record, TrackRecordInfoCriteria example);

    int updateByExample(TrackRecordInfo record, TrackRecordInfoCriteria example);

    int insert(TrackRecordInfo record);

    int insertSelective(TrackRecordInfo record);

    List<TrackRecordInfo> selectByTrackRecordInfo(String name,TrackRecordInfo trackRecordInfo,Integer staffId);

    List<TrackRecordInfo> selectByStudentId(TrackRecordInfo trackRecordInfo);
}