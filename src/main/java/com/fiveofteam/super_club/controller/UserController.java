package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.User;
import com.fiveofteam.super_club.service.UserService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    JsonResult jsonResult = new JsonResult();

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public JsonResult login() {
        jsonResult.setMsg("欢迎进入，您的身份是游客");
        return jsonResult;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public JsonResult submitLogin() {
        jsonResult.setMsg("欢迎进入，您的身份是游客");
        return jsonResult;
    }



    /**
     * 注册
     *
     * @param User
     * @return JsonResult
     * @Time
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public JsonResult signUp(User user) {
        jsonResult.setStatus("400");
        if (user.getUserName() == null || user.getUserName() == "") {
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "，用户名不能为空！");
            return jsonResult;
        }
        if (user.getUserPassword() == null || user.getUserPassword() == "") {
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "，密码不能为空！");
            return jsonResult;
        }
        if (user.getUserRealName() == null || user.getUserRealName() == "") {
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "，真实密码不能为空！");
            return jsonResult;
        }
        if (user.getUserRealName() == null || user.getUserRealName() == "") {  
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "，真实密码不能为空！");
            return jsonResult;
        }
        try {
            jsonResult = userService.signUp(user);
        } catch (Exception e) {
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "，系统错误！");
            return jsonResult;
        }
        return jsonResult;
    }
}
