package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.ClubLevelMapper;
import com.fiveofteam.super_club.dao.LevelGroupMapper;
import com.fiveofteam.super_club.pojo.ClubLevel;
import com.fiveofteam.super_club.pojo.LevelGroup;
import com.fiveofteam.super_club.service.ClubLevelService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClubLevelServiceImpl implements ClubLevelService {
    @Autowired
    private ClubLevelMapper clubLevelMapper;


    JsonResult jsonResult = new JsonResult();

    @Override
    public JsonResult addClubLevel(ClubLevel clubLevel) {

        try{
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
    public JsonResult clubLevelList() {

        try {
            Map map = new HashMap();
            List levelList = clubLevelMapper.selectClubLevelList();
            map.put("data",levelList);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，查询社团级别列表成功！");
            jsonResult.setItem(map);
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，查询社团级别列表失败！");
        }
        return jsonResult;
    }
}
