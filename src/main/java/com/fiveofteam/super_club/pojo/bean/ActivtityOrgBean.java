package com.fiveofteam.super_club.pojo.bean;

import com.fiveofteam.super_club.pojo.Activity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动组织信息和活动信息
 */
public class ActivtityOrgBean extends Activity implements Serializable {
    private String activityId;//活动id

    private String activityClubId;//社团id

    private String activityTitle;//活动标题

    private Date activityStartTime;//活动开始时间

    private Date activityEndTime;//活动结束时间

    private String activityPlace;//活动地点

    private String activityContent;//活动内容

    private Byte activityType;//活动内容

    private Boolean activityStatus;//活动状态

    private Date updateTime;//活动发布时间

    private Date createTime;//活动创建时间
    /**
     *活动照片
     */
    private String apId;//活动照片id

    private String apName;//活动照片名字

    private String apUrl;//活动照片地址

    private Byte apType;//活动照片类型

    private Integer apSort;//活动照片序号

    private Boolean apStatus;//活动照片状态
    /**
     * 活动组织者
     */
    private String orgId;//活动组织者id

    private String organizerName;//活动组织名字


    public String getActivityClubId() {
        return activityClubId;
    }

    public void setActivityClubId(String activityClubId) {
        this.activityClubId = activityClubId == null ? null : activityClubId.trim();
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle == null ? null : activityTitle.trim();
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
        this.activityPlace = activityPlace == null ? null : activityPlace.trim();
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent == null ? null : activityContent.trim();
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

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getApId() {
        return apId;
    }

    public void setApId(String apId) {
        this.apId = apId;
    }

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName;
    }

    public String getApUrl() {
        return apUrl;
    }

    public void setApUrl(String apUrl) {
        this.apUrl = apUrl;
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

    public Boolean getApStatus() {
        return apStatus;
    }

    public void setApStatus(Boolean apStatus) {
        this.apStatus = apStatus;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
}
