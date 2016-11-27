package com.jyw.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/11 .
 */
public class MessfeInfoEx extends MessafeInfo {
    private StaffInfo staffInfo;

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public MessfeInfoEx() {
    }

    public MessfeInfoEx(Integer messafeId, Integer staffId, String messafeContent, String messafeMan, String messafePhone, Date messafeTime, String messafeState, StaffInfo staffInfo) {
        super(messafeId, staffId, messafeContent, messafeMan, messafePhone, messafeTime, messafeState);
        this.staffInfo = staffInfo;
    }
}
