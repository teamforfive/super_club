package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.ActivityCategory;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spring.web.json.Json;


public interface ActivityCategoryService {

    /**
     * 查询活动类型
     * @return
     */
    JsonResult selectActivityCategory();


    /**
     * 创建活动类型
     * @param activityCategory
     * @return
     */
    @Transactional
    JsonResult insertActivityCategory(ActivityCategory activityCategory);
}
