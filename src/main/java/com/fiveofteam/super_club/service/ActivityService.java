package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.tools.JsonResult;

public interface ActivityService {

    /**
     * 添加活动页面
     * @return
     */
    JsonResult addArticle(Activity activity);
}
