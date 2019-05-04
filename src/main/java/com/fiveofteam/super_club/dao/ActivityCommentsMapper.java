package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ActivityComments;

public interface ActivityCommentsMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ActivityComments record);

    int insertSelective(ActivityComments record);

    ActivityComments selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ActivityComments record);

    int updateByPrimaryKey(ActivityComments record);
}