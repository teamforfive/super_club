package com.fiveofteam.super_club.pojo;

import java.util.Date;
import java.util.List;

public class Invitation {
    private String uuId;

    private String invitationTitle;

    private String invitationAuthorId;

    private String invitationContent;

    private Integer invitationStatus;

    private Integer invitationAccess;

    private Date updateTime;

    private Date createTime;

    private List<InvitationType> invitationTypeList;//帖子类型

    private List<InvitationPhotos> invitationPhotosList;//帖子照片

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId == null ? null : uuId.trim();
    }

    public String getInvitationTitle() {
        return invitationTitle;
    }

    public void setInvitationTitle(String invitationTitle) {
        this.invitationTitle = invitationTitle == null ? null : invitationTitle.trim();
    }

    public String getInvitationAuthorId() {
        return invitationAuthorId;
    }

    public void setInvitationAuthorId(String invitationAuthorId) {
        this.invitationAuthorId = invitationAuthorId == null ? null : invitationAuthorId.trim();
    }

    public String getInvitationContent() {
        return invitationContent;
    }

    public void setInvitationContent(String invitationContent) {
        this.invitationContent = invitationContent == null ? null : invitationContent.trim();
    }

    public Integer getInvitationStatus() {
        return invitationStatus;
    }

    public void setInvitationStatus(Integer invitationStatus) {
        this.invitationStatus = invitationStatus;
    }

    public Integer getInvitationAccess() {
        return invitationAccess;
    }

    public void setInvitationAccess(Integer invitationAccess) {
        this.invitationAccess = invitationAccess;
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

    public List<InvitationType> getInvitationTypeList() {
        return invitationTypeList;
    }

    public void setInvitationTypeList(List<InvitationType> invitationTypeList) {
        this.invitationTypeList = invitationTypeList;
    }

    public List<InvitationPhotos> getInvitationPhotosList() {
        return invitationPhotosList;
    }

    public void setInvitationPhotosList(List<InvitationPhotos> invitationPhotosList) {
        this.invitationPhotosList = invitationPhotosList;
    }
}