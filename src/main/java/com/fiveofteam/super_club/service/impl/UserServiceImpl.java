package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.UserMapper;
import com.fiveofteam.super_club.pojo.User;
import com.fiveofteam.super_club.service.UserService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import com.fiveofteam.super_club.tools.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    JsonResult jsonResult = new JsonResult();

    @Override
    public JsonResult signUp(User user) {
        String salt="";
        String passWord="";
        try {
            //写入uu_id
            user.setUuId(CommonStringTool.UUID());
            //盐值
            salt=MD5.smallmd5(user.getUserRealName()+user.getUserName()+user.getUserPassword());
           //密码加密
            passWord= MD5.md5(salt+user.getUserPassword());
            user.setUerSalt(salt);
            user.setUserPassword(passWord);
            userMapper.insert(user);
            jsonResult.setMsg(FallBackMsg.SignOk.getDisplayName  ());
            jsonResult.setStatus("200");
        } catch (Exception e) {
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName()+"请稍后再试！");
            return jsonResult;
        }
        return jsonResult;
    }

    @Override
    public JsonResult signIn() {
        return null;
    }

    @Override
    public JsonResult updateUserInfo() {
        return null;
    }
}
