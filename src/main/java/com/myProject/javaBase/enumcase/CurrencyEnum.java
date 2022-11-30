package com.myProject.javaBase.enumcase;

import org.apache.commons.lang3.StringUtils;

/**
 * 业务枚举
 */
public enum CurrencyEnum {
    CNY("1", "人民币", "CNY"),
    USD("2", "美元", "USD"),
    HKD("3", "港币", "HDK"),
    EUR("4", "欧元", "EUR");

    private final String code;
    private final String name;

    private final String englishName;

    CurrencyEnum(String code, String name, String englishName) {
        this.code = code;
        this.name = name;
        this.englishName = englishName;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getCodeByEnglish(String englishName) {
        for (CurrencyEnum value : values()) {
            if (StringUtils.equals(value.englishName, englishName)) {
                return value.code;
            }
        }
        return null;
    }
}
