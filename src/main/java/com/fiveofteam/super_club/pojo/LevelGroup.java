package com.fiveofteam.super_club.pojo;

import java.util.Date;

public class LevelGroup {
    private String uuId;

    private String lgClubid;

    private String lgLevelid;

    private Date updateTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getLgClubid() {
        return lgClubid;
    }

    public void setLgClubid(String lgClubid) {
        this.lgClubid = lgClubid == null ? null : lgClubid.trim();
    }

    public String getLgLevelid() {
        return lgLevelid;
    }

    public void setLgLevelid(String lgLevelid) {
        this.lgLevelid = lgLevelid == null ? null : lgLevelid.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}