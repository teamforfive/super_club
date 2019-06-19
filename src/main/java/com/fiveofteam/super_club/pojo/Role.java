package com.fiveofteam.super_club.pojo;

import java.util.Date;
import java.util.List;

public class Role {
    private String uuId;

    private String roleName;

    private String roleComment;

    private Date updateTime;

    private List<AuRole> auRoleList;

    private List<RoleAction> actionList;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment == null ? null : roleComment.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<AuRole> getAuRoleList() {
        return auRoleList;
    }

    public void setAuRoleList(List<AuRole> auRoleList) {
        this.auRoleList = auRoleList;
    }

    public List<RoleAction> getActionList() {
        return actionList;
    }

    public void setActionList(List<RoleAction> actionList) {
        this.actionList = actionList;
    }
}