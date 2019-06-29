package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.dao.ActivityCategoryMapper;
import com.fiveofteam.super_club.pojo.ActivityCategory;
import com.fiveofteam.super_club.service.ActivityCategoryService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/activityCategory")
public class ActivityCategoryController {
    @Autowired
    private ActivityCategoryService activityCategoryService;
    JsonResult jsonResult ;

    @RequestMapping(value = "/selectList",method = RequestMethod.GET)
    public JsonResult selectActivityCategory(){
        jsonResult = new JsonResult();
        try {
            jsonResult = activityCategoryService.selectActivityCategory();
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "系统错误！");
        }
        return jsonResult;
    }

    @RequestMapping(value = "/insertList",method = RequestMethod.POST)
    public JsonResult insertActivityCategory(ActivityCategory activityCategory){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");

        if (null == activityCategory || "".equals(activityCategory.getAcName().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，活动类型不能为空！");
            return jsonResult;
        }
        try{
            jsonResult = activityCategoryService.insertActivityCategory(activityCategory);
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }

}
