package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.CategoryGroup;

public interface CategoryGroupMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(CategoryGroup record);

    int insertSelective(CategoryGroup record);

    CategoryGroup selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(CategoryGroup record);

    int updateByPrimaryKey(CategoryGroup record);
}