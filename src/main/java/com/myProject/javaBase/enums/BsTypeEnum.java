package com.myProject.javaBase.enums;

public enum BsTypeEnum {

    BUY("B", "买入"),
    SELL("C", "卖出");

    String code;
    String desc;

    BsTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
