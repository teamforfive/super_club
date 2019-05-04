package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ActivityPhotos;

public interface ActivityPhotosMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ActivityPhotos record);

    int insertSelective(ActivityPhotos record);

    ActivityPhotos selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ActivityPhotos record);

    int updateByPrimaryKey(ActivityPhotos record);
}