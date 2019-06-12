package com.fiveofteam.super_club.pojo.bean;

import java.io.Serializable;

public class UserBean implements Serializable{
    private static final long serialVersionUID = 5640845062923427414L;
    private String uuId;

    private String userName;//用户名

    private String userPassword;//密码

    private String uerSalt;

    private String userRealName;//用户真实姓名

    private String userTelephone;

    private Integer userQq;

    private Integer userSattus;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUerSalt() {
        return uerSalt;
    }

    public void setUerSalt(String uerSalt) {
        this.uerSalt = uerSalt;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public Integer getUserQq() {
        return userQq;
    }

    public void setUserQq(Integer userQq) {
        this.userQq = userQq;
    }

    public Integer getUserSattus() {
        return userSattus;
    }

    public void setUserSattus(Integer userSattus) {
        this.userSattus = userSattus;
    }

}
