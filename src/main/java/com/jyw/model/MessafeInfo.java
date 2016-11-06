
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信信息 messafe_info
 * 2016/11/05 16:28
*/
public class MessafeInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 短信编号
     */
    private Integer messafeId;

    /** 
     * 发送人
     */
    private Integer staffId;

    /** 
     * 短信内容
     */
    private String messafeContent;

    /** 
     * 接收人
     */
    private String messafeMan;

    /** 
     * 接收人的手机号码
     */
    private String messafePhone;

    /** 
     * 发送时间
     */
    private Date messafeTime;

    /** 
     * 发送状态
     */
    private String messafeState;

    /** 
     * 构造查询条件
     */
    public MessafeInfo(Integer messafeId, Integer staffId, String messafeContent, String messafeMan, String messafePhone, Date messafeTime, String messafeState) {
        this.messafeId = messafeId;
        this.staffId = staffId;
        this.messafeContent = messafeContent;
        this.messafeMan = messafeMan;
        this.messafePhone = messafePhone;
        this.messafeTime = messafeTime;
        this.messafeState = messafeState;
    }

    /** 
     * 构造查询条件
     */
    public MessafeInfo() {
        super();
    }

    /** 
     * 获取 短信编号 messafe_info.messafe_id
     * @return 短信编号
     */
    public Integer getMessafeId() {
        return messafeId;
    }

    /** 
     * 设置 短信编号 messafe_info.messafe_id
     * @param messafeId 短信编号
     */
    public void setMessafeId(Integer messafeId) {
        this.messafeId = messafeId;
    }

    /** 
     * 获取 发送人 messafe_info.staff_id
     * @return 发送人
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 发送人 messafe_info.staff_id
     * @param staffId 发送人
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 短信内容 messafe_info.messafe_content
     * @return 短信内容
     */
    public String getMessafeContent() {
        return messafeContent;
    }

    /** 
     * 设置 短信内容 messafe_info.messafe_content
     * @param messafeContent 短信内容
     */
    public void setMessafeContent(String messafeContent) {
        this.messafeContent = messafeContent == null ? null : messafeContent.trim();
    }

    /** 
     * 获取 接收人 messafe_info.messafe_man
     * @return 接收人
     */
    public String getMessafeMan() {
        return messafeMan;
    }

    /** 
     * 设置 接收人 messafe_info.messafe_man
     * @param messafeMan 接收人
     */
    public void setMessafeMan(String messafeMan) {
        this.messafeMan = messafeMan == null ? null : messafeMan.trim();
    }

    /** 
     * 获取 接收人的手机号码 messafe_info.messafe_phone
     * @return 接收人的手机号码
     */
    public String getMessafePhone() {
        return messafePhone;
    }

    /** 
     * 设置 接收人的手机号码 messafe_info.messafe_phone
     * @param messafePhone 接收人的手机号码
     */
    public void setMessafePhone(String messafePhone) {
        this.messafePhone = messafePhone == null ? null : messafePhone.trim();
    }

    /** 
     * 获取 发送时间 messafe_info.messafe_time
     * @return 发送时间
     */
    public Date getMessafeTime() {
        return messafeTime;
    }

    /** 
     * 设置 发送时间 messafe_info.messafe_time
     * @param messafeTime 发送时间
     */
    public void setMessafeTime(Date messafeTime) {
        this.messafeTime = messafeTime;
    }

    /** 
     * 获取 发送状态 messafe_info.messafe_state
     * @return 发送状态
     */
    public String getMessafeState() {
        return messafeState;
    }

    /** 
     * 设置 发送状态 messafe_info.messafe_state
     * @param messafeState 发送状态
     */
    public void setMessafeState(String messafeState) {
        this.messafeState = messafeState == null ? null : messafeState.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", messafeId=").append(messafeId);
        sb.append(", staffId=").append(staffId);
        sb.append(", messafeContent=").append(messafeContent);
        sb.append(", messafeMan=").append(messafeMan);
        sb.append(", messafePhone=").append(messafePhone);
        sb.append(", messafeTime=").append(messafeTime);
        sb.append(", messafeState=").append(messafeState);
        sb.append("]");
        return sb.toString();
    }
}