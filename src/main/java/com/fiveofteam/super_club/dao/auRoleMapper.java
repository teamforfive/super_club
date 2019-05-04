package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.auRole;

public interface auRoleMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(auRole record);

    int insertSelective(auRole record);

    auRole selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(auRole record);

    int updateByPrimaryKey(auRole record);
}