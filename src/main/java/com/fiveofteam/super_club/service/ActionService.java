package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.Action;
import com.fiveofteam.super_club.tools.JsonResult;

import java.util.List;

public interface ActionService {
    /**
     * 向数据库插入权限列表
     */
    JsonResult insertActionList(List<Action> list);
    /**
     * */
    /**
     * 为游客添加权限
     */
    JsonResult addActionForCustomer();

    /**
     * 更改权限
     */
    JsonResult updateAction(Action action);
    /**
     * 获取权限列表
     * */
    List<Action> getActionList(String actionList);

}
