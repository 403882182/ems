package com.jyw.model;

/**
 * Created by Administrator on 2016/11/21 .
 */
public class StudentWriteGradeEx extends StudentWriteGrade  {
    private  StaffInfo staffInfo;
    private  StudentInfo studentInfo;

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public StudentWriteGradeEx() {}
}
