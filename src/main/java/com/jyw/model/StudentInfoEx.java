package com.jyw.model;

/**
 * Created by Administrator on 2016/11/13 .
 */
public class StudentInfoEx extends  StudentInfo {
    private  StaffInfo staffInfo;

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public StudentInfoEx(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public StudentInfoEx() {
    }
}
