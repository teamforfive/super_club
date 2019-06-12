package com.fiveofteam.super_club.pojo;

import java.util.Date;

public class AuRole {
    private String uuId;

    private String clubId;

    private String roleId;

    private String auId;

    private Boolean auType;

    private String auUserselfName;

    private Date createTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId == null ? null : clubId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getAuId() {
        return auId;
    }

    public void setAuId(String auId) {
        this.auId = auId == null ? null : auId.trim();
    }

    public Boolean getAuType() {
        return auType;
    }

    public void setAuType(Boolean auType) {
        this.auType = auType;
    }

    public String getAuUserselfName() {
        return auUserselfName;
    }

    public void setAuUserselfName(String auUserselfName) {
        this.auUserselfName = auUserselfName == null ? null : auUserselfName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}