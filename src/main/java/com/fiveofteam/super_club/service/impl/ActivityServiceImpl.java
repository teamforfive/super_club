package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.ActivityMapper;
import com.fiveofteam.super_club.pojo.Activity;
import com.fiveofteam.super_club.service.ActivityService;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    private JsonResult jsonResult;

    @Override
    public JsonResult addArticle(Activity activity) {
        activityMapper.insert(activity);
        return jsonResult;
    }
}
