package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.dao.ClubsMapper;
import com.fiveofteam.super_club.pojo.ClubLevel;
import com.fiveofteam.super_club.service.ClubLevelService;
import com.fiveofteam.super_club.service.ClubsService;
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
    JsonResult jsonResult;

    /**
     * 创建社团级别
     * @param clubLevel
     * @return
     */
    @CrossOrigin//允许跨域，用于前端测试
    @RequestMapping(value = "/addLevel",method = RequestMethod.POST)
    public JsonResult insertClubLevel(ClubLevel clubLevel){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == clubLevel){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，传递数据不能为空！");
            return jsonResult;
        }
        if (clubLevel.getClName().isEmpty() || clubLevel.getClName() == "" || clubLevel.getClName() == null){
           jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() +  "，社团级别不能为空！");
        }
        if (clubLevel.getClName().length() > 10){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团级别要求10字以内！");
        }
        try {
            jsonResult =clubLevelService.addLevel(clubLevel);
        }catch (Exception e ){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }

    /**
     * 删除社团级别
     * @param clubLevel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteLevel",method = RequestMethod.POST)
    public JsonResult deleteClubLevel(ClubLevel clubLevel){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == clubLevel){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，传递数据不能为空！");
            return jsonResult;
        }
        if (null == clubLevel.getUuId() || "".equals(clubLevel.getUuId().trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团级别ID不能为空！");
            return jsonResult;
        }
        try{
            jsonResult = clubLevelService.deleteLevel(clubLevel);
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.DeleteFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }

    /**
     * 更新社团级别
     * @param clubLevel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/updateLevel",method = RequestMethod.POST)
    public JsonResult updateClubLevel(ClubLevel clubLevel){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == clubLevel){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，传递数据不能为空！");
            return jsonResult;
        }
        if (null == clubLevel.getUuId() || "".equals(clubLevel.getUuId().trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团级别ID不能为空！");
            return jsonResult;
        }
        if (null == clubLevel.getClName() || "".equals(clubLevel.getClName().trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团级别名称不能为空！");
            return jsonResult;
        }
        try {
            jsonResult = clubLevelService.updateLevel(clubLevel);
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，系统错误！");
        }
        return jsonResult;
    }

    /**
     * 查询社团级别列表
     * @return
     */
    @CrossOrigin//允许跨域，用于前端测试
    @RequestMapping(value = "/selectList",method = RequestMethod.GET)
    public JsonResult selectClubLevelList(){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        try {
            jsonResult = clubLevelService.getLevelList();
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + ", 系统错误！");
        }
        return jsonResult;
    }
}
