package com.fiveofteam.super_club.pojo;

import java.util.Date;

public class ActivityCateGroup {
    private String uuId;

    private String acActivityid;

    private String acCategoryid;

    private Date updateTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getAcActivityid() {
        return acActivityid;
    }

    public void setAcActivityid(String acActivityid) {
        this.acActivityid = acActivityid == null ? null : acActivityid.trim();
    }

    public String getAcCategoryid() {
        return acCategoryid;
    }

    public void setAcCategoryid(String acCategoryid) {
        this.acCategoryid = acCategoryid == null ? null : acCategoryid.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}