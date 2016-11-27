
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 考勤 attendance_info
 * 2016/11/05 16:28
*/
public class AttendanceInfo implements Serializable {
    private static final long serialVersionUID = 1L;
private StudentInfo studentInfo;
    /** 
     * 考勤编号
     */
    private Integer attendanceId;

    /** 
     * 学员编号
     */
    private Integer studentId;

    /** 
     * 描述
     */
    private String attendanceDesc;

    /** 
     * 状态
     */
    private String attendanceState;

    /** 
     * 日期
     */
    private Date attendanceTime;

    /** 
     * 备注
     */
    private String attendanceRemark;

    /** 
     * 构造查询条件
     */
    public AttendanceInfo(Integer attendanceId, Integer studentId, String attendanceDesc, String attendanceState, Date attendanceTime, String attendanceRemark) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.attendanceDesc = attendanceDesc;
        this.attendanceState = attendanceState;
        this.attendanceTime = attendanceTime;
        this.attendanceRemark = attendanceRemark;
    }

    /** 
     * 构造查询条件
     */
    public AttendanceInfo() {
        super();
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    /**
     * 获取 考勤编号 attendance_info.attendance_id
     * @return 考勤编号
     */
    public Integer getAttendanceId() {
        return attendanceId;
    }

    /** 
     * 设置 考勤编号 attendance_info.attendance_id
     * @param attendanceId 考勤编号
     */
    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    /** 
     * 获取 学员编号 attendance_info.student_id
     * @return 学员编号
     */
    public Integer getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学员编号 attendance_info.student_id
     * @param studentId 学员编号
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取 描述 attendance_info.attendance_desc
     * @return 描述
     */
    public String getAttendanceDesc() {
        return attendanceDesc;
    }

    /** 
     * 设置 描述 attendance_info.attendance_desc
     * @param attendanceDesc 描述
     */
    public void setAttendanceDesc(String attendanceDesc) {
        this.attendanceDesc = attendanceDesc == null ? null : attendanceDesc.trim();
    }

    /** 
     * 获取 状态 attendance_info.attendance_state
     * @return 状态
     */
    public String getAttendanceState() {
        return attendanceState;
    }

    /** 
     * 设置 状态 attendance_info.attendance_state
     * @param attendanceState 状态
     */
    public void setAttendanceState(String attendanceState) {
        this.attendanceState = attendanceState == null ? null : attendanceState.trim();
    }

    /** 
     * 获取 日期 attendance_info.attendance_time
     * @return 日期
     */
    public Date getAttendanceTime() {
        return attendanceTime;
    }

    /** 
     * 设置 日期 attendance_info.attendance_time
     * @param attendanceTime 日期
     */
    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    /** 
     * 获取 备注 attendance_info.attendance_remark
     * @return 备注
     */
    public String getAttendanceRemark() {
        return attendanceRemark;
    }

    /** 
     * 设置 备注 attendance_info.attendance_remark
     * @param attendanceRemark 备注
     */
    public void setAttendanceRemark(String attendanceRemark) {
        this.attendanceRemark = attendanceRemark == null ? null : attendanceRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", attendanceId=").append(attendanceId);
        sb.append(", studentId=").append(studentId);
        sb.append(", attendanceDesc=").append(attendanceDesc);
        sb.append(", attendanceState=").append(attendanceState);
        sb.append(", attendanceTime=").append(attendanceTime);
        sb.append(", attendanceRemark=").append(attendanceRemark);
        sb.append("]");
        return sb.toString();
    }
}