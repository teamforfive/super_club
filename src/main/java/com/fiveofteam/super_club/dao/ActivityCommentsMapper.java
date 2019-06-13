package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ActivityComments;

import java.util.List;

public interface ActivityCommentsMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ActivityComments record);

    int insertSelective(ActivityComments record);

    ActivityComments selectByPrimaryKey(String uuId);

    /**
     *获取评论
     */
    List<ActivityComments> getCommentsList(String activityId);

    int updateByPrimaryKeySelective(ActivityComments record);

    int updateByPrimaryKey(ActivityComments record);
}