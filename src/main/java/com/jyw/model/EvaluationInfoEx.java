package com.jyw.model;

/**
 * Created by Administrator on 2016/11/13 .
 */
public class EvaluationInfoEx extends  EvaluationInfo {
    private  StudentInfo studentInfo;

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public EvaluationInfoEx(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public EvaluationInfoEx() {
    }
}
