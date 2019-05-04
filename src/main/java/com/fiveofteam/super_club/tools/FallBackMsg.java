package com.fiveofteam.super_club.tools;


import java.util.HashMap;
import java.util.Map;

public enum FallBackMsg implements BaseEnum<FallBackMsg,String> {
    //注册失败！发生未知错误！
    SignFail("400","注册失败!"),
    SignOk("200","注册成功！");
    private String value;
    private String displayName;
    static Map<String,FallBackMsg> enumMap=new HashMap<>();
    static{
        for(FallBackMsg type:FallBackMsg.values()){
            enumMap.put(type.getValue(), type);
        }
    }
    public static FallBackMsg getEnum(String value) {
        return enumMap.get(value);
    }
     FallBackMsg(String value,String displayName) {
        this.value=value;
        this.displayName=displayName;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    @Override
    public String getDisplayName() {
        return displayName;
    }
    @Override
    public String getValue() {
        return value;
    }
    public String toString() {
        return this.value+"_"+this.displayName;
    }
}
