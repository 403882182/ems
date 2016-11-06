
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工信息 staff_info
 * 2016/11/05 16:28
*/
public class StaffInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 员工编号
     */
    private Integer staffId;

    /** 
     * 角色编号
     */
    private Integer roleId;

    /** 
     * 员工姓名
     */
    private String staffName;

    /** 
     * 员工性别
     */
    private String staffSex;

    /** 
     * 员工工龄
     */
    private Integer staffAge;

    /** 
     * 员工籍贯
     */
    private String staffNativePlace;

    /** 
     * 身份证号码
     */
    private String staffIdcard;

    /** 
     * 出生日期
     */
    private Date staffBrithday;

    /** 
     * 办公电话
     */
    private String staffOfficePhone;

    /** 
     * 移动电话
     */
    private String staffMobilePhone;

    /** 
     * 电子邮箱
     */
    private String staffEamil;

    /** 
     * 家庭住址
     */
    private String staffAddr;

    /** 
     * QQ号码
     */
    private String staffQq;

    /** 
     * 入职时间
     */
    private Date staffEntryTime;

    /** 
     * 教育水平
     */
    private String staffEductionLevel;

    /** 
     * 备注信息
     */
    private String staffRemark;

    /** 
     * 状态
     */
    private String staffState;

    /** 
     * 账号
     */
    private String userNumber;

    /** 
     * 密码
     */
    private String userPassowrd;

    /** 
     * 构造查询条件
     */
    public StaffInfo(Integer staffId, Integer roleId, String staffName, String staffSex, Integer staffAge, String staffNativePlace, String staffIdcard, Date staffBrithday, String staffOfficePhone, String staffMobilePhone, String staffEamil, String staffAddr, String staffQq, Date staffEntryTime, String staffEductionLevel, String staffRemark, String staffState, String userNumber, String userPassowrd) {
        this.staffId = staffId;
        this.roleId = roleId;
        this.staffName = staffName;
        this.staffSex = staffSex;
        this.staffAge = staffAge;
        this.staffNativePlace = staffNativePlace;
        this.staffIdcard = staffIdcard;
        this.staffBrithday = staffBrithday;
        this.staffOfficePhone = staffOfficePhone;
        this.staffMobilePhone = staffMobilePhone;
        this.staffEamil = staffEamil;
        this.staffAddr = staffAddr;
        this.staffQq = staffQq;
        this.staffEntryTime = staffEntryTime;
        this.staffEductionLevel = staffEductionLevel;
        this.staffRemark = staffRemark;
        this.staffState = staffState;
        this.userNumber = userNumber;
        this.userPassowrd = userPassowrd;
    }

    /** 
     * 构造查询条件
     */
    public StaffInfo() {
        super();
    }

    /** 
     * 获取 员工编号 staff_info.staff_id
     * @return 员工编号
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 员工编号 staff_info.staff_id
     * @param staffId 员工编号
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 角色编号 staff_info.role_id
     * @return 角色编号
     */
    public Integer getRoleId() {
        return roleId;
    }

    /** 
     * 设置 角色编号 staff_info.role_id
     * @param roleId 角色编号
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /** 
     * 获取 员工姓名 staff_info.staff_name
     * @return 员工姓名
     */
    public String getStaffName() {
        return staffName;
    }

    /** 
     * 设置 员工姓名 staff_info.staff_name
     * @param staffName 员工姓名
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    /** 
     * 获取 员工性别 staff_info.staff_sex
     * @return 员工性别
     */
    public String getStaffSex() {
        return staffSex;
    }

    /** 
     * 设置 员工性别 staff_info.staff_sex
     * @param staffSex 员工性别
     */
    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    /** 
     * 获取 员工工龄 staff_info.staff_age
     * @return 员工工龄
     */
    public Integer getStaffAge() {
        return staffAge;
    }

    /** 
     * 设置 员工工龄 staff_info.staff_age
     * @param staffAge 员工工龄
     */
    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    /** 
     * 获取 员工籍贯 staff_info.staff_native_place
     * @return 员工籍贯
     */
    public String getStaffNativePlace() {
        return staffNativePlace;
    }

    /** 
     * 设置 员工籍贯 staff_info.staff_native_place
     * @param staffNativePlace 员工籍贯
     */
    public void setStaffNativePlace(String staffNativePlace) {
        this.staffNativePlace = staffNativePlace == null ? null : staffNativePlace.trim();
    }

    /** 
     * 获取 身份证号码 staff_info.staff_idcard
     * @return 身份证号码
     */
    public String getStaffIdcard() {
        return staffIdcard;
    }

    /** 
     * 设置 身份证号码 staff_info.staff_idcard
     * @param staffIdcard 身份证号码
     */
    public void setStaffIdcard(String staffIdcard) {
        this.staffIdcard = staffIdcard == null ? null : staffIdcard.trim();
    }

    /** 
     * 获取 出生日期 staff_info.staff_brithday
     * @return 出生日期
     */
    public Date getStaffBrithday() {
        return staffBrithday;
    }

    /** 
     * 设置 出生日期 staff_info.staff_brithday
     * @param staffBrithday 出生日期
     */
    public void setStaffBrithday(Date staffBrithday) {
        this.staffBrithday = staffBrithday;
    }

    /** 
     * 获取 办公电话 staff_info.staff_office_phone
     * @return 办公电话
     */
    public String getStaffOfficePhone() {
        return staffOfficePhone;
    }

    /** 
     * 设置 办公电话 staff_info.staff_office_phone
     * @param staffOfficePhone 办公电话
     */
    public void setStaffOfficePhone(String staffOfficePhone) {
        this.staffOfficePhone = staffOfficePhone == null ? null : staffOfficePhone.trim();
    }

    /** 
     * 获取 移动电话 staff_info.staff_mobile_phone
     * @return 移动电话
     */
    public String getStaffMobilePhone() {
        return staffMobilePhone;
    }

    /** 
     * 设置 移动电话 staff_info.staff_mobile_phone
     * @param staffMobilePhone 移动电话
     */
    public void setStaffMobilePhone(String staffMobilePhone) {
        this.staffMobilePhone = staffMobilePhone == null ? null : staffMobilePhone.trim();
    }

    /** 
     * 获取 电子邮箱 staff_info.staff_eamil
     * @return 电子邮箱
     */
    public String getStaffEamil() {
        return staffEamil;
    }

    /** 
     * 设置 电子邮箱 staff_info.staff_eamil
     * @param staffEamil 电子邮箱
     */
    public void setStaffEamil(String staffEamil) {
        this.staffEamil = staffEamil == null ? null : staffEamil.trim();
    }

    /** 
     * 获取 家庭住址 staff_info.staff_addr
     * @return 家庭住址
     */
    public String getStaffAddr() {
        return staffAddr;
    }

    /** 
     * 设置 家庭住址 staff_info.staff_addr
     * @param staffAddr 家庭住址
     */
    public void setStaffAddr(String staffAddr) {
        this.staffAddr = staffAddr == null ? null : staffAddr.trim();
    }

    /** 
     * 获取 QQ号码 staff_info.staff_qq
     * @return QQ号码
     */
    public String getStaffQq() {
        return staffQq;
    }

    /** 
     * 设置 QQ号码 staff_info.staff_qq
     * @param staffQq QQ号码
     */
    public void setStaffQq(String staffQq) {
        this.staffQq = staffQq == null ? null : staffQq.trim();
    }

    /** 
     * 获取 入职时间 staff_info.staff_entry_time
     * @return 入职时间
     */
    public Date getStaffEntryTime() {
        return staffEntryTime;
    }

    /** 
     * 设置 入职时间 staff_info.staff_entry_time
     * @param staffEntryTime 入职时间
     */
    public void setStaffEntryTime(Date staffEntryTime) {
        this.staffEntryTime = staffEntryTime;
    }

    /** 
     * 获取 教育水平 staff_info.staff_eduction_level
     * @return 教育水平
     */
    public String getStaffEductionLevel() {
        return staffEductionLevel;
    }

    /** 
     * 设置 教育水平 staff_info.staff_eduction_level
     * @param staffEductionLevel 教育水平
     */
    public void setStaffEductionLevel(String staffEductionLevel) {
        this.staffEductionLevel = staffEductionLevel == null ? null : staffEductionLevel.trim();
    }

    /** 
     * 获取 备注信息 staff_info.staff_remark
     * @return 备注信息
     */
    public String getStaffRemark() {
        return staffRemark;
    }

    /** 
     * 设置 备注信息 staff_info.staff_remark
     * @param staffRemark 备注信息
     */
    public void setStaffRemark(String staffRemark) {
        this.staffRemark = staffRemark == null ? null : staffRemark.trim();
    }

    /** 
     * 获取 状态 staff_info.staff_state
     * @return 状态
     */
    public String getStaffState() {
        return staffState;
    }

    /** 
     * 设置 状态 staff_info.staff_state
     * @param staffState 状态
     */
    public void setStaffState(String staffState) {
        this.staffState = staffState == null ? null : staffState.trim();
    }

    /** 
     * 获取 账号 staff_info.user_number
     * @return 账号
     */
    public String getUserNumber() {
        return userNumber;
    }

    /** 
     * 设置 账号 staff_info.user_number
     * @param userNumber 账号
     */
    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    /** 
     * 获取 密码 staff_info.user_passowrd
     * @return 密码
     */
    public String getUserPassowrd() {
        return userPassowrd;
    }

    /** 
     * 设置 密码 staff_info.user_passowrd
     * @param userPassowrd 密码
     */
    public void setUserPassowrd(String userPassowrd) {
        this.userPassowrd = userPassowrd == null ? null : userPassowrd.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", staffId=").append(staffId);
        sb.append(", roleId=").append(roleId);
        sb.append(", staffName=").append(staffName);
        sb.append(", staffSex=").append(staffSex);
        sb.append(", staffAge=").append(staffAge);
        sb.append(", staffNativePlace=").append(staffNativePlace);
        sb.append(", staffIdcard=").append(staffIdcard);
        sb.append(", staffBrithday=").append(staffBrithday);
        sb.append(", staffOfficePhone=").append(staffOfficePhone);
        sb.append(", staffMobilePhone=").append(staffMobilePhone);
        sb.append(", staffEamil=").append(staffEamil);
        sb.append(", staffAddr=").append(staffAddr);
        sb.append(", staffQq=").append(staffQq);
        sb.append(", staffEntryTime=").append(staffEntryTime);
        sb.append(", staffEductionLevel=").append(staffEductionLevel);
        sb.append(", staffRemark=").append(staffRemark);
        sb.append(", staffState=").append(staffState);
        sb.append(", userNumber=").append(userNumber);
        sb.append(", userPassowrd=").append(userPassowrd);
        sb.append("]");
        return sb.toString();
    }
}