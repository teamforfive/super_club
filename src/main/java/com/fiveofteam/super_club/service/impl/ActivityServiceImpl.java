package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.ActivityMapper;
import com.fiveofteam.super_club.dao.ActivityOrganizerMapper;
import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.pojo.ActivityOrganizer;
import com.fiveofteam.super_club.service.ActivityService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityOrganizerMapper activityOrganizerMapper;
    private JsonResult jsonResult;

    @Override
    public JsonResult insertActivity(Activity activity,String organizerName) {
        jsonResult = new JsonResult();
        String uuId = CommonStringTool.UUID();
        try{
            //设置活动UUID
            activity.setUuId(uuId);
            //设置活动类型,增加表，用关系映射表 分表
            Byte aType = 1;
            activity.setActivityType(aType);
            //设置活动状态
            activity.setActivityStatus(true);
            //设置StartTime
//            activity.setActivityStartTime(new Timestamp(activity.getActivityStartTime().getTime()));
            //设置EndTime
//            activity.setActivityEndTime(new Timestamp(activity.getActivityStartTime().getTime()));
            //设置更新时间
            activity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            //设置创建时间
            activity.setCreateTime(new Timestamp(System.currentTimeMillis()));
            //插入activity表记录
            activityMapper.insert(activity);

            //实例化ActivityOrganizer对象
            ActivityOrganizer activityOrganizer = new ActivityOrganizer();
            //设置ActivityOrganizer表UUID
            activityOrganizer.setUuId(CommonStringTool.UUID());
            //设置活动组织者
            activityOrganizer.setOrganizerName(organizerName);
            //设置活动ID
            activityOrganizer.setActivityId(uuId);
            //插入ActivityOrganizer表的记录
            activityOrganizerMapper.insert(activityOrganizer);


            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.AddOk.getDisplayName() + "，创建活动成功!");
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，创建活动失败!");
        }
        return jsonResult;
    }

    /**
     * 获取指定社团的活动列表
     * @param activityClubId
     * @return
     */
    @Override
    public JsonResult selectList(String activityClubId) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        try{
            Map map = new HashMap();
            //查询活动组织者是否存在
            ActivityOrganizer activityOrganizer = activityOrganizerMapper.selectByActivityId(activityClubId);
            if (null == activityOrganizer || "".equals(activityOrganizer.getOrganizerName().trim())){
                jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，活动组织者不存在！");
                return jsonResult;
            }
            //查询活动内容
            List activityList = activityMapper.selectList(activityClubId);
            //添加组织者名称到List集合
            activityList.add(activityOrganizer.getOrganizerName());
            map.put("data",activityList);

            jsonResult.setItem(map);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，查询活动列表成功！");
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，查询活动列表失败！");
        }
        return jsonResult;
    }

    /**
     *获取活动列表
     */
/*    @Override
    public JsonResult getActivityList() {
        jsonResult = new JsonResult();
        try{

        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，系统错误!");
        }
        return jsonResult;
    }*/


}
