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

    /**
     * 获取指定社团的活动列表
     * @return
     */
    List<Activity> selectList (String activityClubId);
    /**
     * 获取所有活动信息列表
     * @return
     */
    List<Activity> selectLists ();


    /**
     * 查询某个活动信息
     * @param uuId
     * @return
     */
    List<Activity> selectInfo (String uuId);

    /**
     * 查询某个活动
     * @param uuId
     * @return
     */
    int selectActivityById(String uuId);

    int updateActivityById (Activity activity);
}