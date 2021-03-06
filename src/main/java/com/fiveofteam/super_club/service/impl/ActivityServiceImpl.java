package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.*;
import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.pojo.ActivityCateGroup;
import com.fiveofteam.super_club.pojo.ActivityCategory;
import com.fiveofteam.super_club.pojo.ActivityOrganizer;
import com.fiveofteam.super_club.service.ActivityService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityOrganizerMapper activityOrganizerMapper;
    @Autowired
    private ActivityCateGroupMapper activityCateGroupMapper;
    @Autowired
    private ClubsMapper clubsMapper;

    private JsonResult jsonResult;

    @Override
    public JsonResult insertActivity(Activity activity,String organizerName,String activityCateId) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        String uuId = CommonStringTool.UUID();
        int clubsNum = 0;
        try{
            clubsNum = clubsMapper.selectClubsById(activity.getActivityClubId());
            if (clubsNum <0){
                jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，社团不存在！");
                return jsonResult;
            }
            //设置活动UUID
            activity.setUuId(uuId);
            //实例化活动类型关系表对象
            ActivityCateGroup activityCateGroup = new ActivityCateGroup();
            //设置活动类型关系表UUID
            activityCateGroup.setUuId(CommonStringTool.UUID());
            //设置活动ID
            activityCateGroup.setAcActivityid(activity.getUuId());
            //设置活动类型ID
            activityCateGroup.setAcCategoryid(activityCateId);
            //设置更新时间
            activityCateGroup.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            //插入activityCatefory表的记录
            activityCateGroupMapper.insert(activityCateGroup);

            //设置活动状态
            activity.setActivityStatus(true);
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

    @Override
    public JsonResult updateActivity(Activity activity, String organizerName, String activityCateId) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        int clubsNum = 0;
        String uuId = activity.getUuId();
        try {
            clubsNum = activityMapper.selectActivityById(activity.getUuId());
            if (clubsNum <0){
                jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动不存在！");
                return jsonResult;
            }
            //实例化活动类型关系表对象
            ActivityCateGroup activityCateGroup = new ActivityCateGroup();
            //设置活动类型ID
            activityCateGroup.setAcCategoryid(activityCateId);
            //设置更新时间
            activityCateGroup.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            //设置查询活动ID
            activityCateGroup.setAcActivityid(activity.getUuId());
            //更新activityCatefory表的记录
            activityCateGroupMapper.updateCateByActivityId(activityCateGroup);

            //设置活动状态
            activity.setActivityStatus(true);
            //设置更新时间
            activity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            //更新activity表记录
            activityMapper.updateActivityById(activity);

            //实例化ActivityOrganizer对象
            ActivityOrganizer activityOrganizer = new ActivityOrganizer();
            //设置活动组织者
            activityOrganizer.setOrganizerName(organizerName);
            //设置查询活动ID
            activityOrganizer.setActivityId(activity.getUuId());
            //更新ActivityOrganizer表的记录
            activityOrganizerMapper.updateOrganizerNameByActivityId(activityOrganizer);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.UpdateOk.getDisplayName() + "，更新活动成功!");

        }catch (Exception e){
            System.out.println(e);
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，更新活动失败!");
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
            //查询活动内容
            List list = activityMapper.selectList(activityClubId);
            map.put("data",list);
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
     *获取所有活动信息列表
     */
    @Override
    public JsonResult selectLists() {
        jsonResult = new JsonResult();
        try{
            Map map = new HashMap();
            List activitys = activityMapper.selectLists();
            map.put("data",activitys);
            jsonResult.setItem(map);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，查询所有活动信息成功！");
        }catch (Exception e){
            System.out.println(e);
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，查询所有活动信息失败！");
        }
        return jsonResult;
    }


    /**
     *获取活动列表
     */
    @Override
    public JsonResult selectInfo(String uuId) {
        jsonResult = new JsonResult();
        try{
            Map map = new HashMap();
            //查询活动信息
            List activityInfo = activityMapper.selectInfo(uuId);
            map.put("data",activityInfo);
            jsonResult.setItem(map);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，获取活动信息成功！");
        }catch (Exception e){
            System.out.println(e);
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，获取活动信息失败!");
        }
        return jsonResult;
    }


}
