package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.AuRoleMapper;
import com.fiveofteam.super_club.dao.RoleMapper;
import com.fiveofteam.super_club.pojo.AuRole;
import com.fiveofteam.super_club.pojo.Role;
import com.fiveofteam.super_club.service.RoleService;
import com.fiveofteam.super_club.tools.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    JsonResult jsonResult;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuRoleMapper auRoleMapper;
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    /**
     * 为普通用户添加角色
     */
    @Override
    public JsonResult addRoleOnUser() {
        jsonResult = new JsonResult();
        return jsonResult;
    }

    @Override
    public JsonResult updateRoleOnUser() {
        return null;
    }

    @Override
    public JsonResult insertRole(Role role) {
        //插入ID
        role.setUuId(CommonStringTool.UUID());
        roleMapper.insert(role);
        return null;
    }

    /**
     * 添加角色列表
     */
    @Transactional
    @Override
    public JsonResult insertRoleList(List<Role> list) {
        int num;
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        /**
         * todo 判断数据库是否有这个角色
         * */

        List<Role> rolelist = new ArrayList<>();
        for (Role role : list) {//为每个角色添加id,创建时间
            role.setUuId(CommonStringTool.UUID());
            role.setUpdateTime(DateTools.currentTime());
            rolelist.add(role);
        }

        num = roleMapper.insertList(rolelist);
        if (num == 0) {//判断是否更新成功
            jsonResult.setStatus("角色列表插入失败!");
            return jsonResult;
        }
        jsonResult.setStatus("角色列表插入成功!");
        jsonResult.setStatus("200");

        return jsonResult;
    }

    @Override
    public JsonResult selectIdByName(String name) {
        jsonResult = new JsonResult();

        return jsonResult;
    }

    /**
     * 获取角色列表
     */
    @Override
    @Transactional
    public List<Role> getRoleListById(String userId, String clubId, int userType) {
        String str = "";
        if (userType != 0) {
            SqlExtends sql = new SqlExtends();
            str = sql.roleType(userType);
        }
        List<Role> list = auRoleMapper.roleList(userId, clubId, str);
        return list;
    }

    /**
     * 后台管理员
     * 谨慎使用
     * <p>
     * 删除角色
     * **真删除**
     */
    @Override
    @Transactional
    public JsonResult delRoleById(String id) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        /*查找数据库中是否存在该角色
         * */
        int num = roleMapper.selectRoleById(id);
        if (num <= 0) {
            jsonResult.setMsg("角色不存在");
            return jsonResult;
        }
        roleMapper.delRole(id);
        /*删除数据库中该角色的权限 todo
         * */
        /*删除用户身上该角色 todo
         * */
        /*
         * 删除该角色 todo
         * */
        num = 0;
        num = roleMapper.selectRoleById(id);
        if (num > 0) {
            jsonResult.setMsg("角色删除失败！");
            return jsonResult;
        }
        jsonResult.setStatus("200");
        jsonResult.setMsg("角色删除成功！");
        return jsonResult;
    }

    @Override
    public JsonResult delRoleOfUser(String id, boolean userType) {
        return null;
    }


}
