package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Invitation;

import java.util.List;

public interface InvitationMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Invitation record);

    int insertSelective(Invitation record);

    List<Invitation> getInvitations(String authorId);

    Invitation selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Invitation record);

    int updateByPrimaryKey(Invitation record);
}