package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.Invitation;
import com.fiveofteam.super_club.service.InvitationService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RequestMapping("/invitation")
@RestController
public class InvitationController {
    JsonResult jsonResult;
    @Autowired
    InvitationService invitationService;
    private Logger logger= LoggerFactory.getLogger(InvitationController.class);

    @PostMapping("/add")
    public JsonResult addInvitation(Invitation invitation, HttpSession httpSession) {
        jsonResult = new JsonResult();
        try {

        } catch (Exception e) {
            return jsonResult;
        }
        return jsonResult;
    }

    @PostMapping("/del")
    public JsonResult delInvitation(Invitation invitation, HttpSession httpSession) {
        jsonResult = new JsonResult();

        return jsonResult;
    }

    @PostMapping("/update")
    public JsonResult updateInvitation(Invitation invitation, HttpSession httpSession) {
        jsonResult = new JsonResult();

        return jsonResult;
    }

    @PostMapping("/get")
    public JsonResult getInvitation(Invitation invitation, HttpSession httpSession) {
        jsonResult = new JsonResult();

        return jsonResult;
    }

    /**
     * 获取博客列表
     */
    @PostMapping("/getList")
    @ApiOperation(value = "获取帖子集合")
    public JsonResult getInvitations(Invitation invitation, String authorId, HttpSession httpSession) {
        jsonResult = new JsonResult();
        // if(){}
        try {
            jsonResult = invitationService.getInvitations(authorId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            return jsonResult;
        }
        return jsonResult;
    }
}
