package com.fiveofteam.super_club.pojo.bean;

import java.util.Date;

public class ActivitysBean {

    private String uuId;

    private String activityClubId;

    private String activityTitle;

    private Date activityStartTime;

    private Date activityEndTime;

    private String activityPlace;

    private String activityContent;

    private Byte activityType;

    private Boolean activityStatus;

    private Date updateTime;

    private Date createTime;

    private String organizerName;

    private String acCategoryid;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getActivityClubId() {
        return activityClubId;
    }

    public void setActivityClubId(String activityClubId) {
        this.activityClubId = activityClubId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getActivityPlace() {
        return activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public Byte getActivityType() {
        return activityType;
    }

    public void setActivityType(Byte activityType) {
        this.activityType = activityType;
    }

    public Boolean getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getAcCategoryid() {
        return acCategoryid;
    }

    public void setAcCategoryid(String acCategoryid) {
        this.acCategoryid = acCategoryid;
    }
}
