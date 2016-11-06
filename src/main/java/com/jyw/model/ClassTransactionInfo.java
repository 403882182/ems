
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级事务信息 class_transaction_info
 * 2016/11/05 16:28
*/
public class ClassTransactionInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 班级事务信息编号
     */
    private Integer classTransactionId;

    /** 
     * 班级编号
     */
    private Integer classId;

    /** 
     * 主题
     */
    private String classTransactionTitle;

    /** 
     * 内容
     */
    private String classTransactionContent;

    /** 
     * 组织人
     */
    private String classTransactionPerson;

    /** 
     * 活动日期
     */
    private Date classTransactionTime;

    /** 
     * 备注信息
     */
    private String classTransactionRemark;

    /** 
     * 构造查询条件
     */
    public ClassTransactionInfo(Integer classTransactionId, Integer classId, String classTransactionTitle, String classTransactionContent, String classTransactionPerson, Date classTransactionTime, String classTransactionRemark) {
        this.classTransactionId = classTransactionId;
        this.classId = classId;
        this.classTransactionTitle = classTransactionTitle;
        this.classTransactionContent = classTransactionContent;
        this.classTransactionPerson = classTransactionPerson;
        this.classTransactionTime = classTransactionTime;
        this.classTransactionRemark = classTransactionRemark;
    }

    /** 
     * 构造查询条件
     */
    public ClassTransactionInfo() {
        super();
    }

    /** 
     * 获取 班级事务信息编号 class_transaction_info.class_transaction_id
     * @return 班级事务信息编号
     */
    public Integer getClassTransactionId() {
        return classTransactionId;
    }

    /** 
     * 设置 班级事务信息编号 class_transaction_info.class_transaction_id
     * @param classTransactionId 班级事务信息编号
     */
    public void setClassTransactionId(Integer classTransactionId) {
        this.classTransactionId = classTransactionId;
    }

    /** 
     * 获取 班级编号 class_transaction_info.class_id
     * @return 班级编号
     */
    public Integer getClassId() {
        return classId;
    }

    /** 
     * 设置 班级编号 class_transaction_info.class_id
     * @param classId 班级编号
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /** 
     * 获取 主题 class_transaction_info.class_transaction_title
     * @return 主题
     */
    public String getClassTransactionTitle() {
        return classTransactionTitle;
    }

    /** 
     * 设置 主题 class_transaction_info.class_transaction_title
     * @param classTransactionTitle 主题
     */
    public void setClassTransactionTitle(String classTransactionTitle) {
        this.classTransactionTitle = classTransactionTitle == null ? null : classTransactionTitle.trim();
    }

    /** 
     * 获取 内容 class_transaction_info.class_transaction_content
     * @return 内容
     */
    public String getClassTransactionContent() {
        return classTransactionContent;
    }

    /** 
     * 设置 内容 class_transaction_info.class_transaction_content
     * @param classTransactionContent 内容
     */
    public void setClassTransactionContent(String classTransactionContent) {
        this.classTransactionContent = classTransactionContent == null ? null : classTransactionContent.trim();
    }

    /** 
     * 获取 组织人 class_transaction_info.class_transaction_person
     * @return 组织人
     */
    public String getClassTransactionPerson() {
        return classTransactionPerson;
    }

    /** 
     * 设置 组织人 class_transaction_info.class_transaction_person
     * @param classTransactionPerson 组织人
     */
    public void setClassTransactionPerson(String classTransactionPerson) {
        this.classTransactionPerson = classTransactionPerson == null ? null : classTransactionPerson.trim();
    }

    /** 
     * 获取 活动日期 class_transaction_info.class_transaction_time
     * @return 活动日期
     */
    public Date getClassTransactionTime() {
        return classTransactionTime;
    }

    /** 
     * 设置 活动日期 class_transaction_info.class_transaction_time
     * @param classTransactionTime 活动日期
     */
    public void setClassTransactionTime(Date classTransactionTime) {
        this.classTransactionTime = classTransactionTime;
    }

    /** 
     * 获取 备注信息 class_transaction_info.class_transaction_remark
     * @return 备注信息
     */
    public String getClassTransactionRemark() {
        return classTransactionRemark;
    }

    /** 
     * 设置 备注信息 class_transaction_info.class_transaction_remark
     * @param classTransactionRemark 备注信息
     */
    public void setClassTransactionRemark(String classTransactionRemark) {
        this.classTransactionRemark = classTransactionRemark == null ? null : classTransactionRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", classTransactionId=").append(classTransactionId);
        sb.append(", classId=").append(classId);
        sb.append(", classTransactionTitle=").append(classTransactionTitle);
        sb.append(", classTransactionContent=").append(classTransactionContent);
        sb.append(", classTransactionPerson=").append(classTransactionPerson);
        sb.append(", classTransactionTime=").append(classTransactionTime);
        sb.append(", classTransactionRemark=").append(classTransactionRemark);
        sb.append("]");
        return sb.toString();
    }
}