package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Role record);

    int insertList(List<Role> list);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String uuId);

    /**
     * 通过角色名查询id
     */
    String selectIdByName(@Param("roleName") String name);

   Role getRole(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}