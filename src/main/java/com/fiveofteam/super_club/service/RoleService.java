package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.Role;
import com.fiveofteam.super_club.tools.JsonResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    /**
     * 为新注册用户添加角色
     */
    JsonResult addRoleOnUser();

    /**
     * 更改用户角色
     */
    JsonResult updateRoleOnUser();

    /**
     * 添加角色
     */
    JsonResult insertRole(Role role);

    /**
     * 批量插入角色
     */
    JsonResult insertRoleList(List<Role> list);

    /**
     * 按角色查询id
     */
    JsonResult selectIdByName(@Param("roleName") String name);
    /**
     * 获取角色列表
     * */
    List<Role> getRoleListById(String id);


}
