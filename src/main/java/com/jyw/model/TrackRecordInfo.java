
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 跟踪记录信息 track_record_info
 * 2016/11/05 16:28
*/
public class TrackRecordInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 记录编号
     */
    private Integer trackRecordId;

    /** 
     * 学员编号
     */
    private Integer studentId;

    /** 
     * 主题
     */
    private String trackRecordTitle;

    /** 
     * 具体内容
     */
    private String trackRecordContent;

    /** 
     * 联系时间
     */
    private Date trackRecordTime;

    /** 
     * 意向状态
     */
    private Integer enrollment;

    /** 
     * 下次联系时间
     */
    private Date nextRecordTime;

    /** 
     * 构造查询条件
     */
    public TrackRecordInfo(Integer trackRecordId, Integer studentId, String trackRecordTitle, String trackRecordContent, Date trackRecordTime, Integer enrollment, Date nextRecordTime) {
        this.trackRecordId = trackRecordId;
        this.studentId = studentId;
        this.trackRecordTitle = trackRecordTitle;
        this.trackRecordContent = trackRecordContent;
        this.trackRecordTime = trackRecordTime;
        this.enrollment = enrollment;
        this.nextRecordTime = nextRecordTime;
    }

    /** 
     * 构造查询条件
     */
    public TrackRecordInfo() {
        super();
    }

    /** 
     * 获取 记录编号 track_record_info.track_record_id
     * @return 记录编号
     */
    public Integer getTrackRecordId() {
        return trackRecordId;
    }

    /** 
     * 设置 记录编号 track_record_info.track_record_id
     * @param trackRecordId 记录编号
     */
    public void setTrackRecordId(Integer trackRecordId) {
        this.trackRecordId = trackRecordId;
    }

    /** 
     * 获取 学员编号 track_record_info.student_id
     * @return 学员编号
     */
    public Integer getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学员编号 track_record_info.student_id
     * @param studentId 学员编号
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取 主题 track_record_info.track_record_title
     * @return 主题
     */
    public String getTrackRecordTitle() {
        return trackRecordTitle;
    }

    /** 
     * 设置 主题 track_record_info.track_record_title
     * @param trackRecordTitle 主题
     */
    public void setTrackRecordTitle(String trackRecordTitle) {
        this.trackRecordTitle = trackRecordTitle == null ? null : trackRecordTitle.trim();
    }

    /** 
     * 获取 具体内容 track_record_info.track_record_content
     * @return 具体内容
     */
    public String getTrackRecordContent() {
        return trackRecordContent;
    }

    /** 
     * 设置 具体内容 track_record_info.track_record_content
     * @param trackRecordContent 具体内容
     */
    public void setTrackRecordContent(String trackRecordContent) {
        this.trackRecordContent = trackRecordContent == null ? null : trackRecordContent.trim();
    }

    /** 
     * 获取 联系时间 track_record_info.track_record_time
     * @return 联系时间
     */
    public Date getTrackRecordTime() {
        return trackRecordTime;
    }

    /** 
     * 设置 联系时间 track_record_info.track_record_time
     * @param trackRecordTime 联系时间
     */
    public void setTrackRecordTime(Date trackRecordTime) {
        this.trackRecordTime = trackRecordTime;
    }

    /** 
     * 获取 意向状态 track_record_info.enrollment
     * @return 意向状态
     */
    public Integer getEnrollment() {
        return enrollment;
    }

    /** 
     * 设置 意向状态 track_record_info.enrollment
     * @param enrollment 意向状态
     */
    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }

    /** 
     * 获取 下次联系时间 track_record_info.next_record_time
     * @return 下次联系时间
     */
    public Date getNextRecordTime() {
        return nextRecordTime;
    }

    /** 
     * 设置 下次联系时间 track_record_info.next_record_time
     * @param nextRecordTime 下次联系时间
     */
    public void setNextRecordTime(Date nextRecordTime) {
        this.nextRecordTime = nextRecordTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", trackRecordId=").append(trackRecordId);
        sb.append(", studentId=").append(studentId);
        sb.append(", trackRecordTitle=").append(trackRecordTitle);
        sb.append(", trackRecordContent=").append(trackRecordContent);
        sb.append(", trackRecordTime=").append(trackRecordTime);
        sb.append(", enrollment=").append(enrollment);
        sb.append(", nextRecordTime=").append(nextRecordTime);
        sb.append("]");
        return sb.toString();
    }
}