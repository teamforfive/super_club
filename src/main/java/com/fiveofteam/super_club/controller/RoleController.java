package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.Role;
import com.fiveofteam.super_club.service.RoleService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    private final Logger logger = LoggerFactory.getLogger(RoleService.class);
    JsonResult jsonResult;

    @PostMapping("/insertRole")
    public JsonResult insertRole() {
        return jsonResult;
    }

    /**
     * 插入角色列表
     */
    @PostMapping("/insertRoleList")
    public JsonResult insertRoleList(@RequestBody List<Role> list) {
        jsonResult = new JsonResult();
        if (list == null || list.isEmpty()) {
            jsonResult.setMsg(FallBackMsg.NotNull.getDisplayName());
            jsonResult.setStatus(FallBackMsg.NotNull.getValue());
            return jsonResult;
        }
        try {
            jsonResult = roleService.insertRoleList(list);
        } catch (Exception e) {
            return jsonResult;
        }
        return jsonResult;
    }

}

