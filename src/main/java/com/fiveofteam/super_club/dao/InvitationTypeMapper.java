package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.InvitationType;

public interface InvitationTypeMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(InvitationType record);

    int insertSelective(InvitationType record);

    InvitationType selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(InvitationType record);

    int updateByPrimaryKey(InvitationType record);
}