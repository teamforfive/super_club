package com.fiveofteam.super_club.pojo;

import java.util.Date;

public class RoleAction {
    private String uuId;

    private String roleId;

    private String raActionid;

    private Date createTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRaActionid() {
        return raActionid;
    }

    public void setRaActionid(String raActionid) {
        this.raActionid = raActionid == null ? null : raActionid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}