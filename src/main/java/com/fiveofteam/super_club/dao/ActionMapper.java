package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Action;

public interface ActionMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
}