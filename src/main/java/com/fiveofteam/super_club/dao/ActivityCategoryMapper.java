package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ActivityCategory;

public interface ActivityCategoryMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ActivityCategory record);

    int insertSelective(ActivityCategory record);

    ActivityCategory selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ActivityCategory record);

    int updateByPrimaryKey(ActivityCategory record);
}