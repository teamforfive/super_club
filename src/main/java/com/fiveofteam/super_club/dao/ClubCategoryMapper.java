package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ClubCategory;

public interface ClubCategoryMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ClubCategory record);

    int insertSelective(ClubCategory record);

    ClubCategory selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ClubCategory record);

    int updateByPrimaryKey(ClubCategory record);
}