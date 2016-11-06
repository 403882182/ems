
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件 email_info
 * 2016/11/05 16:28
*/
public class EmailInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 邮件编号
     */
    private Integer emailId;

    /** 
     * 员工编号
     */
    private Integer staffId;

    /** 
     * 主题
     */
    private String emailTitle;

    /** 
     * 内容
     */
    private String emailContent;

    /** 
     * 发送时间
     */
    private Date emailTime;

    /** 
     * 接收人
     */
    private String emailMan;

    /** 
     * 接收地址
     */
    private String emailAddr;

    /** 
     * 邮件状态
     */
    private String emailState;

    /** 
     * 构造查询条件
     */
    public EmailInfo(Integer emailId, Integer staffId, String emailTitle, String emailContent, Date emailTime, String emailMan, String emailAddr, String emailState) {
        this.emailId = emailId;
        this.staffId = staffId;
        this.emailTitle = emailTitle;
        this.emailContent = emailContent;
        this.emailTime = emailTime;
        this.emailMan = emailMan;
        this.emailAddr = emailAddr;
        this.emailState = emailState;
    }

    /** 
     * 构造查询条件
     */
    public EmailInfo() {
        super();
    }

    /** 
     * 获取 邮件编号 email_info.email_id
     * @return 邮件编号
     */
    public Integer getEmailId() {
        return emailId;
    }

    /** 
     * 设置 邮件编号 email_info.email_id
     * @param emailId 邮件编号
     */
    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    /** 
     * 获取 员工编号 email_info.staff_id
     * @return 员工编号
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 员工编号 email_info.staff_id
     * @param staffId 员工编号
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 主题 email_info.email_title
     * @return 主题
     */
    public String getEmailTitle() {
        return emailTitle;
    }

    /** 
     * 设置 主题 email_info.email_title
     * @param emailTitle 主题
     */
    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle == null ? null : emailTitle.trim();
    }

    /** 
     * 获取 内容 email_info.email_content
     * @return 内容
     */
    public String getEmailContent() {
        return emailContent;
    }

    /** 
     * 设置 内容 email_info.email_content
     * @param emailContent 内容
     */
    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent == null ? null : emailContent.trim();
    }

    /** 
     * 获取 发送时间 email_info.email_time
     * @return 发送时间
     */
    public Date getEmailTime() {
        return emailTime;
    }

    /** 
     * 设置 发送时间 email_info.email_time
     * @param emailTime 发送时间
     */
    public void setEmailTime(Date emailTime) {
        this.emailTime = emailTime;
    }

    /** 
     * 获取 接收人 email_info.email_man
     * @return 接收人
     */
    public String getEmailMan() {
        return emailMan;
    }

    /** 
     * 设置 接收人 email_info.email_man
     * @param emailMan 接收人
     */
    public void setEmailMan(String emailMan) {
        this.emailMan = emailMan == null ? null : emailMan.trim();
    }

    /** 
     * 获取 接收地址 email_info.email_addr
     * @return 接收地址
     */
    public String getEmailAddr() {
        return emailAddr;
    }

    /** 
     * 设置 接收地址 email_info.email_addr
     * @param emailAddr 接收地址
     */
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr == null ? null : emailAddr.trim();
    }

    /** 
     * 获取 邮件状态 email_info.email_state
     * @return 邮件状态
     */
    public String getEmailState() {
        return emailState;
    }

    /** 
     * 设置 邮件状态 email_info.email_state
     * @param emailState 邮件状态
     */
    public void setEmailState(String emailState) {
        this.emailState = emailState == null ? null : emailState.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", emailId=").append(emailId);
        sb.append(", staffId=").append(staffId);
        sb.append(", emailTitle=").append(emailTitle);
        sb.append(", emailContent=").append(emailContent);
        sb.append(", emailTime=").append(emailTime);
        sb.append(", emailMan=").append(emailMan);
        sb.append(", emailAddr=").append(emailAddr);
        sb.append(", emailState=").append(emailState);
        sb.append("]");
        return sb.toString();
    }
}