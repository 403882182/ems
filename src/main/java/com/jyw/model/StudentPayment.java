
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生缴费信息 student_payment
 * 2016/11/05 16:28
*/
public class StudentPayment implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 缴费编号
     */
    private Integer paymentId;

    /** 
     * 学员编号
     */
    private Integer studentId;

    /** 
     * 员工编号
     */
    private Integer staffId;

    /** 
     * 缴费情况
     */
    private String paymentSituation;

    /** 
     * 缴费方式
     */
    private Integer paymentMethod;

    /** 
     * 缴费时间
     */
    private Date paymentTime;

    /** 
     * 优惠金额
     */
    private Double discountAmount;

    /** 
     * 应交金额
     */
    private Double shouldAmount;

    /** 
     * 实交金额
     */
    private Double realAmount;

    /** 
     * 欠款
     */
    private Double debtAmount;

    /** 
     * 备注
     */
    private String paymentRemark;

    private StudentInfo studentInfo;
    /** 
     * 构造查询条件
     */
    public StudentPayment(Integer paymentId, Integer studentId, Integer staffId, String paymentSituation, Integer paymentMethod, Date paymentTime, Double discountAmount, Double shouldAmount, Double realAmount, Double debtAmount, String paymentRemark) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.staffId = staffId;
        this.paymentSituation = paymentSituation;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
        this.discountAmount = discountAmount;
        this.shouldAmount = shouldAmount;
        this.realAmount = realAmount;
        this.debtAmount = debtAmount;
        this.paymentRemark = paymentRemark;
    }

    /**
     * 构造查询条件
     */
    public StudentPayment() {
        super();
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }
    /** 
     * 获取 缴费编号 student_payment.payment_id
     * @return 缴费编号
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /** 
     * 设置 缴费编号 student_payment.payment_id
     * @param paymentId 缴费编号
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    /** 
     * 获取 学员编号 student_payment.student_id
     * @return 学员编号
     */
    public Integer getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学员编号 student_payment.student_id
     * @param studentId 学员编号
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取 员工编号 student_payment.staff_id
     * @return 员工编号
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 员工编号 student_payment.staff_id
     * @param staffId 员工编号
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 缴费情况 student_payment.payment_situation
     * @return 缴费情况
     */
    public String getPaymentSituation() {
        return paymentSituation;
    }

    /** 
     * 设置 缴费情况 student_payment.payment_situation
     * @param paymentSituation 缴费情况
     */
    public void setPaymentSituation(String paymentSituation) {
        this.paymentSituation = paymentSituation == null ? null : paymentSituation.trim();
    }

    /** 
     * 获取 缴费方式 student_payment.payment_method
     * @return 缴费方式
     */
    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    /** 
     * 设置 缴费方式 student_payment.payment_method
     * @param paymentMethod 缴费方式
     */
    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /** 
     * 获取 缴费时间 student_payment.payment_time
     * @return 缴费时间
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /** 
     * 设置 缴费时间 student_payment.payment_time
     * @param paymentTime 缴费时间
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /** 
     * 获取 优惠金额 student_payment.discount_amount
     * @return 优惠金额
     */
    public Double getDiscountAmount() {
        return discountAmount;
    }

    /** 
     * 设置 优惠金额 student_payment.discount_amount
     * @param discountAmount 优惠金额
     */
    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    /** 
     * 获取 应交金额 student_payment.should_amount
     * @return 应交金额
     */
    public Double getShouldAmount() {
        return shouldAmount;
    }

    /** 
     * 设置 应交金额 student_payment.should_amount
     * @param shouldAmount 应交金额
     */
    public void setShouldAmount(Double shouldAmount) {
        this.shouldAmount = shouldAmount;
    }

    /** 
     * 获取 实交金额 student_payment.real_amount
     * @return 实交金额
     */
    public Double getRealAmount() {
        return realAmount;
    }

    /** 
     * 设置 实交金额 student_payment.real_amount
     * @param realAmount 实交金额
     */
    public void setRealAmount(Double realAmount) {
        this.realAmount = realAmount;
    }

    /** 
     * 获取 欠款 student_payment.debt_amount
     * @return 欠款
     */
    public Double getDebtAmount() {
        return debtAmount;
    }

    /** 
     * 设置 欠款 student_payment.debt_amount
     * @param debtAmount 欠款
     */
    public void setDebtAmount(Double debtAmount) {
        this.debtAmount = debtAmount;
    }

    /** 
     * 获取 备注 student_payment.payment_remark
     * @return 备注
     */
    public String getPaymentRemark() {
        return paymentRemark;
    }

    /** 
     * 设置 备注 student_payment.payment_remark
     * @param paymentRemark 备注
     */
    public void setPaymentRemark(String paymentRemark) {
        this.paymentRemark = paymentRemark == null ? null : paymentRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", paymentId=").append(paymentId);
        sb.append(", studentId=").append(studentId);
        sb.append(", staffId=").append(staffId);
        sb.append(", paymentSituation=").append(paymentSituation);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", shouldAmount=").append(shouldAmount);
        sb.append(", realAmount=").append(realAmount);
        sb.append(", debtAmount=").append(debtAmount);
        sb.append(", paymentRemark=").append(paymentRemark);
        sb.append("]");
        return sb.toString();
    }
}