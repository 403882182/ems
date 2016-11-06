
package com.jyw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销活动 market_active
 * 2016/11/05 16:28
*/
public class MarketActive implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 活动编号
     */
    private Integer activeId;

    /** 
     * 负责人
     */
    private Integer staffId;

    /** 
     * 活动名称
     */
    private String activeName;

    /** 
     * 活动状态
     */
    private Integer activeState;

    /** 
     * 开始时间
     */
    private Date activeStart;

    /** 
     * 结束时间
     */
    private Date activeEnd;

    /** 
     * 活动类型
     */
    private Integer activeType;

    /** 
     * 成本预算
     */
    private Double activeCosteEmtimate;

    /** 
     * 实际成本
     */
    private Double activeCoste;

    /** 
     * 预期反应
     */
    private Integer activeRefectEstimate;

    /** 
     * 预期学员
     */
    private String activeStudent;

    /** 
     * 描述
     */
    private String activeContent;

    /** 
     * 构造查询条件
     */
    public MarketActive(Integer activeId, Integer staffId, String activeName, Integer activeState, Date activeStart, Date activeEnd, Integer activeType, Double activeCosteEmtimate, Double activeCoste, Integer activeRefectEstimate, String activeStudent, String activeContent) {
        this.activeId = activeId;
        this.staffId = staffId;
        this.activeName = activeName;
        this.activeState = activeState;
        this.activeStart = activeStart;
        this.activeEnd = activeEnd;
        this.activeType = activeType;
        this.activeCosteEmtimate = activeCosteEmtimate;
        this.activeCoste = activeCoste;
        this.activeRefectEstimate = activeRefectEstimate;
        this.activeStudent = activeStudent;
        this.activeContent = activeContent;
    }

    /** 
     * 构造查询条件
     */
    public MarketActive() {
        super();
    }

    /** 
     * 获取 活动编号 market_active.active_id
     * @return 活动编号
     */
    public Integer getActiveId() {
        return activeId;
    }

    /** 
     * 设置 活动编号 market_active.active_id
     * @param activeId 活动编号
     */
    public void setActiveId(Integer activeId) {
        this.activeId = activeId;
    }

    /** 
     * 获取 负责人 market_active.staff_id
     * @return 负责人
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 负责人 market_active.staff_id
     * @param staffId 负责人
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 活动名称 market_active.active_name
     * @return 活动名称
     */
    public String getActiveName() {
        return activeName;
    }

    /** 
     * 设置 活动名称 market_active.active_name
     * @param activeName 活动名称
     */
    public void setActiveName(String activeName) {
        this.activeName = activeName == null ? null : activeName.trim();
    }

    /** 
     * 获取 活动状态 market_active.active_state
     * @return 活动状态
     */
    public Integer getActiveState() {
        return activeState;
    }

    /** 
     * 设置 活动状态 market_active.active_state
     * @param activeState 活动状态
     */
    public void setActiveState(Integer activeState) {
        this.activeState = activeState;
    }

    /** 
     * 获取 开始时间 market_active.active_start
     * @return 开始时间
     */
    public Date getActiveStart() {
        return activeStart;
    }

    /** 
     * 设置 开始时间 market_active.active_start
     * @param activeStart 开始时间
     */
    public void setActiveStart(Date activeStart) {
        this.activeStart = activeStart;
    }

    /** 
     * 获取 结束时间 market_active.active_end
     * @return 结束时间
     */
    public Date getActiveEnd() {
        return activeEnd;
    }

    /** 
     * 设置 结束时间 market_active.active_end
     * @param activeEnd 结束时间
     */
    public void setActiveEnd(Date activeEnd) {
        this.activeEnd = activeEnd;
    }

    /** 
     * 获取 活动类型 market_active.active_type
     * @return 活动类型
     */
    public Integer getActiveType() {
        return activeType;
    }

    /** 
     * 设置 活动类型 market_active.active_type
     * @param activeType 活动类型
     */
    public void setActiveType(Integer activeType) {
        this.activeType = activeType;
    }

    /** 
     * 获取 成本预算 market_active.active_coste_emtimate
     * @return 成本预算
     */
    public Double getActiveCosteEmtimate() {
        return activeCosteEmtimate;
    }

    /** 
     * 设置 成本预算 market_active.active_coste_emtimate
     * @param activeCosteEmtimate 成本预算
     */
    public void setActiveCosteEmtimate(Double activeCosteEmtimate) {
        this.activeCosteEmtimate = activeCosteEmtimate;
    }

    /** 
     * 获取 实际成本 market_active.active_coste
     * @return 实际成本
     */
    public Double getActiveCoste() {
        return activeCoste;
    }

    /** 
     * 设置 实际成本 market_active.active_coste
     * @param activeCoste 实际成本
     */
    public void setActiveCoste(Double activeCoste) {
        this.activeCoste = activeCoste;
    }

    /** 
     * 获取 预期反应 market_active.active_refect_estimate
     * @return 预期反应
     */
    public Integer getActiveRefectEstimate() {
        return activeRefectEstimate;
    }

    /** 
     * 设置 预期反应 market_active.active_refect_estimate
     * @param activeRefectEstimate 预期反应
     */
    public void setActiveRefectEstimate(Integer activeRefectEstimate) {
        this.activeRefectEstimate = activeRefectEstimate;
    }

    /** 
     * 获取 预期学员 market_active.active_student
     * @return 预期学员
     */
    public String getActiveStudent() {
        return activeStudent;
    }

    /** 
     * 设置 预期学员 market_active.active_student
     * @param activeStudent 预期学员
     */
    public void setActiveStudent(String activeStudent) {
        this.activeStudent = activeStudent == null ? null : activeStudent.trim();
    }

    /** 
     * 获取 描述 market_active.active_content
     * @return 描述
     */
    public String getActiveContent() {
        return activeContent;
    }

    /** 
     * 设置 描述 market_active.active_content
     * @param activeContent 描述
     */
    public void setActiveContent(String activeContent) {
        this.activeContent = activeContent == null ? null : activeContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", activeId=").append(activeId);
        sb.append(", staffId=").append(staffId);
        sb.append(", activeName=").append(activeName);
        sb.append(", activeState=").append(activeState);
        sb.append(", activeStart=").append(activeStart);
        sb.append(", activeEnd=").append(activeEnd);
        sb.append(", activeType=").append(activeType);
        sb.append(", activeCosteEmtimate=").append(activeCosteEmtimate);
        sb.append(", activeCoste=").append(activeCoste);
        sb.append(", activeRefectEstimate=").append(activeRefectEstimate);
        sb.append(", activeStudent=").append(activeStudent);
        sb.append(", activeContent=").append(activeContent);
        sb.append("]");
        return sb.toString();
    }
}