
package com.jyw.model;

import java.io.Serializable;

/**
 * 权限信息 anthorty_info
 * 2016/11/05 16:28
*/
public class AnthortyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 权限编号
     */
    private Integer anthortyId;

    /** 
     * 上级编号
     */
    private Integer anthortyPid;

    /** 
     * 权限名称
     */
    private String anthortyName;

    /** 
     * 权限描述
     */
    private String anthortyDesc;

    /** 
     * 权限url
     */
    private String anthortyUrl;

    /** 
     * 构造查询条件
     */
    public AnthortyInfo(Integer anthortyId, Integer anthortyPid, String anthortyName, String anthortyDesc, String anthortyUrl) {
        this.anthortyId = anthortyId;
        this.anthortyPid = anthortyPid;
        this.anthortyName = anthortyName;
        this.anthortyDesc = anthortyDesc;
        this.anthortyUrl = anthortyUrl;
    }

    /** 
     * 构造查询条件
     */
    public AnthortyInfo() {
        super();
    }

    /** 
     * 获取 权限编号 anthorty_info.anthorty_id
     * @return 权限编号
     */
    public Integer getAnthortyId() {
        return anthortyId;
    }

    /** 
     * 设置 权限编号 anthorty_info.anthorty_id
     * @param anthortyId 权限编号
     */
    public void setAnthortyId(Integer anthortyId) {
        this.anthortyId = anthortyId;
    }

    /** 
     * 获取 上级编号 anthorty_info.anthorty_pid
     * @return 上级编号
     */
    public Integer getAnthortyPid() {
        return anthortyPid;
    }

    /** 
     * 设置 上级编号 anthorty_info.anthorty_pid
     * @param anthortyPid 上级编号
     */
    public void setAnthortyPid(Integer anthortyPid) {
        this.anthortyPid = anthortyPid;
    }

    /** 
     * 获取 权限名称 anthorty_info.anthorty_name
     * @return 权限名称
     */
    public String getAnthortyName() {
        return anthortyName;
    }

    /** 
     * 设置 权限名称 anthorty_info.anthorty_name
     * @param anthortyName 权限名称
     */
    public void setAnthortyName(String anthortyName) {
        this.anthortyName = anthortyName == null ? null : anthortyName.trim();
    }

    /** 
     * 获取 权限描述 anthorty_info.anthorty_desc
     * @return 权限描述
     */
    public String getAnthortyDesc() {
        return anthortyDesc;
    }

    /** 
     * 设置 权限描述 anthorty_info.anthorty_desc
     * @param anthortyDesc 权限描述
     */
    public void setAnthortyDesc(String anthortyDesc) {
        this.anthortyDesc = anthortyDesc == null ? null : anthortyDesc.trim();
    }

    /** 
     * 获取 权限url anthorty_info.anthorty_url
     * @return 权限url
     */
    public String getAnthortyUrl() {
        return anthortyUrl;
    }

    /** 
     * 设置 权限url anthorty_info.anthorty_url
     * @param anthortyUrl 权限url
     */
    public void setAnthortyUrl(String anthortyUrl) {
        this.anthortyUrl = anthortyUrl == null ? null : anthortyUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", anthortyId=").append(anthortyId);
        sb.append(", anthortyPid=").append(anthortyPid);
        sb.append(", anthortyName=").append(anthortyName);
        sb.append(", anthortyDesc=").append(anthortyDesc);
        sb.append(", anthortyUrl=").append(anthortyUrl);
        sb.append("]");
        return sb.toString();
    }
}