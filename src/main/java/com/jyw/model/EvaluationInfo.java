
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学员评价 evaluation_info
 * 2016/11/05 16:28
*/
public class EvaluationInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 记录编号
     */
    private Integer evaluationId;

    /** 
     * 学员编号
     */
    private Integer studentId;

    /** 
     * 主题
     */
    private String evaluationTitle;

    /** 
     * 评价内容
     */
    private String evaluationContent;

    /** 
     * 课程名称
     */
    private String evaluationCourse;

    /** 
     * 教师
     */
    private String evaluationTeacher;

    /** 
     * 评价时间
     */
    private Date evaluationTime;

    /** 
     * 构造查询条件
     */
    public EvaluationInfo(Integer evaluationId, Integer studentId, String evaluationTitle, String evaluationContent, String evaluationCourse, String evaluationTeacher, Date evaluationTime) {
        this.evaluationId = evaluationId;
        this.studentId = studentId;
        this.evaluationTitle = evaluationTitle;
        this.evaluationContent = evaluationContent;
        this.evaluationCourse = evaluationCourse;
        this.evaluationTeacher = evaluationTeacher;
        this.evaluationTime = evaluationTime;
    }

    /** 
     * 构造查询条件
     */
    public EvaluationInfo() {
        super();
    }

    /** 
     * 获取 记录编号 evaluation_info.evaluation_id
     * @return 记录编号
     */
    public Integer getEvaluationId() {
        return evaluationId;
    }

    /** 
     * 设置 记录编号 evaluation_info.evaluation_id
     * @param evaluationId 记录编号
     */
    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    /** 
     * 获取 学员编号 evaluation_info.student_id
     * @return 学员编号
     */
    public Integer getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学员编号 evaluation_info.student_id
     * @param studentId 学员编号
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取 主题 evaluation_info.evaluation_title
     * @return 主题
     */
    public String getEvaluationTitle() {
        return evaluationTitle;
    }

    /** 
     * 设置 主题 evaluation_info.evaluation_title
     * @param evaluationTitle 主题
     */
    public void setEvaluationTitle(String evaluationTitle) {
        this.evaluationTitle = evaluationTitle == null ? null : evaluationTitle.trim();
    }

    /** 
     * 获取 评价内容 evaluation_info.evaluation_content
     * @return 评价内容
     */
    public String getEvaluationContent() {
        return evaluationContent;
    }

    /** 
     * 设置 评价内容 evaluation_info.evaluation_content
     * @param evaluationContent 评价内容
     */
    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent == null ? null : evaluationContent.trim();
    }

    /** 
     * 获取 课程名称 evaluation_info.evaluation_course
     * @return 课程名称
     */
    public String getEvaluationCourse() {
        return evaluationCourse;
    }

    /** 
     * 设置 课程名称 evaluation_info.evaluation_course
     * @param evaluationCourse 课程名称
     */
    public void setEvaluationCourse(String evaluationCourse) {
        this.evaluationCourse = evaluationCourse == null ? null : evaluationCourse.trim();
    }

    /** 
     * 获取 教师 evaluation_info.evaluation_teacher
     * @return 教师
     */
    public String getEvaluationTeacher() {
        return evaluationTeacher;
    }

    /** 
     * 设置 教师 evaluation_info.evaluation_teacher
     * @param evaluationTeacher 教师
     */
    public void setEvaluationTeacher(String evaluationTeacher) {
        this.evaluationTeacher = evaluationTeacher == null ? null : evaluationTeacher.trim();
    }

    /** 
     * 获取 评价时间 evaluation_info.evaluation_time
     * @return 评价时间
     */
    public Date getEvaluationTime() {
        return evaluationTime;
    }

    /** 
     * 设置 评价时间 evaluation_info.evaluation_time
     * @param evaluationTime 评价时间
     */
    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", evaluationId=").append(evaluationId);
        sb.append(", studentId=").append(studentId);
        sb.append(", evaluationTitle=").append(evaluationTitle);
        sb.append(", evaluationContent=").append(evaluationContent);
        sb.append(", evaluationCourse=").append(evaluationCourse);
        sb.append(", evaluationTeacher=").append(evaluationTeacher);
        sb.append(", evaluationTime=").append(evaluationTime);
        sb.append("]");
        return sb.toString();
    }
}