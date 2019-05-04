package com.fiveofteam.super_club.pojo;

import java.util.Date;

public class ActivityPhotos {
    private String uuId;

    private String apName;

    private String apUrl;

    private Byte apType;

    private Integer apSort;

    private String activityId;

    private Boolean apStatus;

    private Date createTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName == null ? null : apName.trim();
    }

    public String getApUrl() {
        return apUrl;
    }

    public void setApUrl(String apUrl) {
        this.apUrl = apUrl == null ? null : apUrl.trim();
    }

    public Byte getApType() {
        return apType;
    }

    public void setApType(Byte apType) {
        this.apType = apType;
    }

    public Integer getApSort() {
        return apSort;
    }

    public void setApSort(Integer apSort) {
        this.apSort = apSort;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public Boolean getApStatus() {
        return apStatus;
    }

    public void setApStatus(Boolean apStatus) {
        this.apStatus = apStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}