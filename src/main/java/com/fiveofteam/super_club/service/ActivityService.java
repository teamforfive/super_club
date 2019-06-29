package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.transaction.annotation.Transactional;

public interface ActivityService {


    /**
     * 创建活动页面
     * @param activity
     * @param organizerName
     * @return JsonResult
     */
    @Transactional
    JsonResult insertActivity(Activity activity,String organizerName,String activityCateId);


    @Transactional
    JsonResult updateActivity(Activity activity,String organizerName,String activityCateId);

    /**
     * 获取指定社团的活动列表
     * @param activityClubId
     * @return
     */
    @Transactional
    JsonResult selectList(String activityClubId);

    /**
     * 获取所有活动信息列表
     * @return
     */
    @Transactional
    JsonResult selectLists();

    /**
     * 查询某个活动信息
     * @param uuId
     * @return
     */
    JsonResult selectInfo(String uuId);
}
