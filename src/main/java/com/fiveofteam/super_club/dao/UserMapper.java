package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}