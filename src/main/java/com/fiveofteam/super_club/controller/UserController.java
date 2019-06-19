package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.config.NameConfig;
import com.fiveofteam.super_club.pojo.User;
import com.fiveofteam.super_club.pojo.bean.SessionInfo;
import com.fiveofteam.super_club.pojo.bean.UserBean;
import com.fiveofteam.super_club.service.SessionService;
import com.fiveofteam.super_club.service.UserService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private NameConfig nameConfig;
    @Autowired
    private SessionService sessionService;
    JsonResult jsonResult;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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
    public JsonResult singIn(UserBean userBean, HttpSession session, HttpServletRequest request) {
        jsonResult = new JsonResult();
//        SessionInfo sessionInfos= sessionService.getSessionInfo(request);
//        if(sessionInfos.getLoginName()==userBean.getUserName()){}
        Subject subject = SecurityUtils.getSubject();
        if (session != null) {
          //  session.getAttribute()
            if (!subject.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken(userBean.getUserName(), userBean.getUserPassword());
                //检验用户是否存在
                try {
                    User user = userService.signIn(userBean, true);//用户信息查找
                    SessionInfo sessionInfo = new SessionInfo();
                    /**验证码、权限列表
                     * todo
                     * */
                    sessionInfo.setUserId(user.getUuId());
                    sessionInfo.setLoginName(user.getUserName());
                    String sessionName = nameConfig.sessionInfoName;
                    // 在认证提交前准备 token（令牌）

                    // 执行认证登陆
                    subject.login(token);
                    session.setAttribute(sessionName, sessionInfo);
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
            }
            jsonResult.setMsg("登陆成功!");
            jsonResult.setStatus("200");
        }

        return jsonResult;
    }


    /**
     * 注册
     * todo 权限
     *
     * @param user
     * @return JsonResult
     * @Time
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public JsonResult signUp(User user, @RequestParam(value = "userType", required = true, defaultValue = "true") boolean userType) {
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
            jsonResult = userService.signUp(user, userType);
        } catch (Exception e) {
            logger.info(e.getMessage());
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.SignFail.getDisplayName() + "请稍后再试！");
            return jsonResult;
        }
        return jsonResult;

    }

    /**
     * 用户退出登录
     *
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult();

        // SessionInfo sessionInfo = sessionService.getSessionInfo(request);
        String sessionName = nameConfig.sessionInfoName;
        Subject currentUser = SecurityUtils.getSubject();

        if (session != null) {
            //   CookieUtil.removeCookie(response, "companyId");
            // Session currentSesession = currentUser.getSession();

            if (sessionName != null) {
                session.removeAttribute(sessionName);
            }
            session.isNew();
            // if(currentSesession!=null) {
            // currentSesession
            // currentUser.i
            // currentSesession.removeAttribute("key");
         //   System.out.println("");
            currentUser.logout();
            // }
            // session.invalidate();

        }
        return "redirect:/page/html/login.html";
    }
    /**
     * 修改用户信息 todo
     * */
}
