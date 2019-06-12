package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.autho.CustomRealm;
import com.fiveofteam.super_club.dao.ActionMapper;
import com.fiveofteam.super_club.dao.RoleActionMapper;
import com.fiveofteam.super_club.pojo.Action;
import com.fiveofteam.super_club.service.ActionService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.DateTools;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    ActionMapper actionMapper;
    @Autowired
    RoleActionMapper roleActionMapper;
    JsonResult jsonResult;
    private static final Logger logger = LoggerFactory.getLogger(ActionServiceImpl.class);

    @Transactional
    @Override
    public JsonResult insertActionList(List<Action> list) {
        int num = 0;//记录成功条数
        jsonResult = new JsonResult();
        try {
            List<Action> actionList = new LinkedList<>();
            for (Action action : list
            ) {
                action.setUuId(CommonStringTool.UUID());//产生id
                action.setUpdateTime(DateTools.currentTime());//产生时间
                actionList.add(action);
            }
            //判断是否有权限存在
            //if（）
            num = actionMapper.insertActionList(actionList);
            if (num == 0) {//
                jsonResult.setStatus("500");
                jsonResult.setMsg("权限插入不成功！");
                return jsonResult;
            }
            jsonResult.setStatus("200");
            jsonResult.setMsg("权限插入成功！");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return jsonResult;
    }

    @Transactional
    @Override
    public JsonResult addActionForCustomer() {
        return null;
    }

    /**
     * 更新全新信息
     *
     * @param action
     */
    @Transactional
    @Override
    public JsonResult updateAction(Action action) {
        jsonResult = new JsonResult();
        int num;
        try {
            num = actionMapper.updateAction(action);
            jsonResult.setStatus("400");
            if (num == 0) {//判断是否更新成功
                jsonResult.setMsg("更新权限信息失败!");
                return jsonResult;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            jsonResult.setStatus(FallBackMsg.SysErrorInfo.getValue());
            return jsonResult;
        }
        jsonResult.setStatus("200");
        jsonResult.setMsg("更新权限信息成功!");
        return jsonResult;
    }

    /**
     * 获取权限列表
     */
    @Override
    @Transactional
    public List<Action> getActionList(String actionList) {
        List<Action> list = null;
        try {
            list = roleActionMapper.getActionList(actionList);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return list;
    }
}
