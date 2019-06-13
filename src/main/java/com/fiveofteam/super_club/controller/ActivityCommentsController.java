package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.ActivityComments;
import com.fiveofteam.super_club.service.ActivityCommentsService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/comments")
public class ActivityCommentsController {
    JsonResult jsonResult;
    private static final Logger logger = LoggerFactory.getLogger(ActivityCommentsController.class);

    @Autowired
    ActivityCommentsService activityCommentsService;

    /**
     * 添加评论
     *
     * @param activityComments
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult addComments(ActivityComments activityComments, HttpServletRequest request) {
        jsonResult = new JsonResult();
        // ActivityComments sessionInfo = sessionService.getSessionInfo(request);

        //  activityComments.setUaId(sessionInfo.ge());
        String userId = "";
        if (userId == null || "".isEmpty()) {
            jsonResult.setStatus("400");
            jsonResult.setMsg("你还没有登陆!请登录再试!");
            return jsonResult;
        }
        if (activityComments.getActivityId() == null || activityComments.getActivityId().isEmpty()) {//活动id
            jsonResult.setStatus("404");
            jsonResult.setMsg("活动丢失!请刷新再试!");
            return jsonResult;
        }
        if (activityComments.getContent() == null || activityComments.getContent().isEmpty()) {
            jsonResult.setMsg("活动内容不能为空!请填写评论内容!");
            return jsonResult;
        }
        if (activityComments.getActivityId() == null || activityComments.getActivityId().isEmpty()) {//活动id
            jsonResult.setStatus("400");
            jsonResult.setMsg("活动丢失!请刷新再试!");
            return jsonResult;
        }
        /**
         * todo 用户id
         */
        try {
            jsonResult = activityCommentsService.add(activityComments);
        } catch (Exception e) {
            logger.error(e.getMessage());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            return jsonResult;
        }
        return jsonResult;
    }

    /**
     * todo
     * 删除评论
     * @param userid nowId  roleId
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public JsonResult deleteComments(ActivityComments activityComments) {
        jsonResult = new JsonResult();

        try {

        } catch (Exception e) {
            logger.error(e.getMessage());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            return jsonResult;
        }

        return jsonResult;
    }

    /**
     * todo
     * 获取评论
     */
    @RequestMapping(value = "/selectList", method = RequestMethod.POST)
    public JsonResult selectCommentsList(String activityId) {
        jsonResult = new JsonResult();
        if (activityId == null || "".equals(activityId)) {
            jsonResult.setMsg("评论加载出错，原因:活动id为空!");
            jsonResult.setStatus("404");
            return jsonResult;
        }
        try {
            jsonResult = activityCommentsService.getCommentsList(activityId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            return jsonResult;
        }

        return jsonResult;
    }

}
