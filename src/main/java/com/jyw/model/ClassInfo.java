
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级信息 class_info
 * 2016/11/05 16:28
*/
public class ClassInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 班级编号
     */
    private Integer classId;

    /** 
     * 学科编号
     */
    private Integer disciplineId;

    /** 
     * 课程表编号
     */
    private Integer syllabusId;

    /** 
     * 教室编号
     */
    private Integer classroomId;

    /** 
     * 员工编号
     */
    private Integer staffId;

    /** 
     * 班级名称
     */
    private String className;

    /** 
     * 班级人数
     */
    private Integer classNumber;

    /** 
     * 开班时间
     */
    private Date classStartTime;

    /** 
     * 结束时间
     */
    private Date classEndTime;

    /** 
     * 是否有效
     */
    private String classIsuesd;

    /** 
     * 状态
     */
    private String classState;

    /** 
     * 描述信息
     */
    private String classDesc;

    /** 
     * 构造查询条件
     */
    public ClassInfo(Integer classId, Integer disciplineId, Integer syllabusId, Integer classroomId, Integer staffId, String className, Integer classNumber, Date classStartTime, Date classEndTime, String classIsuesd, String classState, String classDesc) {
        this.classId = classId;
        this.disciplineId = disciplineId;
        this.syllabusId = syllabusId;
        this.classroomId = classroomId;
        this.staffId = staffId;
        this.className = className;
        this.classNumber = classNumber;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classIsuesd = classIsuesd;
        this.classState = classState;
        this.classDesc = classDesc;
    }

    /** 
     * 构造查询条件
     */
    public ClassInfo() {
        super();
    }

    /** 
     * 获取 班级编号 class_info.class_id
     * @return 班级编号
     */
    public Integer getClassId() {
        return classId;
    }

    /** 
     * 设置 班级编号 class_info.class_id
     * @param classId 班级编号
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /** 
     * 获取 学科编号 class_info.discipline_id
     * @return 学科编号
     */
    public Integer getDisciplineId() {
        return disciplineId;
    }

    /** 
     * 设置 学科编号 class_info.discipline_id
     * @param disciplineId 学科编号
     */
    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    /** 
     * 获取 课程表编号 class_info.syllabus_id
     * @return 课程表编号
     */
    public Integer getSyllabusId() {
        return syllabusId;
    }

    /** 
     * 设置 课程表编号 class_info.syllabus_id
     * @param syllabusId 课程表编号
     */
    public void setSyllabusId(Integer syllabusId) {
        this.syllabusId = syllabusId;
    }

    /** 
     * 获取 教室编号 class_info.classroom_id
     * @return 教室编号
     */
    public Integer getClassroomId() {
        return classroomId;
    }

    /** 
     * 设置 教室编号 class_info.classroom_id
     * @param classroomId 教室编号
     */
    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    /** 
     * 获取 员工编号 class_info.staff_id
     * @return 员工编号
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 员工编号 class_info.staff_id
     * @param staffId 员工编号
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 班级名称 class_info.class_name
     * @return 班级名称
     */
    public String getClassName() {
        return className;
    }

    /** 
     * 设置 班级名称 class_info.class_name
     * @param className 班级名称
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /** 
     * 获取 班级人数 class_info.class_number
     * @return 班级人数
     */
    public Integer getClassNumber() {
        return classNumber;
    }

    /** 
     * 设置 班级人数 class_info.class_number
     * @param classNumber 班级人数
     */
    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    /** 
     * 获取 开班时间 class_info.class_start_time
     * @return 开班时间
     */
    public Date getClassStartTime() {
        return classStartTime;
    }

    /** 
     * 设置 开班时间 class_info.class_start_time
     * @param classStartTime 开班时间
     */
    public void setClassStartTime(Date classStartTime) {
        this.classStartTime = classStartTime;
    }

    /** 
     * 获取 结束时间 class_info.class_end_time
     * @return 结束时间
     */
    public Date getClassEndTime() {
        return classEndTime;
    }

    /** 
     * 设置 结束时间 class_info.class_end_time
     * @param classEndTime 结束时间
     */
    public void setClassEndTime(Date classEndTime) {
        this.classEndTime = classEndTime;
    }

    /** 
     * 获取 是否有效 class_info.class_isuesd
     * @return 是否有效
     */
    public String getClassIsuesd() {
        return classIsuesd;
    }

    /** 
     * 设置 是否有效 class_info.class_isuesd
     * @param classIsuesd 是否有效
     */
    public void setClassIsuesd(String classIsuesd) {
        this.classIsuesd = classIsuesd == null ? null : classIsuesd.trim();
    }

    /** 
     * 获取 状态 class_info.class_state
     * @return 状态
     */
    public String getClassState() {
        return classState;
    }

    /** 
     * 设置 状态 class_info.class_state
     * @param classState 状态
     */
    public void setClassState(String classState) {
        this.classState = classState == null ? null : classState.trim();
    }

    /** 
     * 获取 描述信息 class_info.class_desc
     * @return 描述信息
     */
    public String getClassDesc() {
        return classDesc;
    }

    /** 
     * 设置 描述信息 class_info.class_desc
     * @param classDesc 描述信息
     */
    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc == null ? null : classDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", classId=").append(classId);
        sb.append(", disciplineId=").append(disciplineId);
        sb.append(", syllabusId=").append(syllabusId);
        sb.append(", classroomId=").append(classroomId);
        sb.append(", staffId=").append(staffId);
        sb.append(", className=").append(className);
        sb.append(", classNumber=").append(classNumber);
        sb.append(", classStartTime=").append(classStartTime);
        sb.append(", classEndTime=").append(classEndTime);
        sb.append(", classIsuesd=").append(classIsuesd);
        sb.append(", classState=").append(classState);
        sb.append(", classDesc=").append(classDesc);
        sb.append("]");
        return sb.toString();
    }
}