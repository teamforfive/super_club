package com.fiveofteam.super_club.tools;

import java.util.UUID;

public class CommonStringTool {
    /**
     * 获取UUID
     */
    public static String UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取指定数目的UUID
     * @param num
     */
    public static String[] getUUID(int num) {
        if (num < 1) {
            return null;
        }
        String[] retArray = new String[num];
        for (int i = 0; i < num; i++) {
            retArray[i] = UUID();
        }
        return retArray;
    }
}
