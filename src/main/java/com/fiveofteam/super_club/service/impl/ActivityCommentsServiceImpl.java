package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.ActivityCommentsMapper;
import com.fiveofteam.super_club.pojo.ActivityComments;
import com.fiveofteam.super_club.service.ActivityCommentsService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityCommentsServiceImpl implements ActivityCommentsService {
    JsonResult jsonResult;
    @Autowired
    ActivityCommentsMapper activityCommentsMapper;
    private String msg;

    /**
     * 添加活动
     */
    @Override
    @Transactional
    public JsonResult add(ActivityComments activityComments) {
        jsonResult = new JsonResult();
        activityComments.setActivityId(CommonStringTool.UUID());//设置id
        activityComments.setCommentStatus(true);//活动状态
        activityCommentsMapper.insert(activityComments);
        return jsonResult;
    }

    /**
     * 删除活动
     */
    @Override
    @Transactional
    public JsonResult delete(ActivityComments activityComments) {
        jsonResult = new JsonResult();
        return jsonResult;
    }

    /**
     * 获取活动
     */
    @Override
    @Transactional
    public JsonResult getCommentsList(String id) {
        jsonResult = new JsonResult();
        List<ActivityComments> list = activityCommentsMapper.getCommentsList(id);
        jsonResult.setMsg("评论获取成功！");
        jsonResult.setStatus("200");
        Map<String,Object> map=new HashMap<>();
        map.put("comments",list);
        jsonResult.setItem(map);
        return jsonResult;
    }
}
