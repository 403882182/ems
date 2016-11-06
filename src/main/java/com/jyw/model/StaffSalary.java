
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工薪水信息 staff_salary
 * 2016/11/05 16:28
*/
public class StaffSalary implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 员工薪水编号
     */
    private Integer staffSalaryId;

    /** 
     * 领取人
     */
    private Integer staffId;

    /** 
     * 财务人员
     */
    private Integer staStaffId;

    /** 
     * 本月薪水
     */
    private Double totalSalary;

    /** 
     * 扣除
     */
    private Double deductSalary;

    /** 
     * 实际发放薪水
     */
    private Double realSalary;

    /** 
     * 是否发放
     */
    private String isUesd;

    /** 
     * 领取日期
     */
    private Date staffSalaryTime;

    /** 
     * 备注信息
     */
    private String staffRemark;

    /** 
     * 构造查询条件
     */
    public StaffSalary(Integer staffSalaryId, Integer staffId, Integer staStaffId, Double totalSalary, Double deductSalary, Double realSalary, String isUesd, Date staffSalaryTime, String staffRemark) {
        this.staffSalaryId = staffSalaryId;
        this.staffId = staffId;
        this.staStaffId = staStaffId;
        this.totalSalary = totalSalary;
        this.deductSalary = deductSalary;
        this.realSalary = realSalary;
        this.isUesd = isUesd;
        this.staffSalaryTime = staffSalaryTime;
        this.staffRemark = staffRemark;
    }

    /** 
     * 构造查询条件
     */
    public StaffSalary() {
        super();
    }

    /** 
     * 获取 员工薪水编号 staff_salary.staff_salary_id
     * @return 员工薪水编号
     */
    public Integer getStaffSalaryId() {
        return staffSalaryId;
    }

    /** 
     * 设置 员工薪水编号 staff_salary.staff_salary_id
     * @param staffSalaryId 员工薪水编号
     */
    public void setStaffSalaryId(Integer staffSalaryId) {
        this.staffSalaryId = staffSalaryId;
    }

    /** 
     * 获取 领取人 staff_salary.staff_id
     * @return 领取人
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 领取人 staff_salary.staff_id
     * @param staffId 领取人
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 财务人员 staff_salary.sta_staff_id
     * @return 财务人员
     */
    public Integer getStaStaffId() {
        return staStaffId;
    }

    /** 
     * 设置 财务人员 staff_salary.sta_staff_id
     * @param staStaffId 财务人员
     */
    public void setStaStaffId(Integer staStaffId) {
        this.staStaffId = staStaffId;
    }

    /** 
     * 获取 本月薪水 staff_salary.total_salary
     * @return 本月薪水
     */
    public Double getTotalSalary() {
        return totalSalary;
    }

    /** 
     * 设置 本月薪水 staff_salary.total_salary
     * @param totalSalary 本月薪水
     */
    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    /** 
     * 获取 扣除 staff_salary.deduct_salary
     * @return 扣除
     */
    public Double getDeductSalary() {
        return deductSalary;
    }

    /** 
     * 设置 扣除 staff_salary.deduct_salary
     * @param deductSalary 扣除
     */
    public void setDeductSalary(Double deductSalary) {
        this.deductSalary = deductSalary;
    }

    /** 
     * 获取 实际发放薪水 staff_salary.real_salary
     * @return 实际发放薪水
     */
    public Double getRealSalary() {
        return realSalary;
    }

    /** 
     * 设置 实际发放薪水 staff_salary.real_salary
     * @param realSalary 实际发放薪水
     */
    public void setRealSalary(Double realSalary) {
        this.realSalary = realSalary;
    }

    /** 
     * 获取 是否发放 staff_salary.is_uesd
     * @return 是否发放
     */
    public String getIsUesd() {
        return isUesd;
    }

    /** 
     * 设置 是否发放 staff_salary.is_uesd
     * @param isUesd 是否发放
     */
    public void setIsUesd(String isUesd) {
        this.isUesd = isUesd == null ? null : isUesd.trim();
    }

    /** 
     * 获取 领取日期 staff_salary.staff_salary_time
     * @return 领取日期
     */
    public Date getStaffSalaryTime() {
        return staffSalaryTime;
    }

    /** 
     * 设置 领取日期 staff_salary.staff_salary_time
     * @param staffSalaryTime 领取日期
     */
    public void setStaffSalaryTime(Date staffSalaryTime) {
        this.staffSalaryTime = staffSalaryTime;
    }

    /** 
     * 获取 备注信息 staff_salary.staff_remark
     * @return 备注信息
     */
    public String getStaffRemark() {
        return staffRemark;
    }

    /** 
     * 设置 备注信息 staff_salary.staff_remark
     * @param staffRemark 备注信息
     */
    public void setStaffRemark(String staffRemark) {
        this.staffRemark = staffRemark == null ? null : staffRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", staffSalaryId=").append(staffSalaryId);
        sb.append(", staffId=").append(staffId);
        sb.append(", staStaffId=").append(staStaffId);
        sb.append(", totalSalary=").append(totalSalary);
        sb.append(", deductSalary=").append(deductSalary);
        sb.append(", realSalary=").append(realSalary);
        sb.append(", isUesd=").append(isUesd);
        sb.append(", staffSalaryTime=").append(staffSalaryTime);
        sb.append(", staffRemark=").append(staffRemark);
        sb.append("]");
        return sb.toString();
    }
}