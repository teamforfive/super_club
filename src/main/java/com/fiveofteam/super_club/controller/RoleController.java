package com.fiveofteam.super_club.controller;

import com.fiveofteam.super_club.pojo.AuRole;
import com.fiveofteam.super_club.pojo.Role;
import com.fiveofteam.super_club.service.AuRoleService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    AuRoleService auRoleService;
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
            @ApiImplicitParam(name = "userType", value = "用户类型,0=所有类型，1=用户，2,=管理员", required = true, dataType = "boolean"),
            @ApiImplicitParam(name = "clubId", value = "社团id", required = false, dataType = "String")})
    public JsonResult getRoleList(String userId, int userType, String clubId) {
        jsonResult = new JsonResult();
        try {
            Map<String, Object> map = new HashMap<>();
            List<Role> list = roleService.getRoleListById(userId, clubId, userType);
            jsonResult.setStatus("200");
            jsonResult.setMsg("角色查询成功！");
            map.put("roleList", list);
            jsonResult.setItem(map);
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
    @ApiOperation(value = "插入角色列表", notes = "插入一个List<Role>")
    @ApiImplicitParam(name = "list", value = "角色集合", required = true, dataType = "List<Role>")
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
            e.printStackTrace();
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
    @ApiOperation(value = "删除某个角色", notes = "根据角色id删除某个角色")
    @ApiImplicitParam(name = "id", value = "某个角色的id", required = true, dataType = "String")
    @PostMapping("/delRole")
    public JsonResult delRole(@RequestParam(value = "id") String id) {
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
     * 只有管理员和社团能使用该角色
     * @param roleId
     * @param userType
     * @param userId
     */
    @PostMapping(value = "/addRoleForUser")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "userId", value = "用户id", dataType = "String", required = true),
                    @ApiImplicitParam(name = "roleId", value = "角色id", dataType = "String", required = true),
                    @ApiImplicitParam(name = "userType", value = "用户类型", dataType = "boolean", required = true),
                    @ApiImplicitParam(name = "clubId", value = "社团id", dataType = "String", required = false)})
    @ApiOperation(value = "为用户添加角色", notes = "为用户添加角色 ，1.if clubId 为null，userType为false ，是为系统管理员添加角色;" +
                                                                     "2.if clubId 不为null，userType为true 是为用户添加角色")
    public JsonResult addRoleForUser(@RequestParam(value = "userId") String userId,
                                     @RequestParam(value = "roleId") String roleId,
                                     @RequestParam(value = "clubId", required = false) String clubId,
                                     @RequestParam(value = "userType") boolean userType) {
        jsonResult = new JsonResult();
        AuRole auRole = new AuRole();
        auRole.setAuId(userId);
        auRole.setClubId(clubId);
        auRole.setAuType(userType);
        auRole.setRoleId(roleId);
        try {
            jsonResult = auRoleService.patchRole(auRole);
        } catch (Exception e) {
            logger.error(e.getMessage());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            jsonResult.setStatus(FallBackMsg.SysErrorInfo.getValue());
            return jsonResult;
        }
        return jsonResult;
    }

}

