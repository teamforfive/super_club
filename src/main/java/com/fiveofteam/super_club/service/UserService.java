package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.User;
import com.fiveofteam.super_club.pojo.bean.UserBean;
import com.fiveofteam.super_club.tools.JsonResult;

public interface UserService {
    /**
     * 注册
     */
    JsonResult signUp(User user, boolean userType);

    /**
     * 登陆
     */
    User signIn(UserBean userBean, boolean userType);

    /**
     * 修改用户信息
     */
    JsonResult updateUserInfo();

    /**
     * 用户密码找回
     */
    JsonResult retrievePassWord(UserBean userBean);


}
