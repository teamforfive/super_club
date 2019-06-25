package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ActivityCateGroup;

public interface ActivityCateGroupMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ActivityCateGroup record);

    int insertSelective(ActivityCateGroup record);

    ActivityCateGroup selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ActivityCateGroup record);

    int updateByPrimaryKey(ActivityCateGroup record);


    int updateCateByActivityId(ActivityCateGroup activityCateGroup);
}