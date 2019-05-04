package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.tools.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
   JsonResult jsonResult=new JsonResult();
    //private UserMapper userMapper;

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public JsonResult notLogin() {
       jsonResult.setMsg("您尚未登陆！");
        return jsonResult;
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public JsonResult notRole() {
        jsonResult.setMsg("您没有权限！");
        return jsonResult;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public JsonResult logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        jsonResult.setMsg("成功注销！");
        return jsonResult;
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        String role =""; //userMapper.getRole(username);
        if ("user".equals(role)) {
            jsonResult.setMsg("欢迎登陆");
            return jsonResult;
        }
        if ("admin".equals(role)) {
            jsonResult.setMsg("欢迎来到管理员页面");

        }
        jsonResult.setMsg("权限错误！");
        return jsonResult;
    }
}
