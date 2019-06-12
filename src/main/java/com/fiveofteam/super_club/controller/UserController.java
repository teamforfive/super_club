package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.User;
import com.fiveofteam.super_club.service.UserService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    JsonResult jsonResult;
    private static final Logger logger=LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public JsonResult login() {
        jsonResult = new JsonResult();
        jsonResult.setMsg("欢迎进入，您的身份是游客");
        return jsonResult;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public JsonResult submitLogin() {
        jsonResult = new JsonResult();
        jsonResult.setMsg("欢迎进入，您的身份是游客");
        return jsonResult;
    }

    /**
     * 登录
     *
     * @param userBean
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public JsonResult singIn(UserBean userBean) {
        jsonResult = new JsonResult();
        Subject subject = SecurityUtils.getSubject();
        //检验用户是否存在
        try {
            // 在认证提交前准备 token（令牌）
            UsernamePasswordToken token = new UsernamePasswordToken(userBean.getUserName(), userBean.getUserPassword());
            // 执行认证登陆
            subject.login(token);
            //根据权限，指定返回数据
//            String role = userMapper.getRole(username);
//            if ("user".equals(role)) {
//                return resultMap.success().message("欢迎登陆");
//            }
//            if ("admin".equals(role)) {
//                return resultMap.success().message("欢迎来到管理员页面");
//            }

        } catch (Exception e) {
            logger.info(e.getMessage());
            jsonResult.setMsg("登录，发生未知错误！");
            return jsonResult;
        }
        jsonResult.setMsg("登陆成功!");
        jsonResult.setStatus("200");
        return jsonResult;
    }



    /**
     * 注册
     *todo 权限
     * @param user
     * @return JsonResult
     * @Time
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public JsonResult signUp(User user) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "，用户名不能为空!");
            return jsonResult;
        }
        if (user.getUserPassword() == null || user.getUserPassword().isEmpty()) {
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "，密码不能为空!");
            return jsonResult;
        }
        if (user.getUserRealName() == null || user.getUserRealName() == "") {
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "，真实姓名不能为空！");
            return jsonResult;
        }

        try {
            jsonResult = userService.signUp(user);
        } catch (Exception e) {
            logger.info(e.getMessage());
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "请稍后再试！");
            return jsonResult;
        }
        return jsonResult;

    }

    /**
     * 修改用户信息 todo
     * */
}
