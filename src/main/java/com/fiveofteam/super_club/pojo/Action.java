package com.fiveofteam.super_club.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("acion")
public class Action {

//    @TableId(type =  IdType.AUTO)
    private String uuId;

    private String actionName;

    private String actionCode;

    private String actionRemarks;

    private Date updateTime;

}