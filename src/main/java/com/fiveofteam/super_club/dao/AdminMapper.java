package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}