package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.AuRole;
import com.fiveofteam.super_club.tools.JsonResult;

public interface AuRoleService {
    /**
     * 为用户添加角色
     */
    JsonResult patchRole(AuRole auRole);
    /**
     * 更新用户角色
     * */
    JsonResult updateRole(AuRole auRole);
}
