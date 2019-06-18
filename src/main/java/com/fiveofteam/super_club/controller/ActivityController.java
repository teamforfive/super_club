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

    /**
     * 创建活动
     * @param activity
     * @return
     */
    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    public JsonResult insertActivity(Activity activity) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == activity){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，传递数据不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityClubId() || "".equals(activity.getActivityClubId().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，社团ID不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityTitle() || "".equals(activity.getActivityTitle().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动标题名不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityStartTime() || "".equals(activity.getActivityStartTime())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动开始时间不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityEndTime() || "".equals(activity.getActivityEndTime())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动结束时间不能为空！");
            return jsonResult;
        }
        if (activity.getActivityStartTime().after(activity.getActivityEndTime())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动时间格式不正确！");
            return jsonResult;
        }
        if (null == activity.getActivityPlace() || "".equals(activity.getActivityPlace().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动举办地点不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityContent() || "".equals(activity.getActivityContent().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动内容不能为空！");
            return jsonResult;
        }
        if (null == activity.getActivityType() || activity.getActivityType() > 0){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动类型不能为空！");
            return jsonResult;
        }
        try {
            activityService.addActivity(activity);
        } catch (Exception e) {
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }

    /**
     * 获取活动列表
     */
    @PostMapping(value = "/getActivityList")
    public JsonResult getActivityList(String clubId) {
        if (clubId == null || "".equals(clubId)) {

        }

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
