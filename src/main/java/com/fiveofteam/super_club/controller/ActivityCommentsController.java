package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.ActivityComments;
import com.fiveofteam.super_club.tools.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class ActivityCommentsController {
    JsonResult jsonResult;
    private static final Logger logger = LoggerFactory.getLogger(ActivityCommentsController.class);

    /**
     * 添加评论
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult addComments(ActivityComments activityComments) {
        jsonResult = new JsonResult();

        try {

        } catch (Exception e) {
            logger.error(e.getMessage());
            return jsonResult;
        }
        return jsonResult;
    }
    /**todo
     * 删除评论
     *
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public JsonResult deleteComments(ActivityComments activityComments){
        jsonResult = new JsonResult();

        try {

        } catch (Exception e) {
            logger.error(e.getMessage());
            return jsonResult;
        }

        return jsonResult;
    }
    /**todo
     * 获取评论
     *
     */
    @RequestMapping(value = "/selectList",method = RequestMethod.POST)
    public JsonResult selectCommentsList(){
        jsonResult = new JsonResult();

        try {

        } catch (Exception e) {
            logger.error(e.getMessage());
            return jsonResult;
        }

        return jsonResult;
    }

}
