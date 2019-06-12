package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.ClubLevel;
import com.fiveofteam.super_club.service.ClubLevelService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/clubLevel")
public class ClubLevelController {

    @Autowired
    private ClubLevelService clubLevelService;
    JsonResult jsonResult = new JsonResult();

    @CrossOrigin//允许跨域，用于前端测试
    @RequestMapping(value = "/addClubLevel",method = RequestMethod.POST)
    public JsonResult addClubLevel(ClubLevel clubLevel){
        jsonResult.setItem(null);
        jsonResult.setStatus("400");
        if (clubLevel.getClName().isEmpty() || clubLevel.getClName() == "" || clubLevel.getClName() == null){
           jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() +  "，社团级别不能为空！");
        }
        if (clubLevel.getClName().length() > 10){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团级别要求10字以内！");
        }
        try {
            //设置UUID
            clubLevel.setUuId(CommonStringTool.UUID());
            //设置创建时间
            clubLevel.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            jsonResult =clubLevelService.addClubLevel(clubLevel);
        }catch (Exception e ){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }

    @CrossOrigin//允许跨域，用于前端测试
    @RequestMapping(value = "/clubLevelList",method = RequestMethod.GET)
    public JsonResult clubLevelList(){
        jsonResult.setItem(null);
        jsonResult.setStatus("400");
        try {
            jsonResult = clubLevelService.clubLevelList();
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + ", 系统错误！");
        }
        return jsonResult;
    }
}
