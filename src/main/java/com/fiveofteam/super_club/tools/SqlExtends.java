package com.fiveofteam.super_club.tools;

public class SqlExtends {
    public   String roleType(int i) {
        boolean auType = true;
        if (i == 2) {//管理员
            auType = false;
        }
        String str = "and au_type=#{" + auType + "}";
        return str;
    }

}
