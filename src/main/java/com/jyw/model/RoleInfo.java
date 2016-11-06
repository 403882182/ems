
package com.jyw.model;

import java.io.Serializable;

/**
 * 角色信息 role_info
 * 2016/11/05 16:28
*/
public class RoleInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 
     * 角色编号
     */
    private Integer roleId;

    /** 
     * 角色名称
     */
    private String roleName;

    /** 
     * 角色描述
     */
    private String roleDesc;

    /** 
     * 状态
     */
    private String roleState;

    /** 
     * 构造查询条件
     */
    public RoleInfo(Integer roleId, String roleName, String roleDesc, String roleState) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleState = roleState;
    }

    /** 
     * 构造查询条件
     */
    public RoleInfo() {
        super();
    }

    /** 
     * 获取 角色编号 role_info.role_id
     * @return 角色编号
     */
    public Integer getRoleId() {
        return roleId;
    }

    /** 
     * 设置 角色编号 role_info.role_id
     * @param roleId 角色编号
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /** 
     * 获取 角色名称 role_info.role_name
     * @return 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /** 
     * 设置 角色名称 role_info.role_name
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /** 
     * 获取 角色描述 role_info.role_desc
     * @return 角色描述
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /** 
     * 设置 角色描述 role_info.role_desc
     * @param roleDesc 角色描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    /** 
     * 获取 状态 role_info.role_state
     * @return 状态
     */
    public String getRoleState() {
        return roleState;
    }

    /** 
     * 设置 状态 role_info.role_state
     * @param roleState 状态
     */
    public void setRoleState(String roleState) {
        this.roleState = roleState == null ? null : roleState.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleDesc=").append(roleDesc);
        sb.append(", roleState=").append(roleState);
        sb.append("]");
        return sb.toString();
    }
}