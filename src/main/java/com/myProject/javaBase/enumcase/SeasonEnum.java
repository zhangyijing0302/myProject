package com.myProject.javaBase.enumcase;

import org.apache.commons.lang3.StringUtils;

/**
 * 编码枚举
 */
public enum SeasonEnum {
    SPRING("1", "春天"),
    SUMMER("2", "夏天"),
    AUTUMN("3", "秋天"),
    WINTER("4", "冬天");

    private final String code;
    private final String name;

    SeasonEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static SeasonEnum getEnumByCode(String code) {
        for (SeasonEnum value : values()) {
            if (StringUtils.equals(value.code, code)) {
                return value;
            }
        }
        return null;
    }
}
