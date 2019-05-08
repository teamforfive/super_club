package com.fiveofteam.super_club.service.impl;


import com.fiveofteam.super_club.dao.ClubsMapper;
import com.fiveofteam.super_club.dao.LevelGroupMapper;
import com.fiveofteam.super_club.pojo.Clubs;
import com.fiveofteam.super_club.pojo.LevelGroup;
import com.fiveofteam.super_club.service.ClubsService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClubsServiceImpl implements ClubsService {
    @Autowired
    private ClubsMapper clubsMapper;
    @Autowired
    private LevelGroupMapper levelGroupMapper;
    JsonResult jsonResult = new JsonResult();

    @Override
    public JsonResult clubList() {
            try{
                Map map = new HashMap();
                List clubs = clubsMapper.selectAllClub();
                map.put("data",clubs);
                jsonResult.setItem(map);
                jsonResult.setStatus("200");
                jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName());
            }catch (Exception e){
                jsonResult.setStatus("400");
                jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName());
            }
        return jsonResult;
    }

    @Override
    public JsonResult clubInfo(String uuId) {
        try {
            Map map = new HashMap();
            Clubs clubs = clubsMapper.selectByPrimaryKey(uuId);
            map.put("data",clubs);
            jsonResult.setItem(map);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName());
        }catch (Exception e ){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName());
        }
        return jsonResult;
    }

    @Override
    public JsonResult addClub(Clubs clubs, LevelGroup levelGroup) {
        try{
            clubsMapper.insert(clubs);
            //添加LevelGroup表记录
            levelGroupMapper.insert(levelGroup);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.AddOk.getDisplayName()+ ",创建社团成功！");
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ "，创建社团失败！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult updateClub(Clubs clubs,LevelGroup levelGroup) {
        try{
            clubsMapper.updateClubInfo(clubs);
            //更新LevelGroup表记录
            levelGroupMapper.updateLevelByClubId(levelGroup);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.UpdateOk.getDisplayName()+ ",更新社团成功！");

        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName()+ "，更新社团失败！");
        }
        return jsonResult;
    }

    @Override
    public List<Clubs> selectClubLogo(String uuId) {
        List clubLogo = new ArrayList();
        try{
            clubLogo = clubsMapper.selectClubLogoByPrimaryKey(uuId);
        }catch (Exception e){
//            jsonResult.setStatus("400");
//            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName()+ ",查询社团LOGO错误！");
        }
        return clubLogo;
    }

    @Override
    public List selectClubName(String clubsName) {
        List clubName = new ArrayList();

        try {
            clubName = clubsMapper.selectClubNameByName(clubsName);
        }catch (Exception e){
//            jsonResult.setStatus("400");
//            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName()+ ",查询社团名称错误！");
            System.out.println(e);
        }
        return clubName;
    }


}
