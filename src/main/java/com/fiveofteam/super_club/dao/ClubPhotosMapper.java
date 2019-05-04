package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ClubPhotos;

public interface ClubPhotosMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ClubPhotos record);

    int insertSelective(ClubPhotos record);

    ClubPhotos selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ClubPhotos record);

    int updateByPrimaryKey(ClubPhotos record);
}