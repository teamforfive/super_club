package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.ActivityComments;
import com.fiveofteam.super_club.tools.JsonResult;

public interface ActivityCommentsService {

    /**
     * 为活动添加评论
     */
    JsonResult add(ActivityComments activityComments);

    /**
     * 删除某活动评论
     */
    JsonResult delete(ActivityComments activityComments);

    /**
     *获取某活动评论
     */
    JsonResult getCommentsList(ActivityComments activityComments);

}
