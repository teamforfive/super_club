package com.fiveofteam.super_club.tools;

import java.sql.Timestamp;

public class DateTools {

    /**
     * "2011-05-09 11:49:45"
     */
    public static Timestamp currentTime() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
////            String tsStr = "2011-05-09 11:49:45";
//            try {
////                ts = Timestamp.valueOf(tsStr);
////                System.out.println(ts);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        return ts;
    }

}
