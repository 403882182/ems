
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学员沟通记录 communicate_info
 * 2016/11/05 16:28
*/
public class CommunicateInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 记录编号
     */
    private Integer communicateId;

    /** 
     * 学员编号
     */
    private Integer studentId;

    /** 
     * 负责人
     */
    private Integer staffId;

    /** 
     * 沟通时间
     */
    private Date communicateTime;

    /** 
     * 沟通内容
     */
    private String communicateContent;

    /** 
     * 构造查询条件
     */
    public CommunicateInfo(Integer communicateId, Integer studentId, Integer staffId, Date communicateTime, String communicateContent) {
        this.communicateId = communicateId;
        this.studentId = studentId;
        this.staffId = staffId;
        this.communicateTime = communicateTime;
        this.communicateContent = communicateContent;
    }

    /** 
     * 构造查询条件
     */
    public CommunicateInfo() {
        super();
    }

    /** 
     * 获取 记录编号 communicate_info.communicate_id
     * @return 记录编号
     */
    public Integer getCommunicateId() {
        return communicateId;
    }

    /** 
     * 设置 记录编号 communicate_info.communicate_id
     * @param communicateId 记录编号
     */
    public void setCommunicateId(Integer communicateId) {
        this.communicateId = communicateId;
    }

    /** 
     * 获取 学员编号 communicate_info.student_id
     * @return 学员编号
     */
    public Integer getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学员编号 communicate_info.student_id
     * @param studentId 学员编号
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取 负责人 communicate_info.staff_id
     * @return 负责人
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 负责人 communicate_info.staff_id
     * @param staffId 负责人
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 沟通时间 communicate_info.communicate_time
     * @return 沟通时间
     */
    public Date getCommunicateTime() {
        return communicateTime;
    }

    /** 
     * 设置 沟通时间 communicate_info.communicate_time
     * @param communicateTime 沟通时间
     */
    public void setCommunicateTime(Date communicateTime) {
        this.communicateTime = communicateTime;
    }

    /** 
     * 获取 沟通内容 communicate_info.communicate_content
     * @return 沟通内容
     */
    public String getCommunicateContent() {
        return communicateContent;
    }

    /** 
     * 设置 沟通内容 communicate_info.communicate_content
     * @param communicateContent 沟通内容
     */
    public void setCommunicateContent(String communicateContent) {
        this.communicateContent = communicateContent == null ? null : communicateContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", communicateId=").append(communicateId);
        sb.append(", studentId=").append(studentId);
        sb.append(", staffId=").append(staffId);
        sb.append(", communicateTime=").append(communicateTime);
        sb.append(", communicateContent=").append(communicateContent);
        sb.append("]");
        return sb.toString();
    }
}