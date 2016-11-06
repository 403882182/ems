
package com.jyw.model;

import java.io.Serializable;

/**
 * 模板 template_info
 * 2016/11/05 16:28
*/
public class TemplateInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 模板编号
     */
    private Integer templateId;

    /** 
     * 标题
     */
    private String templateTitle;

    /** 
     * 内容
     */
    private String templateContent;

    /** 
     * 类别
     */
    private String templateType;

    /** 
     * 构造查询条件
     */
    public TemplateInfo(Integer templateId, String templateTitle, String templateContent, String templateType) {
        this.templateId = templateId;
        this.templateTitle = templateTitle;
        this.templateContent = templateContent;
        this.templateType = templateType;
    }

    /** 
     * 构造查询条件
     */
    public TemplateInfo() {
        super();
    }

    /** 
     * 获取 模板编号 template_info.template_id
     * @return 模板编号
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /** 
     * 设置 模板编号 template_info.template_id
     * @param templateId 模板编号
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /** 
     * 获取 标题 template_info.template_title
     * @return 标题
     */
    public String getTemplateTitle() {
        return templateTitle;
    }

    /** 
     * 设置 标题 template_info.template_title
     * @param templateTitle 标题
     */
    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle == null ? null : templateTitle.trim();
    }

    /** 
     * 获取 内容 template_info.template_content
     * @return 内容
     */
    public String getTemplateContent() {
        return templateContent;
    }

    /** 
     * 设置 内容 template_info.template_content
     * @param templateContent 内容
     */
    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent == null ? null : templateContent.trim();
    }

    /** 
     * 获取 类别 template_info.template_type
     * @return 类别
     */
    public String getTemplateType() {
        return templateType;
    }

    /** 
     * 设置 类别 template_info.template_type
     * @param templateType 类别
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType == null ? null : templateType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", templateId=").append(templateId);
        sb.append(", templateTitle=").append(templateTitle);
        sb.append(", templateContent=").append(templateContent);
        sb.append(", templateType=").append(templateType);
        sb.append("]");
        return sb.toString();
    }
}