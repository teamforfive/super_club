package com.fiveofteam.super_club.pojo;

import java.util.Date;

public class CategoryGroup {
    private String uuId;

    private String cgClubid;

    private String cgCategerid;

    private Date updateTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getCgClubid() {
        return cgClubid;
    }

    public void setCgClubid(String cgClubid) {
        this.cgClubid = cgClubid == null ? null : cgClubid.trim();
    }

    public String getCgCategerid() {
        return cgCategerid;
    }

    public void setCgCategerid(String cgCategerid) {
        this.cgCategerid = cgCategerid == null ? null : cgCategerid.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}