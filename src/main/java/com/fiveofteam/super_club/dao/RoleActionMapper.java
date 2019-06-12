package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Action;
import com.fiveofteam.super_club.pojo.RoleAction;

import java.util.List;

public interface RoleActionMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(RoleAction record);

    int insertSelective(RoleAction record);

    RoleAction selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(RoleAction record);

    /**
     * 获取权限列表
     * */
    List<Action> getActionList(String roleList);

    int updateByPrimaryKey(RoleAction record);
}