package com.jyw.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/10 .
 */
public class MarketActiveEx extends MarketActive {
    private StaffInfo staffInfo;
    private DataDictionary dataDictionary;

    public DataDictionary getDataDictionary() {
        return dataDictionary;
    }

    public void setDataDictionary(DataDictionary dataDictionary) {
        this.dataDictionary = dataDictionary;
    }

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public MarketActiveEx(Integer activeId, Integer staffId, String activeName, Integer activeState, Date activeStart, Date activeEnd, Integer activeType, Double activeCosteEmtimate, Double activeCoste, Integer activeRefectEstimate, String activeStudent, String activeContent, StaffInfo staffInfo) {
        super(activeId, staffId, activeName, activeState, activeStart, activeEnd, activeType, activeCosteEmtimate, activeCoste, activeRefectEstimate, activeStudent, activeContent);
        this.staffInfo = staffInfo;
    }
    public MarketActiveEx() {}
}
