package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.Invitation;
import com.fiveofteam.super_club.tools.JsonResult;

public interface InvitationService {
    /**
     * 获取帖子列表
     */
    JsonResult getInvitations(String authorId);
    /**
     * 添加贴子
     * */
    JsonResult addInvitation(Invitation invitation);
}
