package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Activity;

public interface ActivityMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}