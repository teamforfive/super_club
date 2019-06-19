package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.AuRoleMapper;
import com.fiveofteam.super_club.dao.RoleMapper;
import com.fiveofteam.super_club.pojo.AuRole;
import com.fiveofteam.super_club.pojo.Role;
import com.fiveofteam.super_club.service.RoleService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.DateTools;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
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
    AuRoleMapper auRoleMapper;
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
     //   try {
            List<Role> rolelist = new ArrayList<>();
            for (Role role : list) {
                role.setUuId(CommonStringTool.UUID());
                role.setUpdateTime(DateTools.currentTime());
                list.add(role);
            }
            num = roleMapper.insertList(rolelist);
            if (num == 0) {//判断是否更新成功
                jsonResult.setStatus("更新角色列表失败!");
                return jsonResult;
            }
     /*   } catch (Exception e) {
            logger.info(e.getMessage());
            jsonResult.setStatus(FallBackMsg.SysErrorInfo.getValue());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            return jsonResult;
        }*/

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
    public List<Role> getRoleListById(String id) {
        List<Role> list = null;
        try {
            list = auRoleMapper.roleList(id);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

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
        num = 0;
        num = roleMapper.delRole(id);
        /*删除数据库中该角色的权限 todo
         * */
        /*删除用户身上该角色 todo
         * */
        /*
         * 删除该角色 todo
         * */
        if (num <= 0) {

            jsonResult.setMsg("角色删除失败");
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

    @Override
    public JsonResult addRoleForUser(String userId, String roleId, boolean userType) {
        jsonResult = new JsonResult();
        AuRole auRole=new AuRole();
        /**
         * 不能给用户大于自己的角色*/
        auRole.setAuType(userType);
        auRole.setUuId(roleId);
        auRole.setClubId("!!");//todo
        auRole.setAuId(userId);
        int num=auRoleMapper.selectByIdAndOragnizeId(auRole);
        if(num>0){
            jsonResult.setStatus("400");
            jsonResult.setMsg("角色已经存在！");
            return jsonResult;
        }
        num=0;
        num=roleMapper.addRoleForUser(userId,roleId,userType);
        if(num<=0){
            jsonResult.setStatus("400");
            jsonResult.setMsg("角色添加失败！");
            return jsonResult;
        }
        jsonResult.setStatus("200");
        jsonResult.setMsg("角色添加成功！");
        return jsonResult;
    }
}
