
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 试听信息 audition_info
 * 2016/11/05 16:28
*/
public class AuditionInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 试听编号
     */
    private Integer auditionId;

    /** 
     * 学员编号
     */
    private Integer studentId;

    /** 
     * 试听日期
     */
    private Date auditionTime;

    /** 
     * 试听地点
     */
    private String auditionAddr;

    /** 
     * 试听课程
     */
    private String auditionCourse;

    /** 
     * 试听描述
     */
    private String auditionDesc;

    /**
     * 学生对象，获取学员姓名
     */
    private StudentInfo studentInfo;

    /**
     * get,set方法
     * @return
     */
    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    /**
     * 构造查询条件
     */
    public AuditionInfo(Integer auditionId, Integer studentId, Date auditionTime, String auditionAddr, String auditionCourse, String auditionDesc) {
        this.auditionId = auditionId;
        this.studentId = studentId;
        this.auditionTime = auditionTime;
        this.auditionAddr = auditionAddr;
        this.auditionCourse = auditionCourse;
        this.auditionDesc = auditionDesc;
    }

    /** 
     * 构造查询条件
     */
    public AuditionInfo() {
        super();
    }

    /** 
     * 获取 试听编号 audition_info.audition_id
     * @return 试听编号
     */
    public Integer getAuditionId() {
        return auditionId;
    }

    /** 
     * 设置 试听编号 audition_info.audition_id
     * @param auditionId 试听编号
     */
    public void setAuditionId(Integer auditionId) {
        this.auditionId = auditionId;
    }

    /** 
     * 获取 学员编号 audition_info.student_id
     * @return 学员编号
     */
    public Integer getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学员编号 audition_info.student_id
     * @param studentId 学员编号
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取 试听日期 audition_info.audition_time
     * @return 试听日期
     */
    public Date getAuditionTime() {
        return auditionTime;
    }

    /** 
     * 设置 试听日期 audition_info.audition_time
     * @param auditionTime 试听日期
     */
    public void setAuditionTime(Date auditionTime) {
        this.auditionTime = auditionTime;
    }

    /** 
     * 获取 试听地点 audition_info.audition_addr
     * @return 试听地点
     */
    public String getAuditionAddr() {
        return auditionAddr;
    }

    /** 
     * 设置 试听地点 audition_info.audition_addr
     * @param auditionAddr 试听地点
     */
    public void setAuditionAddr(String auditionAddr) {
        this.auditionAddr = auditionAddr == null ? null : auditionAddr.trim();
    }

    /** 
     * 获取 试听课程 audition_info.audition_course
     * @return 试听课程
     */
    public String getAuditionCourse() {
        return auditionCourse;
    }

    /** 
     * 设置 试听课程 audition_info.audition_course
     * @param auditionCourse 试听课程
     */
    public void setAuditionCourse(String auditionCourse) {
        this.auditionCourse = auditionCourse == null ? null : auditionCourse.trim();
    }

    /** 
     * 获取 试听描述 audition_info.audition_desc
     * @return 试听描述
     */
    public String getAuditionDesc() {
        return auditionDesc;
    }

    /** 
     * 设置 试听描述 audition_info.audition_desc
     * @param auditionDesc 试听描述
     */
    public void setAuditionDesc(String auditionDesc) {
        this.auditionDesc = auditionDesc == null ? null : auditionDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", auditionId=").append(auditionId);
        sb.append(", studentId=").append(studentId);
        sb.append(", auditionTime=").append(auditionTime);
        sb.append(", auditionAddr=").append(auditionAddr);
        sb.append(", auditionCourse=").append(auditionCourse);
        sb.append(", auditionDesc=").append(auditionDesc);
        sb.append("]");
        return sb.toString();
    }
}