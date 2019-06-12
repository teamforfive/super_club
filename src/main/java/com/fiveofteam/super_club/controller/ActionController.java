package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.Action;
import com.fiveofteam.super_club.service.ActionService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Action")
public class ActionController {
    @Autowired
    ActionService actionService;
    JsonResult jsonResult;
    private final Logger logger = LoggerFactory.getLogger(ActionController.class);

    /**
     * 插入权限列表
     */
    @RequestMapping(value = "/insertActionList", method = RequestMethod.POST)
    public JsonResult insertActionList(@RequestBody List<Action> actionList) {
        //判断用户信息是否为空 todo
        jsonResult = new JsonResult();
        //CommonStringTool.strIsEmpty(actionList);
        if (actionList == null || actionList.isEmpty()) {
            jsonResult.setMsg("不能为空！");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        try {
            jsonResult = actionService.insertActionList(actionList);
        } catch (Exception e) {
            logger.info(e.getMessage());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            jsonResult.setStatus(FallBackMsg.SysErrorInfo.getValue());
            return jsonResult;
        }
        return jsonResult;
    }

    /**
     * 更新权限信息
     *
     * @param action
     * @return json
     */
    @PostMapping("/updateAction")
    public JsonResult updateAction(Action action) {
        //判断用户信息是否为空 todo
        jsonResult = new JsonResult();
        if (action == null || "".equals(action)) {
            jsonResult.setStatus(FallBackMsg.NotNull.getValue());
            jsonResult.setMsg(FallBackMsg.NotNull.getDisplayName());
            return jsonResult;
        }
        try {
            jsonResult = actionService.updateAction(action);

        } catch (Exception e) {
            logger.info(e.getMessage());
            return jsonResult;
        }
        return jsonResult;
    }
}
