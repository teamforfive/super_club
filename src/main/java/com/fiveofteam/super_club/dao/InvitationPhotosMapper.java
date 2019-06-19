package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.InvitationPhotos;

public interface InvitationPhotosMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(InvitationPhotos record);

    int insertSelective(InvitationPhotos record);

    InvitationPhotos selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(InvitationPhotos record);

    int updateByPrimaryKey(InvitationPhotos record);
}