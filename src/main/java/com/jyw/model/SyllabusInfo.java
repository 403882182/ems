
package com.jyw.model;

import java.io.Serializable;

/**
 * 课程表 syllabus_info
 * 2016/11/05 16:28
*/
public class SyllabusInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 课程表编号
     */
    private Integer syllabusId;

    /** 
     * 星期一
     */
    private String syllabusYi;

    /** 
     * 星期二
     */
    private String syllabusEr;

    /** 
     * 星期三
     */
    private String syllabusSan;

    /** 
     * 星期四
     */
    private String syllabusSi;

    /** 
     * 星期五
     */
    private String syllabusWu;

    /** 
     * 星期六
     */
    private String syllabusLiu;

    /** 
     * 星期天
     */
    private String syllabusQi;

    /** 
     * 是否有效
     */
    private String isUesd;

    /** 
     * 课程表名称
     */
    private String syllabusName;

    /** 
     * 构造查询条件
     */
    public SyllabusInfo(Integer syllabusId, String syllabusYi, String syllabusEr, String syllabusSan, String syllabusSi, String syllabusWu, String syllabusLiu, String syllabusQi, String isUesd, String syllabusName) {
        this.syllabusId = syllabusId;
        this.syllabusYi = syllabusYi;
        this.syllabusEr = syllabusEr;
        this.syllabusSan = syllabusSan;
        this.syllabusSi = syllabusSi;
        this.syllabusWu = syllabusWu;
        this.syllabusLiu = syllabusLiu;
        this.syllabusQi = syllabusQi;
        this.isUesd = isUesd;
        this.syllabusName = syllabusName;
    }

    /** 
     * 构造查询条件
     */
    public SyllabusInfo() {
        super();
    }

    /** 
     * 获取 课程表编号 syllabus_info.syllabus_id
     * @return 课程表编号
     */
    public Integer getSyllabusId() {
        return syllabusId;
    }

    /** 
     * 设置 课程表编号 syllabus_info.syllabus_id
     * @param syllabusId 课程表编号
     */
    public void setSyllabusId(Integer syllabusId) {
        this.syllabusId = syllabusId;
    }

    /** 
     * 获取 星期一 syllabus_info.syllabus_yi
     * @return 星期一
     */
    public String getSyllabusYi() {
        return syllabusYi;
    }

    /** 
     * 设置 星期一 syllabus_info.syllabus_yi
     * @param syllabusYi 星期一
     */
    public void setSyllabusYi(String syllabusYi) {
        this.syllabusYi = syllabusYi == null ? null : syllabusYi.trim();
    }

    /** 
     * 获取 星期二 syllabus_info.syllabus_er
     * @return 星期二
     */
    public String getSyllabusEr() {
        return syllabusEr;
    }

    /** 
     * 设置 星期二 syllabus_info.syllabus_er
     * @param syllabusEr 星期二
     */
    public void setSyllabusEr(String syllabusEr) {
        this.syllabusEr = syllabusEr == null ? null : syllabusEr.trim();
    }

    /** 
     * 获取 星期三 syllabus_info.syllabus_san
     * @return 星期三
     */
    public String getSyllabusSan() {
        return syllabusSan;
    }

    /** 
     * 设置 星期三 syllabus_info.syllabus_san
     * @param syllabusSan 星期三
     */
    public void setSyllabusSan(String syllabusSan) {
        this.syllabusSan = syllabusSan == null ? null : syllabusSan.trim();
    }

    /** 
     * 获取 星期四 syllabus_info.syllabus_si
     * @return 星期四
     */
    public String getSyllabusSi() {
        return syllabusSi;
    }

    /** 
     * 设置 星期四 syllabus_info.syllabus_si
     * @param syllabusSi 星期四
     */
    public void setSyllabusSi(String syllabusSi) {
        this.syllabusSi = syllabusSi == null ? null : syllabusSi.trim();
    }

    /** 
     * 获取 星期五 syllabus_info.syllabus_wu
     * @return 星期五
     */
    public String getSyllabusWu() {
        return syllabusWu;
    }

    /** 
     * 设置 星期五 syllabus_info.syllabus_wu
     * @param syllabusWu 星期五
     */
    public void setSyllabusWu(String syllabusWu) {
        this.syllabusWu = syllabusWu == null ? null : syllabusWu.trim();
    }

    /** 
     * 获取 星期六 syllabus_info.syllabus_liu
     * @return 星期六
     */
    public String getSyllabusLiu() {
        return syllabusLiu;
    }

    /** 
     * 设置 星期六 syllabus_info.syllabus_liu
     * @param syllabusLiu 星期六
     */
    public void setSyllabusLiu(String syllabusLiu) {
        this.syllabusLiu = syllabusLiu == null ? null : syllabusLiu.trim();
    }

    /** 
     * 获取 星期天 syllabus_info.syllabus_qi
     * @return 星期天
     */
    public String getSyllabusQi() {
        return syllabusQi;
    }

    /** 
     * 设置 星期天 syllabus_info.syllabus_qi
     * @param syllabusQi 星期天
     */
    public void setSyllabusQi(String syllabusQi) {
        this.syllabusQi = syllabusQi == null ? null : syllabusQi.trim();
    }

    /** 
     * 获取 是否有效 syllabus_info.is_uesd
     * @return 是否有效
     */
    public String getIsUesd() {
        return isUesd;
    }

    /** 
     * 设置 是否有效 syllabus_info.is_uesd
     * @param isUesd 是否有效
     */
    public void setIsUesd(String isUesd) {
        this.isUesd = isUesd == null ? null : isUesd.trim();
    }

    /** 
     * 获取 课程表名称 syllabus_info.syllabus_name
     * @return 课程表名称
     */
    public String getSyllabusName() {
        return syllabusName;
    }

    /** 
     * 设置 课程表名称 syllabus_info.syllabus_name
     * @param syllabusName 课程表名称
     */
    public void setSyllabusName(String syllabusName) {
        this.syllabusName = syllabusName == null ? null : syllabusName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", syllabusId=").append(syllabusId);
        sb.append(", syllabusYi=").append(syllabusYi);
        sb.append(", syllabusEr=").append(syllabusEr);
        sb.append(", syllabusSan=").append(syllabusSan);
        sb.append(", syllabusSi=").append(syllabusSi);
        sb.append(", syllabusWu=").append(syllabusWu);
        sb.append(", syllabusLiu=").append(syllabusLiu);
        sb.append(", syllabusQi=").append(syllabusQi);
        sb.append(", isUesd=").append(isUesd);
        sb.append(", syllabusName=").append(syllabusName);
        sb.append("]");
        return sb.toString();
    }
}