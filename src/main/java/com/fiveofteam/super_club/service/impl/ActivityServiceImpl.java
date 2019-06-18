package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.ActivityMapper;
import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.service.ActivityService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    private JsonResult jsonResult;

    @Override
    public JsonResult addActivity(Activity activity) {
        jsonResult = new JsonResult();
        try{
            //设置社团UUID
            activity.setUuId(CommonStringTool.UUID());
            //设置活动类型
            Byte aType = 1;
            activity.setActivityType(aType);
            //设置活动状态
            activity.setActivityStatus(true);

            //待完成---------------------------------------------------
            //插入activity表记录
            activityMapper.insert(activity);
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，系统错误!");
        }
        return jsonResult;
    }

    @Override
    public JsonResult getActivityList() {
        jsonResult = new JsonResult();
        try{

        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，系统错误!");
        }
        return jsonResult;
    }
}
