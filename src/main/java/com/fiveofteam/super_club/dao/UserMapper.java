package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.User;
import com.fiveofteam.super_club.pojo.bean.UserBean;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uuId);

    /**
     * 查询用户
     */
    int selectName(String name);

    /**
     * 查询盐值
     */
    String selectSalt(String uuId);

    /**
     * 登陆
     */
    User login(UserBean userBean);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}