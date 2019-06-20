package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ActivityOrganizer;

public interface ActivityOrganizerMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ActivityOrganizer record);

    int insertSelective(ActivityOrganizer record);

    ActivityOrganizer selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ActivityOrganizer record);

    int updateByPrimaryKey(ActivityOrganizer record);

    /**
     * 查询活动组织者信息
     * @param activityId
     * @return
     */
    ActivityOrganizer selectByActivityId(String activityId);
}