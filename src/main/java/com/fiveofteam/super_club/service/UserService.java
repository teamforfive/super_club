package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.User;
import com.fiveofteam.super_club.tools.JsonResult;

public interface UserService {
    /**
     * 注册
     */
    JsonResult signUp(User user);
    /**
     * 登陆
     */
    JsonResult signIn();
    /**
     * 修改用户信息
     */
    JsonResult updateUserInfo();
}
