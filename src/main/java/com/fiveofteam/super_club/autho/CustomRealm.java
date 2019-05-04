package com.fiveofteam.super_club.autho;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(CustomRealm.class);

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
        String password = "";
        if (null == password) {
            throw new AccountException("用户名不正确");
            //token.getCredentials()获得密码 Object
        } else if (!password.equals(new String((char[]) userToken.getCredentials()))) {
            throw new AccountException("密码不正确");
        }

        return new SimpleAuthenticationInfo(userToken.getPrincipal(), password, getName());
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("----权限认证---");
        String uername = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //从数据库获得该用户角色
        String role = "";
        Set<String> set = new HashSet<>();
        //需要将role封装到Set作为info.setRoles()的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }


}
