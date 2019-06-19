package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.InvitationMapper;
import com.fiveofteam.super_club.pojo.Invitation;
import com.fiveofteam.super_club.service.InvitationService;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    InvitationMapper invitationMapper;
    JsonResult jsonResult;

    /**
     * 获取帖子
     * @param authorId
     */
    @Override
    @Transactional
    public JsonResult getInvitations(String authorId) {
        jsonResult=new JsonResult();
        List<Invitation> list = invitationMapper.getInvitations(authorId);
        Map<String,Object> map=new HashMap<>();
        map.put("item",list);
        jsonResult.setItem(map);
        jsonResult.setMsg("获取成功！");
        jsonResult.setStatus("200");
        return jsonResult;
    }

    @Override
    @Transactional
    public JsonResult addInvitation(Invitation invitation) {
        return null;
    }
}
