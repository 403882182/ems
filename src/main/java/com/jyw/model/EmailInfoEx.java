package com.jyw.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/9 .
 */
public class EmailInfoEx extends EmailInfo {
    private   StaffInfo  staffInfo;
    public EmailInfoEx(Integer emailId, Integer staffId, String emailTitle, String emailContent, Date emailTime, String emailMan, String emailAddr, String emailState, StaffInfo staffInfo) {
        super(emailId, staffId, emailTitle, emailContent, emailTime, emailMan, emailAddr, emailState);
        this.staffInfo = staffInfo;
    }

    public StaffInfo getStaffInfo() {

        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public EmailInfoEx() {

    }

}
