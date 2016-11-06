
package com.jyw.model;

import java.io.Serializable;

/**
 * 角色权限信息 role_anthority_info
 * 2016/11/05 16:28
*/
public class RoleAnthorityInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 角色权限编号
     */
    private Integer roleAnthorityId;

    /** 
     * 角色编号
     */
    private Integer roleId;

    /** 
     * 权限编号
     */
    private Integer anthortyId;

    /** 
     * 构造查询条件
     */
    public RoleAnthorityInfo(Integer roleAnthorityId, Integer roleId, Integer anthortyId) {
        this.roleAnthorityId = roleAnthorityId;
        this.roleId = roleId;
        this.anthortyId = anthortyId;
    }

    /** 
     * 构造查询条件
     */
    public RoleAnthorityInfo() {
        super();
    }

    /** 
     * 获取 角色权限编号 role_anthority_info.role_anthority_id
     * @return 角色权限编号
     */
    public Integer getRoleAnthorityId() {
        return roleAnthorityId;
    }

    /** 
     * 设置 角色权限编号 role_anthority_info.role_anthority_id
     * @param roleAnthorityId 角色权限编号
     */
    public void setRoleAnthorityId(Integer roleAnthorityId) {
        this.roleAnthorityId = roleAnthorityId;
    }

    /** 
     * 获取 角色编号 role_anthority_info.role_id
     * @return 角色编号
     */
    public Integer getRoleId() {
        return roleId;
    }

    /** 
     * 设置 角色编号 role_anthority_info.role_id
     * @param roleId 角色编号
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /** 
     * 获取 权限编号 role_anthority_info.anthorty_id
     * @return 权限编号
     */
    public Integer getAnthortyId() {
        return anthortyId;
    }

    /** 
     * 设置 权限编号 role_anthority_info.anthorty_id
     * @param anthortyId 权限编号
     */
    public void setAnthortyId(Integer anthortyId) {
        this.anthortyId = anthortyId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", roleAnthorityId=").append(roleAnthorityId);
        sb.append(", roleId=").append(roleId);
        sb.append(", anthortyId=").append(anthortyId);
        sb.append("]");
        return sb.toString();
    }
}