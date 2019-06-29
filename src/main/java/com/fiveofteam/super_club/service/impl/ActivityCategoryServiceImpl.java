package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.ActivityCategoryMapper;
import com.fiveofteam.super_club.pojo.ActivityCategory;
import com.fiveofteam.super_club.service.ActivityCategoryService;
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
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    @Autowired
    private ActivityCategoryMapper activityCategoryMapper ;

    JsonResult jsonResult ;

    @Override
    public JsonResult selectActivityCategory() {
        jsonResult = new JsonResult();
        try{
            Map map = new HashMap();
            List list =activityCategoryMapper.selectAllCategory();
            map.put("data",list);
            jsonResult.setItem(map);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，查询活动类型成功！");
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，查询活动类型失败！");
        }
        return jsonResult;
    }


    @Override
    public JsonResult insertActivityCategory(ActivityCategory activityCategory) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        int categoryNum = 0;
        try{
            //查询活动类型是否存在
            categoryNum = activityCategoryMapper.selectCategoryByName(activityCategory.getAcName());
            if ( categoryNum > 0 ){
                jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动类型已存在！");
                return jsonResult;
            }
            //设置UUID
            activityCategory.setUuId(CommonStringTool.UUID());
            //设置更新时间
            activityCategory.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            //插入activityCategory表的记录
            activityCategoryMapper.insert(activityCategory);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.AddOk.getDisplayName() + "，创建活动类型成功！");
        }catch (Exception e){
            jsonResult.setStatus("400");
            System.out.println("Num="+ categoryNum);
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，创建活动类型失败！");
        }
        return jsonResult;
    }

}
