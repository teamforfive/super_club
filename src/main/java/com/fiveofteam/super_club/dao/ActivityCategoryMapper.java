package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ActivityCateGroup;
import com.fiveofteam.super_club.pojo.ActivityCategory;
import com.fiveofteam.super_club.tools.JsonResult;

import java.util.List;

public interface ActivityCategoryMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ActivityCategory record);

    int insertSelective(ActivityCategory record);

    ActivityCategory selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ActivityCategory record);

    int updateByPrimaryKey(ActivityCategory record);

    List<ActivityCategory> selectAllCategory();


    /**
     * 查询指定活动类型
     * @param name
     * @return
     */
    int selectCategoryByName(String name);
}