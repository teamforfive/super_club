package com.fiveofteam.super_club.tools;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


public class JsonResult {
    //返回运行状态
    private String status = "400";
    //返回运行结果信息介绍
    private String msg;
    //返回运行结果
    private Map<String, Object> item = new HashMap<>();

//    JsonResult() {
//    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getItem() {
        return item;
    }

    public void setItem(Map<String, Object> item) {
        this.item = item;
    }
}
