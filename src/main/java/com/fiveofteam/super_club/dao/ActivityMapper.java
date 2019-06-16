package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.pojo.bean.ActivtityOrgBean;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<ActivtityOrgBean> getActivityList(String id);

    Activity selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}