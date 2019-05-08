package com.fiveofteam.super_club.pojo;

import java.util.Date;

public class Clubs {

    private String uuId;

    private String clubsName;

    private Integer parentId;

    private Integer childId;

    private String clubCode;

    private String clubProfile;

    private String clubLocation;

    private Boolean clubStatus;

    private String clubTel;

    private String clubLogo;

    private String clubCreateId;

    private Date createTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getClubsName() {
        return clubsName;
    }

    public void setClubsName(String clubsName) {
        this.clubsName = clubsName == null ? null : clubsName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getClubCode() {
        return clubCode;
    }

    public void setClubCode(String clubCode) {
        this.clubCode = clubCode == null ? null : clubCode.trim();
    }

    public String getClubProfile() {
        return clubProfile;
    }

    public void setClubProfile(String clubProfile) {
        this.clubProfile = clubProfile == null ? null : clubProfile.trim();
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation == null ? null : clubLocation.trim();
    }

    public Boolean getClubStatus() {
        return clubStatus;
    }

    public void setClubStatus(Boolean clubStatus) {
        this.clubStatus = clubStatus;
    }

    public String getClubTel() {
        return clubTel;
    }

    public void setClubTel(String clubTel) {
        this.clubTel = clubTel == null ? null : clubTel.trim();
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo == null ? null : clubLogo.trim();
    }

    public String getClubCreateId() {
        return clubCreateId;
    }

    public void setClubCreateId(String clubCreateId) {
        this.clubCreateId = clubCreateId == null ? null : clubCreateId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}