package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.RoleAction;

public interface RoleActionMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(RoleAction record);

    int insertSelective(RoleAction record);

    RoleAction selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(RoleAction record);

    int updateByPrimaryKey(RoleAction record);
}