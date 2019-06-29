package com.fiveofteam.super_club.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiveofteam.super_club.pojo.Action;

import java.util.List;

public interface ActionMapper extends BaseMapper<Action> {
    int deleteByPrimaryKey(String uuId);

    int insert(Action record);

    /**
     * 插入权限列表
     */
    int insertActionList(List<Action> actionList);

    int insertSelective(Action record);

    Action selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Action record);

    /**
     * 更新权限信息
     */
    int updateAction(Action action);

    int updateByPrimaryKey(Action record);
}