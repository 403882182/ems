
package com.jyw.model;

import java.io.Serializable;

/**
 * 教室信息 classroom_info
 * 2016/11/05 16:28
*/
public class ClassroomInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 教室编号
     */
    private Integer classroomId;

    /** 
     * 教室名称
     */
    private String classroomName;

    /** 
     * 容纳人数
     */
    private Integer classroomMax;

    /** 
     * 设备信息
     */
    private String classroomInfo;

    /** 
     * 备注信息
     */
    private String classroomRemark;

    /** 
     * 标识
     */
    private String classroomMark;

    /** 
     * 构造查询条件
     */
    public ClassroomInfo(Integer classroomId, String classroomName, Integer classroomMax, String classroomInfo, String classroomRemark, String classroomMark) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.classroomMax = classroomMax;
        this.classroomInfo = classroomInfo;
        this.classroomRemark = classroomRemark;
        this.classroomMark = classroomMark;
    }

    /** 
     * 构造查询条件
     */
    public ClassroomInfo() {
        super();
    }

    /** 
     * 获取 教室编号 classroom_info.classroom_id
     * @return 教室编号
     */
    public Integer getClassroomId() {
        return classroomId;
    }

    /** 
     * 设置 教室编号 classroom_info.classroom_id
     * @param classroomId 教室编号
     */
    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    /** 
     * 获取 教室名称 classroom_info.classroom_name
     * @return 教室名称
     */
    public String getClassroomName() {
        return classroomName;
    }

    /** 
     * 设置 教室名称 classroom_info.classroom_name
     * @param classroomName 教室名称
     */
    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName == null ? null : classroomName.trim();
    }

    /** 
     * 获取 容纳人数 classroom_info.classroom_max
     * @return 容纳人数
     */
    public Integer getClassroomMax() {
        return classroomMax;
    }

    /** 
     * 设置 容纳人数 classroom_info.classroom_max
     * @param classroomMax 容纳人数
     */
    public void setClassroomMax(Integer classroomMax) {
        this.classroomMax = classroomMax;
    }

    /** 
     * 获取 设备信息 classroom_info.classroom_info
     * @return 设备信息
     */
    public String getClassroomInfo() {
        return classroomInfo;
    }

    /** 
     * 设置 设备信息 classroom_info.classroom_info
     * @param classroomInfo 设备信息
     */
    public void setClassroomInfo(String classroomInfo) {
        this.classroomInfo = classroomInfo == null ? null : classroomInfo.trim();
    }

    /** 
     * 获取 备注信息 classroom_info.classroom_remark
     * @return 备注信息
     */
    public String getClassroomRemark() {
        return classroomRemark;
    }

    /** 
     * 设置 备注信息 classroom_info.classroom_remark
     * @param classroomRemark 备注信息
     */
    public void setClassroomRemark(String classroomRemark) {
        this.classroomRemark = classroomRemark == null ? null : classroomRemark.trim();
    }

    /** 
     * 获取 标识 classroom_info.classroom_mark
     * @return 标识
     */
    public String getClassroomMark() {
        return classroomMark;
    }

    /** 
     * 设置 标识 classroom_info.classroom_mark
     * @param classroomMark 标识
     */
    public void setClassroomMark(String classroomMark) {
        this.classroomMark = classroomMark == null ? null : classroomMark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", classroomId=").append(classroomId);
        sb.append(", classroomName=").append(classroomName);
        sb.append(", classroomMax=").append(classroomMax);
        sb.append(", classroomInfo=").append(classroomInfo);
        sb.append(", classroomRemark=").append(classroomRemark);
        sb.append(", classroomMark=").append(classroomMark);
        sb.append("]");
        return sb.toString();
    }
}