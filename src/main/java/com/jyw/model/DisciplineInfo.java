
package com.jyw.model;

import java.io.Serializable;

/**
 * 学科信息 discipline_info
 * 2016/11/05 16:28
*/
public class DisciplineInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 学科编号
     */
    private Integer disciplineId;

    /** 
     * 学科名称
     */
    private String disciplineName;

    /** 
     * 学科费用
     */
    private Integer disciplineTuition;

    /** 
     * 学科课时
     */
    private Integer disciplineBring;

    /** 
     * 备注
     */
    private String disciplineDesc;

    /** 
     * 是否有效
     */
    private String disciplineIsuesd;

    /** 
     * 构造查询条件
     */
    public DisciplineInfo(Integer disciplineId, String disciplineName, Integer disciplineTuition, Integer disciplineBring, String disciplineDesc, String disciplineIsuesd) {
        this.disciplineId = disciplineId;
        this.disciplineName = disciplineName;
        this.disciplineTuition = disciplineTuition;
        this.disciplineBring = disciplineBring;
        this.disciplineDesc = disciplineDesc;
        this.disciplineIsuesd = disciplineIsuesd;
    }

    /** 
     * 构造查询条件
     */
    public DisciplineInfo() {
        super();
    }

    /** 
     * 获取 学科编号 discipline_info.discipline_id
     * @return 学科编号
     */
    public Integer getDisciplineId() {
        return disciplineId;
    }

    /** 
     * 设置 学科编号 discipline_info.discipline_id
     * @param disciplineId 学科编号
     */
    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    /** 
     * 获取 学科名称 discipline_info.discipline_name
     * @return 学科名称
     */
    public String getDisciplineName() {
        return disciplineName;
    }

    /** 
     * 设置 学科名称 discipline_info.discipline_name
     * @param disciplineName 学科名称
     */
    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName == null ? null : disciplineName.trim();
    }

    /** 
     * 获取 学科费用 discipline_info.discipline_tuition
     * @return 学科费用
     */
    public Integer getDisciplineTuition() {
        return disciplineTuition;
    }

    /** 
     * 设置 学科费用 discipline_info.discipline_tuition
     * @param disciplineTuition 学科费用
     */
    public void setDisciplineTuition(Integer disciplineTuition) {
        this.disciplineTuition = disciplineTuition;
    }

    /** 
     * 获取 学科课时 discipline_info.discipline_bring
     * @return 学科课时
     */
    public Integer getDisciplineBring() {
        return disciplineBring;
    }

    /** 
     * 设置 学科课时 discipline_info.discipline_bring
     * @param disciplineBring 学科课时
     */
    public void setDisciplineBring(Integer disciplineBring) {
        this.disciplineBring = disciplineBring;
    }

    /** 
     * 获取 备注 discipline_info.discipline_desc
     * @return 备注
     */
    public String getDisciplineDesc() {
        return disciplineDesc;
    }

    /** 
     * 设置 备注 discipline_info.discipline_desc
     * @param disciplineDesc 备注
     */
    public void setDisciplineDesc(String disciplineDesc) {
        this.disciplineDesc = disciplineDesc == null ? null : disciplineDesc.trim();
    }

    /** 
     * 获取 是否有效 discipline_info.discipline_isuesd
     * @return 是否有效
     */
    public String getDisciplineIsuesd() {
        return disciplineIsuesd;
    }

    /** 
     * 设置 是否有效 discipline_info.discipline_isuesd
     * @param disciplineIsuesd 是否有效
     */
    public void setDisciplineIsuesd(String disciplineIsuesd) {
        this.disciplineIsuesd = disciplineIsuesd == null ? null : disciplineIsuesd.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", disciplineId=").append(disciplineId);
        sb.append(", disciplineName=").append(disciplineName);
        sb.append(", disciplineTuition=").append(disciplineTuition);
        sb.append(", disciplineBring=").append(disciplineBring);
        sb.append(", disciplineDesc=").append(disciplineDesc);
        sb.append(", disciplineIsuesd=").append(disciplineIsuesd);
        sb.append("]");
        return sb.toString();
    }
}