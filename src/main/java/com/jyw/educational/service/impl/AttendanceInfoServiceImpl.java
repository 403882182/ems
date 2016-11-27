package com.jyw.educational.service.impl;

import com.jyw.educational.mapper.AttendanceInfoMapper;
import com.jyw.model.AttendanceInfo;
import com.jyw.model.AttendanceInfoCriteria;
import com.jyw.educational.service.AttendanceInfoService;
import java.util.List;

import com.jyw.model.StudentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceInfoServiceImpl implements AttendanceInfoService {


    @Autowired
    private AttendanceInfoMapper attendanceInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(AttendanceInfoServiceImpl.class);

    public int countByExample(AttendanceInfoCriteria example) {
        int count = (int)this.attendanceInfoMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    /**
     * 根据条件查看学员考勤
     * @param studentName
     * @return
     */
    public  List<AttendanceInfo> selectAttendance(String studentName,Integer staffId){

return  this.attendanceInfoMapper.selectAttendance(studentName, staffId);
    }

 /**
     * 查看学员表中所有学员姓名
     * @return
     */
  public  List<StudentInfo> selectStudent(){
      return  this.attendanceInfoMapper.selectStudent();

  }


    public AttendanceInfo selectByPrimaryKey(Integer attendanceId) {
        return this.attendanceInfoMapper.selectByPrimaryKey(attendanceId);
    }

    public List<AttendanceInfo> selectByExample(AttendanceInfoCriteria example) {
        return this.attendanceInfoMapper.selectByExample(example);
    }

    /**
     * 根据id删除考勤信息
     * @param attendanceId
     * @return
     */
    public int deleteByPrimaryKey(Integer attendanceId) {
        return this.attendanceInfoMapper.deleteByPrimaryKey(attendanceId);
    }

    public int updateByPrimaryKeySelective(AttendanceInfo record) {
        return this.attendanceInfoMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 修改考勤
     * @param record
     * @return
     */
    public int updateByPrimaryKey(AttendanceInfo record) {
        return this.attendanceInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(AttendanceInfoCriteria example) {
        return this.attendanceInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(AttendanceInfo record, AttendanceInfoCriteria example) {
        return this.attendanceInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(AttendanceInfo record, AttendanceInfoCriteria example) {
        return this.attendanceInfoMapper.updateByExample(record, example);
    }

    public int insert(AttendanceInfo record) {
        return this.attendanceInfoMapper.insert(record);
    }

    public int insertSelective(AttendanceInfo record) {
        return this.attendanceInfoMapper.insertSelective(record);
    }
}