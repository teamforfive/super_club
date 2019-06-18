package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.AdminMapper;
import com.fiveofteam.super_club.dao.AuRoleMapper;
import com.fiveofteam.super_club.dao.RoleMapper;
import com.fiveofteam.super_club.dao.UserMapper;
import com.fiveofteam.super_club.pojo.Admin;
import com.fiveofteam.super_club.pojo.AuRole;
import com.fiveofteam.super_club.pojo.Role;
import com.fiveofteam.super_club.pojo.User;
import com.fiveofteam.super_club.pojo.bean.UserBean;
import com.fiveofteam.super_club.service.UserService;
import com.fiveofteam.super_club.tools.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuRoleMapper auRoleMapper;
    @Autowired
    private AdminMapper adminMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    JsonResult jsonResult;

    /**
     * 注册
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = {Exception.class})
    public JsonResult signUp(User user, boolean userType) {
        jsonResult = new JsonResult();
        String salt;
        String passWord;
        int num;
        if (!userType) {
            return singUpAdmin(user);//注册管理员
        }
        //查询用户是否存在
        int userNum = userMapper.selectName(user.getUserRealName());
        if (userNum > 0) {
            jsonResult.setMsg("用户已经存在!");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        //写入uu_id
        user.setUuId(CommonStringTool.UUID());
        //盐值
        salt = MD5.smallmd5(user.getUserRealName() + user.getUserName() + user.getUserPassword());
        //密码加密
        passWord = MD5.md5(salt + user.getUserPassword());
        user.setUerSalt(salt);
        user.setUserPassword(passWord);
        user.setUserSattus(1);//插入状态
        if (user.getUserSex() == null || !"".equals(user.getUserSex())) {
            user.setUserSex(Byte.parseByte("0"));//未知性别
        }
        userMapper.insert(user);
        //插入游客角色-guest
        AuRole auRole = new AuRole();
        // user.getUuId();
        String roleId = roleMapper.selectIdByName("guest");
        if (roleId == null || "".equals(roleId)) {
            jsonResult.setMsg("角色不存在,请联系管理员!");
            jsonResult.setStatus("500");
            return jsonResult;
        }
        auRole.setRoleId(roleId);//插入角色id
        auRole.setClubId("100000");//组织Id\
        auRole.setAuId(user.getUuId());//插入用户Id
        auRole.setAuType(true);
        auRole.setCreateTime(DateTools.currentTime());
        //查询
        num = auRoleMapper.selectByIdAndOragnizeId(auRole);
        if (num > 0) {
            jsonResult.setMsg("角色存在！");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        auRole.setUuId(CommonStringTool.UUID());//插入该条信息的id
        //插入角色
        num = auRoleMapper.patchRole(auRole);
        if (num == 0) {
            jsonResult.setMsg("为用户添加角色不成功!");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        //权限
        jsonResult.setMsg(FallBackMsg.SignOk.getDisplayName());
        jsonResult.setStatus("200");
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            jsonResult.setStatus("500");
//            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "请稍后再试！");
//            return jsonResult;
//        }
        return jsonResult;
    }

    /**
     * 用户登录
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = {Exception.class})
    public User signIn(UserBean userBean, boolean userType) {
//        if(!userType){
//            adminLogin(userBean);
//        }
        User user = null;
        UserBean bean = userBean;
        String passWord = userBean.getUserPassword();
        logger.error(passWord);
        bean.setUserPassword("");
        try {
            user = userMapper.login(bean);//获取id
            logger.info("从数据库获取对应的 userBean.getUserPassword():{}", passWord);
            String id = user.getUuId();
            if (id == null || id.isEmpty()) {
                logger.info("PassWord.class:{}", "id为空");
                return null;
            }

            if (passWord == null || passWord.isEmpty()) {
                logger.info("PassWord.class:{}", "passWord为空");
                return null;
            }
            String salt = null;
            logger.info("id>>" + id);
            salt = userMapper.selectSalt(id);//查询盐值
            logger.info("PassWord.class:{}", "salt" + salt);
            if (salt == null || salt.isEmpty()) {
                logger.info("PassWord.class:{}", "salt为空");
                return null;
            }
            logger.info("PassWord.class:{}", "salt为空" + salt);

            logger.info("salt" + salt);
            passWord = MD5.md5(salt + passWord);//密码加密
            logger.info("passWord" + passWord);
            userBean.setUserPassword(passWord);
            user = userMapper.login(userBean);
        } catch (Exception e) {
            System.out.println(4555555);
            logger.error(e.getMessage());
            return null;
        }
        return user;
    }

    /**
     * 更新用户信息
     */
    @Override
    public JsonResult updateUserInfo() {
        return null;
    }

    /**
     * 找回密码
     */
    @Transactional
    @Override
    public JsonResult retrievePassWord(UserBean userBean) {
        jsonResult = new JsonResult();
        String passWord;
        try {
            //根据某个条件查询id todo
//            passWord = new PassWord().getPassWord(userBean.getUuId(), userBean.getUserPassword());
            String id = userBean.getUuId();
            if (id == null || id.isEmpty()) {
                logger.info("PassWord.class:{}", "id为空");
                return null;
            }

            if (userBean.getUserPassword() == null || userBean.getUserPassword().isEmpty()) {
                logger.info("PassWord.class:{}", "passWord为空");
                return null;
            }
            String salt = null;
            logger.info("id>>" + id);
            salt = userMapper.selectSalt(id);//查询盐值
            logger.info("PassWord.class:{}", "salt" + salt);
            if (salt == null || salt.isEmpty()) {
                logger.info("PassWord.class:{}", "salt为空");
                return null;
            }
            logger.info("PassWord.class:{}", "salt为空" + salt);

            logger.info("salt" + salt);
            passWord = MD5.md5(salt + userBean.getUserPassword());//密码加密
            if (passWord == null || passWord.isEmpty()) {
                jsonResult.setStatus("400");
                jsonResult.setMsg("用户不存在!去注册或者再试一次!");
                return jsonResult;
            }
            userBean.setUserPassword(passWord);
            //更新密码 todo
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 注册管理员
     */
    private JsonResult singUpAdmin(User user) {
        String salt;
        String passWord;
        int num = adminMapper.selectOne(user.getUserName());
        if (num > 0) {
            jsonResult.setMsg("管理员名已经被使用");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        Admin admin = new Admin();
        admin.setAdminName(user.getUserName());
        admin.setAdminStatus(1);
        String adminId = CommonStringTool.UUID();//管理员ID
        admin.setUuId(adminId);
        //盐值
        salt = MD5.smallmd5(user.getUserRealName() + user.getUserName() + user.getUserPassword());
        //密码加密
        passWord = MD5.md5(salt + user.getUserPassword());
        admin.setAdminPassword(passWord);
        admin.setAdminSalt(salt);
        admin.setAdminCode("100000");//todo
        int count = adminMapper.insert(admin);
        if (count < 1) {
            jsonResult.setStatus("400");
            jsonResult.setMsg("管理员注册失败！");
            return jsonResult;
        }

        //插入管理员角色
        AuRole auRole = new AuRole();
        // user.getUuId();
        String roleId = roleMapper.selectIdByName("admin");
        if (roleId == null || "".equals(roleId)) {
            jsonResult.setMsg("角色不存在,请联系管理员!");
            jsonResult.setStatus("500");
            return jsonResult;
        }
        auRole.setRoleId(roleId);//插入角色id
        auRole.setClubId("000000");//组织Id
        auRole.setAuId(adminId);//插入用户Id
        auRole.setAuType(false);//管理员类型 false
        auRole.setCreateTime(DateTools.currentTime());
        //查询
        num = auRoleMapper.selectByIdAndOragnizeId(auRole);
        if (num > 0) {
            jsonResult.setMsg("角色关系已经存在！");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        auRole.setUuId(CommonStringTool.UUID());//插入该条信息的id
        //插入角色
        num = auRoleMapper.patchRole(auRole);
        if (num == 0) {
            jsonResult.setMsg("为管理员添加角色不成功!");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        //插入权限 todo
        jsonResult.setMsg(FallBackMsg.SignOk.getDisplayName());
        jsonResult.setStatus("200");

        return jsonResult;
    }

    /**
     * 登录管理员
     */
    private JsonResult adminLogin(UserBean userBean) {
        return jsonResult;
    }
}
