package com.fiveofteam.super_club.autho;

import com.fiveofteam.super_club.dao.UserMapper;
import com.fiveofteam.super_club.pojo.Action;
import com.fiveofteam.super_club.pojo.Role;
import com.fiveofteam.super_club.pojo.User;
import com.fiveofteam.super_club.pojo.bean.UserBean;
import com.fiveofteam.super_club.service.ActionService;
import com.fiveofteam.super_club.service.RoleService;
import com.fiveofteam.super_club.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(CustomRealm.class);
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    ActionService actionService;

    /**
     * 获取身份验证信息
     * shiro中，最后是通过Realm来获取
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("---------身份认证开始--------");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //从数据库获取对应用户名密码的用户
         /*//获得用户名 String
                token.getUsername();
                //获得用户名 Object
                token.getPrincipal();
                //获得密码 char[]
                token.getPassword();
                //获得密码 Object
                token.getCredentials();
                */
        UserBean userBean = new UserBean();
        String userName = userToken.getUsername();//获取用户名
        String password = String.valueOf(userToken.getPassword());//获取用户密码对象（char[]）
        userBean.setUserName(userName);
        userBean.setUserPassword(password);
        //   logger.info("pass" + password);

        //  logger.info("从数据库获取对应的userName:{}", userName + "对应的信息!");
        User user = userService.signIn(userBean,true);
        logger.info("数据查询完毕");
        if (!user.getUserName().equals(userName)) {
            throw new UnknownAccountException("用户不存在!");
        }
        logger.info("simpleAuthenticationInfo");
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        try {
            logger.info("password>>>>>" + password);
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(userToken.getPrincipal(),password, ByteSource.Util.bytes(user.getUerSalt()), getName());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return simpleAuthenticationInfo;
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("----权限认证---");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        Set<String> roleSet = new HashSet<>();
        Set<String> actionSet = new HashSet<>();
        //从数据库获得该用户角色
        List<Role> roleList = roleService.getRoleListById((String) session.getAttribute("uuId"));
        for (Role role : roleList) {
            //根据角色id获取到资源信息
            List<Action> actionList = actionService.getActionList(role.getUuId());
            for (Action action : actionList) {
                if (action != null && !action.getActionName().isEmpty()) {
                    actionSet.add(action.getActionName());
                }
            }
            //查询角色信息
            if (role != null && !role.getRoleName().isEmpty()) {
                roleSet.add(role.getRoleName());
            }
        }

        //需要将role封装到Set作为info.setRoles()的参数
        // roleSet.add(role);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //设置该用户拥有的角色
        info.setRoles(roleSet);
        info.addStringPermissions(actionSet);
        // 返回 SimpleAuthorizationInfo 对象.
        return info;
    }


}
