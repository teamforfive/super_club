package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.service.ActivityService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;
    private JsonResult jsonResult;

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public JsonResult addArticle(Activity activity) {
        jsonResult.setStatus("400");
        jsonResult.setItem(null);

        try {
            //设置UUID
            activity.setUuId(CommonStringTool.UUID());
            //设置活动类型
            Byte aType = 1;
            activity.setActivityType(aType);
            //设置活动状态
            activity.setActivityStatus(true);
            //设置活动更新时间
            activity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            //设置活动上传时间
            activity.setCreateTime(new Timestamp(System.currentTimeMillis()));
            activityService.addArticle(activity);

        } catch (Exception e) {
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }

    /**
     * 获取活动列表
     */
    @PostMapping(value = "/getActivityList")
    public JsonResult getActivityList(String clubId) {
        try {

        } catch (Exception e) {
        }

        return jsonResult;
    }

    /**
     * 获取某个活动
     */
    public JsonResult getActivty() {

        return jsonResult;
    }
}
