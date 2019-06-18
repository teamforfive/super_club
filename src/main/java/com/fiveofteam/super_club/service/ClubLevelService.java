package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.ClubLevel;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.transaction.annotation.Transactional;

public interface ClubLevelService {

    /**
     * 创建社团级别
     * @param clubLevel
     * @return JsonResult
     */
    @Transactional
    JsonResult addLevel(ClubLevel clubLevel);

    /**
     * 查询社团级别列表
     * @return JsonResult
     */

    JsonResult getLevelList();

    /**
     * 更新社团级别
     * @param clubLevel
     * @return JsonResult
     */
    @Transactional
    JsonResult updateLevel(ClubLevel clubLevel);

    /**
     * 删除社团级别
     * @param clubLevel
     * @return JsonResult
     */
    @Transactional
    JsonResult deleteLevel(ClubLevel clubLevel);
}
