package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.config.NameConfig;
import com.fiveofteam.super_club.pojo.bean.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class SessionService {
    @Autowired
    NameConfig nameConfig;

    public void addCookie(HttpServletResponse response, String account, String password) {
        StringBuffer str = new StringBuffer();
        str.append(account).append("@@@").append("@@@").append(password);
        Cookie user = new Cookie("LoginUser", str.toString());
        user.setPath("/superClub/");
        user.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(user);
    }

    public void cleanCookie(HttpServletResponse response) {
        Cookie user = new Cookie("LoginUser", null);
        user.setPath("/superClub/");
        user.setMaxAge(0);
        response.addCookie(user);
    }

    public void cleanSession(HttpServletRequest request) {
        request.getSession().removeAttribute("customer");
    }

    public SessionInfo getSessionInfo(HttpServletRequest request) {
        return (SessionInfo) WebUtils.getSessionAttribute(request, nameConfig.sessionInfoName);
    }
}
