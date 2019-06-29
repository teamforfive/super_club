package com.fiveofteam.super_club.pojo.bean;

import com.fiveofteam.super_club.pojo.LevelGroup;

import java.util.Date;
import java.util.List;

public class ClubsBean {

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

    private String lgClubid;

    private String lgLevelid;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getClubsName() {
        return clubsName;
    }

    public void setClubsName(String clubsName) {
        this.clubsName = clubsName;
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
        this.clubCode = clubCode;
    }

    public String getClubProfile() {
        return clubProfile;
    }

    public void setClubProfile(String clubProfile) {
        this.clubProfile = clubProfile;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
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
        this.clubTel = clubTel;
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }

    public String getClubCreateId() {
        return clubCreateId;
    }

    public void setClubCreateId(String clubCreateId) {
        this.clubCreateId = clubCreateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLgClubid() {
        return lgClubid;
    }

    public void setLgClubid(String lgClubid) {
        this.lgClubid = lgClubid;
    }

    public String getLgLevelid() {
        return lgLevelid;
    }

    public void setLgLevelid(String lgLevelid) {
        this.lgLevelid = lgLevelid;
    }
}
