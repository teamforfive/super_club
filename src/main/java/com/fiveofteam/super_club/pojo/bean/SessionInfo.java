package com.fiveofteam.super_club.pojo.bean;

import com.fiveofteam.super_club.pojo.Role;

import java.io.Serializable;
import java.util.List;

public class SessionInfo implements Serializable {
    private static final long serialVersionUID = 123L;
    private String userId;//用户ID
    private String telphone;
    private String loginName;// 登录用户名
    private String ip;
    private String number;//登录账号
    private String clubId;//社团ID
    private List<Role> roleMenuList;//用户权限

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public List<Role> getRoleMenuList() {
        return roleMenuList;
    }

    public void setRoleMenuList(List<Role> roleMenuList) {
        this.roleMenuList = roleMenuList;
    }
}
