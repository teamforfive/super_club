package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ClubLevel;

import java.util.List;

public interface ClubLevelMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ClubLevel record);

    int insertSelective(ClubLevel record);

    ClubLevel selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ClubLevel record);

    int updateByPrimaryKey(ClubLevel record);

    List<ClubLevel> selectClubLevelList();
}