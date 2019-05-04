package com.fiveofteam.super_club.pojo;

import java.util.Date;

public class ClubPhotos {
    private String uuId;

    private String cpName;

    private String clubId;

    private String cpUrl;

    private String cpType;

    private Integer cpSort;

    private Boolean cpStatus;

    private Date cpCreateTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName == null ? null : cpName.trim();
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId == null ? null : clubId.trim();
    }

    public String getCpUrl() {
        return cpUrl;
    }

    public void setCpUrl(String cpUrl) {
        this.cpUrl = cpUrl == null ? null : cpUrl.trim();
    }

    public String getCpType() {
        return cpType;
    }

    public void setCpType(String cpType) {
        this.cpType = cpType == null ? null : cpType.trim();
    }

    public Integer getCpSort() {
        return cpSort;
    }

    public void setCpSort(Integer cpSort) {
        this.cpSort = cpSort;
    }

    public Boolean getCpStatus() {
        return cpStatus;
    }

    public void setCpStatus(Boolean cpStatus) {
        this.cpStatus = cpStatus;
    }

    public Date getCpCreateTime() {
        return cpCreateTime;
    }

    public void setCpCreateTime(Date cpCreateTime) {
        this.cpCreateTime = cpCreateTime;
    }
}