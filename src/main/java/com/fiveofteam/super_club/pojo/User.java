package com.fiveofteam.super_club.pojo;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class User {
    private String uuId;

    private String userName;

    private String userPassword;

    private String uerSalt;

    private String userRealName;

    private Byte userSex;

    private Date birthday;

    private String userTelephone;

    private Integer userQq;

    private String userLogo;

    private Integer userSattus;

    private Date createTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUerSalt() {
        return uerSalt;
    }

    public void setUerSalt(String uerSalt) {
        this.uerSalt = uerSalt == null ? null : uerSalt.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone == null ? null : userTelephone.trim();
    }

    public Integer getUserQq() {
        return userQq;
    }

    public void setUserQq(Integer userQq) {
        this.userQq = userQq;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo == null ? null : userLogo.trim();
    }

    public Integer getUserSattus() {
        return userSattus;
    }

    public void setUserSattus(Integer userSattus) {
        this.userSattus = userSattus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}