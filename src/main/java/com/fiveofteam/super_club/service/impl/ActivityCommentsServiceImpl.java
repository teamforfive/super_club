package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.pojo.ActivityComments;
import com.fiveofteam.super_club.service.ActivityCommentsService;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityCommentsServiceImpl implements ActivityCommentsService {
    JsonResult jsonResul;
    /**添加活动*/
    @Override
    @Transactional
    public JsonResult add(ActivityComments activityComments) {

        return null;
    }

    @Override
    @Transactional
    public JsonResult delete(ActivityComments activityComments) {
        return null;
    }

    @Override
    @Transactional
    public JsonResult getCommentsList(ActivityComments activityComments) {
        return null;
    }
}
