package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}