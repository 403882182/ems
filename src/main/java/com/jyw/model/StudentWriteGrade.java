
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学员成绩 student_write_grade
 * 2016/11/05 16:28
*/
public class StudentWriteGrade implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 成绩编号
     */
    private Integer writeGradeId;

    /** 
     * 学员编号
     */
    private Integer studentId;

    /** 
     * 监考人和阅卷人
     */
    private Integer staffId;

    /** 
     * 科目
     */
    private String writeGradeSubject;

    /** 
     * 成绩
     */
    private String writeGrade;

    /** 
     * 考试时间
     */
    private Date writeGradeTime;

    /** 
     * 备注
     */
    private String writeGradeNote;

    /** 
     * 构造查询条件
     */
    public StudentWriteGrade(Integer writeGradeId, Integer studentId, Integer staffId, String writeGradeSubject, String writeGrade, Date writeGradeTime, String writeGradeNote) {
        this.writeGradeId = writeGradeId;
        this.studentId = studentId;
        this.staffId = staffId;
        this.writeGradeSubject = writeGradeSubject;
        this.writeGrade = writeGrade;
        this.writeGradeTime = writeGradeTime;
        this.writeGradeNote = writeGradeNote;
    }

    /** 
     * 构造查询条件
     */
    public StudentWriteGrade() {
        super();
    }

    /** 
     * 获取 成绩编号 student_write_grade.write_grade_id
     * @return 成绩编号
     */
    public Integer getWriteGradeId() {
        return writeGradeId;
    }

    /** 
     * 设置 成绩编号 student_write_grade.write_grade_id
     * @param writeGradeId 成绩编号
     */
    public void setWriteGradeId(Integer writeGradeId) {
        this.writeGradeId = writeGradeId;
    }

    /** 
     * 获取 学员编号 student_write_grade.student_id
     * @return 学员编号
     */
    public Integer getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学员编号 student_write_grade.student_id
     * @param studentId 学员编号
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取 监考人和阅卷人 student_write_grade.staff_id
     * @return 监考人和阅卷人
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 监考人和阅卷人 student_write_grade.staff_id
     * @param staffId 监考人和阅卷人
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 科目 student_write_grade.write_grade_subject
     * @return 科目
     */
    public String getWriteGradeSubject() {
        return writeGradeSubject;
    }

    /** 
     * 设置 科目 student_write_grade.write_grade_subject
     * @param writeGradeSubject 科目
     */
    public void setWriteGradeSubject(String writeGradeSubject) {
        this.writeGradeSubject = writeGradeSubject == null ? null : writeGradeSubject.trim();
    }

    /** 
     * 获取 成绩 student_write_grade.write_grade
     * @return 成绩
     */
    public String getWriteGrade() {
        return writeGrade;
    }

    /** 
     * 设置 成绩 student_write_grade.write_grade
     * @param writeGrade 成绩
     */
    public void setWriteGrade(String writeGrade) {
        this.writeGrade = writeGrade == null ? null : writeGrade.trim();
    }

    /** 
     * 获取 考试时间 student_write_grade.write_grade_time
     * @return 考试时间
     */
    public Date getWriteGradeTime() {
        return writeGradeTime;
    }

    /** 
     * 设置 考试时间 student_write_grade.write_grade_time
     * @param writeGradeTime 考试时间
     */
    public void setWriteGradeTime(Date writeGradeTime) {
        this.writeGradeTime = writeGradeTime;
    }

    /** 
     * 获取 备注 student_write_grade.write_grade_note
     * @return 备注
     */
    public String getWriteGradeNote() {
        return writeGradeNote;
    }

    /** 
     * 设置 备注 student_write_grade.write_grade_note
     * @param writeGradeNote 备注
     */
    public void setWriteGradeNote(String writeGradeNote) {
        this.writeGradeNote = writeGradeNote == null ? null : writeGradeNote.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", writeGradeId=").append(writeGradeId);
        sb.append(", studentId=").append(studentId);
        sb.append(", staffId=").append(staffId);
        sb.append(", writeGradeSubject=").append(writeGradeSubject);
        sb.append(", writeGrade=").append(writeGrade);
        sb.append(", writeGradeTime=").append(writeGradeTime);
        sb.append(", writeGradeNote=").append(writeGradeNote);
        sb.append("]");
        return sb.toString();
    }
}