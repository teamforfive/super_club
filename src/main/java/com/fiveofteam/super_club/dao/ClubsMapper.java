package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Clubs;

public interface ClubsMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Clubs record);

    int insertSelective(Clubs record);

    Clubs selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Clubs record);

    int updateByPrimaryKey(Clubs record);
}