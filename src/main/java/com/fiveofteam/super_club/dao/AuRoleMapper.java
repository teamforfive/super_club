package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.AuRole;
import com.fiveofteam.super_club.pojo.Role;

import java.util.List;

public interface AuRoleMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(AuRole record);

    int insertSelective(AuRole record);

    /**
     * 为用户添加角色
     */
    int patchRole(AuRole auRole);

    /**
     * 按用户id ，组织id 查询 角色
     */
    int selectByIdAndOragnizeId(AuRole auRole);
//    /**
//     * 按用户id ，组织id 角色id查询 是否存在
//     */
//    int selectByAllId(AuRole auRole);
    AuRole selectByPrimaryKey(String uuId);

    /**
     * 获取权限列表
     */
    List<Role> roleList(String userId);

    int updateByPrimaryKeySelective(AuRole record);

    int updateByPrimaryKey(AuRole record);
}