
package com.jyw.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 数据字典 data_dictionary
 * 2016/11/05 16:28
*/
public class DataDictionary implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 数据编号
     */
    private Integer dataId;

    /** 
     * 内容
     */
    @NotEmpty
    private String dataContent;

    /** 
     * 类型
     */
    @NotEmpty
    private String dataType;

    /** 
     * 描述
     */
    private String dataDesc;

    /** 
     * 构造查询条件
     */
    public DataDictionary(Integer dataId, String dataContent, String dataType, String dataDesc) {
        this.dataId = dataId;
        this.dataContent = dataContent;
        this.dataType = dataType;
        this.dataDesc = dataDesc;
    }

    /** 
     * 构造查询条件
     */
    public DataDictionary() {
        super();
    }

    /** 
     * 获取 数据编号 data_dictionary.data_id
     * @return 数据编号
     */
    public Integer getDataId() {
        return dataId;
    }

    /** 
     * 设置 数据编号 data_dictionary.data_id
     * @param dataId 数据编号
     */
    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    /** 
     * 获取 内容 data_dictionary.data_content
     * @return 内容
     */
    public String getDataContent() {
        return dataContent;
    }

    /** 
     * 设置 内容 data_dictionary.data_content
     * @param dataContent 内容
     */
    public void setDataContent(String dataContent) {
        this.dataContent = dataContent == null ? null : dataContent.trim();
    }

    /** 
     * 获取 类型 data_dictionary.data_type
     * @return 类型
     */
    public String getDataType() {
        return dataType;
    }

    /** 
     * 设置 类型 data_dictionary.data_type
     * @param dataType 类型
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /** 
     * 获取 描述 data_dictionary.data_desc
     * @return 描述
     */
    public String getDataDesc() {
        return dataDesc;
    }

    /** 
     * 设置 描述 data_dictionary.data_desc
     * @param dataDesc 描述
     */
    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc == null ? null : dataDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", dataId=").append(dataId);
        sb.append(", dataContent=").append(dataContent);
        sb.append(", dataType=").append(dataType);
        sb.append(", dataDesc=").append(dataDesc);
        sb.append("]");
        return sb.toString();
    }
}