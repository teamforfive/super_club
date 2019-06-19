package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.Role;
import com.fiveofteam.super_club.service.RoleService;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 获取角色列表
     *
     * @param userId userType
     */
    @PostMapping("/getRoleList")
    @ApiOperation(value = "获取角色列表", notes = "如果用户id不为空，就获取该用户的角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, dataType = "String"),
            @ApiImplicitParam(name = "userType", value = "用户类型", required = true, dataType = "boolean"),
            @ApiImplicitParam(name = "clubId", value = "社团id", required = false, dataType = "String")})
    public JsonResult getRoleList(String userId, boolean userType, String clubId) {
        jsonResult = new JsonResult();
        try {

        } catch (Exception e) {
            logger.error(e.getMessage());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            jsonResult.setStatus(FallBackMsg.SysErrorInfo.getValue());
            return jsonResult;
        }
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
            logger.error(e.getMessage());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            jsonResult.setStatus(FallBackMsg.SysErrorInfo.getValue());
            return jsonResult;
        }
        return jsonResult;
    }


    /**
     * 删除某个role
     *
     * @param id
     */
    @PostMapping("/delRole")
    public JsonResult delRole(@RequestParam(name = "id") String id) {
        jsonResult = new JsonResult();
        if (id == null || "".equals(id)) {
            jsonResult.setMsg("id为空或者未选中角色！");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        try {
            jsonResult = roleService.delRoleById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            jsonResult.setStatus(FallBackMsg.SysErrorInfo.getValue());
            return jsonResult;
        }
        return jsonResult;
    }

    /**
     * 为用户添加角色
     */
    @PostMapping(value = "/addRoleForUser")
    public JsonResult addRoleForUser(@RequestParam(name = "uerId") String userId, @RequestParam(name = "roleId") String roleId, @RequestParam(name = "userType") boolean userType) {
        jsonResult = new JsonResult();
        try {
            jsonResult = roleService.addRoleForUser(userId, roleId, userType);
        } catch (Exception e) {
            logger.error(FallBackMsg.SysErrorInfo.getDisplayName());
        }
        return jsonResult;
    }

}

