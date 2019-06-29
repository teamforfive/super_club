package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.InvitationMapper;
import com.fiveofteam.super_club.pojo.Invitation;
import com.fiveofteam.super_club.pojo.InvitationPhotos;
import com.fiveofteam.super_club.pojo.InvitationType;
import com.fiveofteam.super_club.service.InvitationService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    /**添加帖子*/
    public JsonResult addInvitation(Invitation invitation) {
        jsonResult=new JsonResult();
        String invitationId= CommonStringTool.UUID();
        invitation.setUuId(invitationId);
        List<InvitationType> list=new ArrayList<>();
        for(InvitationType invitationType:invitation.getInvitationTypeList()){//插入类型 id等
            invitationType.setUuId(CommonStringTool.UUID());
            invitationType.setInvitationId(invitationId);
            list.add(invitationType);
        }
        invitation.setInvitationTypeList(list);
        List<InvitationPhotos> photosList=new ArrayList<>();
        for(InvitationPhotos invitationPhotos:invitation.getInvitationPhotosList()){ //插入照片id等
            invitationPhotos.setUuId(CommonStringTool.UUID());
            invitationPhotos.setInvitationId(invitationId);
            photosList.add(invitationPhotos);
        }
        invitation.setInvitationPhotosList(photosList);
       int num= invitationMapper.addInvitation(invitation);
        if(num>0){
            jsonResult.setMsg("帖子发布成功！");
            jsonResult.setStatus("200");
            return jsonResult;
        }
        jsonResult.setMsg("帖子发布失败！");
        jsonResult.setStatus("400");
        return jsonResult;
    }
}
