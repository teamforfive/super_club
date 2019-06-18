package com.fiveofteam.super_club;

import com.fiveofteam.super_club.pojo.Role;
import com.fiveofteam.super_club.service.RoleService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.DateTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleControllerTest {
    @Autowired
    RoleService roleService;

    @Test
    public void insert() {
        String roleStr[][]={{"guest","游客"},{"admin","管理员"},{"user","普通用户"},{"root","超级管理员"}};
        List<Role> list = new ArrayList<>();
        for (int i=0;i<roleStr.length;i++) {
            Role role = new Role();
            role.setUuId(CommonStringTool.UUID());
            role.setRoleName(roleStr[i][0]);
            role.setRoleComment(roleStr[i][1]);
            role.setUpdateTime(DateTools.currentTime());
            list.add(role);
        }
        try {
            roleService.insertRoleList(list);
        }catch (Exception e){
            System.out.println("xxx"+e.getMessage());
        }

    }
}
