package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.ClubLevelMapper;
import com.fiveofteam.super_club.dao.LevelGroupMapper;
import com.fiveofteam.super_club.pojo.ClubLevel;
import com.fiveofteam.super_club.pojo.LevelGroup;
import com.fiveofteam.super_club.service.ClubLevelService;
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
public class ClubLevelServiceImpl implements ClubLevelService {
    @Autowired
    private ClubLevelMapper clubLevelMapper;
    JsonResult jsonResult;

    @Override
    public JsonResult addLevel(ClubLevel clubLevel) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        int clNameNum = 0 ;
        try{
            //查询社团级别是否存在
            clNameNum = clubLevelMapper.selectClubLevelByName(clubLevel.getClName());
            if (clNameNum > 0 ){
                jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，社团级别名称已存在！");
                return jsonResult;
            }
            //设置UUID
            clubLevel.setUuId(CommonStringTool.UUID());
            //设置创建时间-----------------------------------------------------------------
            clubLevel.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            //插入clubLevel表记录
            clubLevelMapper.insert(clubLevel);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.AddOk.getDisplayName()+",创建社团级别成功！");
        }catch (Exception e ){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+",创建社团级别失败！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult getLevelList() {
        jsonResult = new JsonResult();
        try {
            Map map = new HashMap();
            //查询LevelLevel表记录
            List levelList = clubLevelMapper.selectClubLevelList();
            //将返回数据传入Map集合
            map.put("data",levelList);
            //返回结果
            jsonResult.setItem(map);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，查询社团级别列表成功！");
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，查询社团级别列表失败！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult updateLevel(ClubLevel clubLevel) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        int clubLevelNum  = 0 ;
        try {
            //查询级别名称是否存在
            clubLevelNum = clubLevelMapper.selectClubLevelByNameAndId(clubLevel);
            if (clubLevelNum > 0 ){
                jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团级别名称已存在！");
                return  jsonResult;
            }
            //设置更新时间------------------------------------------------------
            clubLevel.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            //更新ClubLevel表记录
            clubLevelMapper.updateByPrimaryKey(clubLevel);
            //更新clubLevel表记录
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.UpdateOk.getDisplayName() + "，更新社团级别成功！");
        }catch (Exception e ){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，更新社团级别失败！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult deleteLevel(ClubLevel clubLevel) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        int clubLevelNum = 0;
        try {
            //查询指定社团级别是否存在
            clubLevelNum = clubLevelMapper.selectClubLevelById(clubLevel.getUuId());
            if (clubLevelNum < 1){
                jsonResult.setMsg(FallBackMsg.DeleteFail.getDisplayName() + "，社团级别不存在！");
                return jsonResult;
            }
            //删除ClubLevel表指定记录
            clubLevelMapper.deleteClubLevelById(clubLevel.getUuId());
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.DeleteOk.getDisplayName() + "，删除社团级别成功！");
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.DeleteFail.getDisplayName() + "，删除社团级别失败！");
        }
        return jsonResult;
    }
}
