package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.transaction.annotation.Transactional;

public interface ActivityService {


    /**
     * 添加活动页面
     * @param activity
     * @param organizerName
     * @return JsonResult
     */
    @Transactional
    JsonResult insertActivity(Activity activity,String organizerName);

    /**
     * 获取指定社团的活动列表
     * @param activityClubId
     * @return
     */
    @Transactional
    JsonResult selectList(String activityClubId);
}
