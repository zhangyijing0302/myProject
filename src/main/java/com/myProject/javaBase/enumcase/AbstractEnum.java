package com.myProject.javaBase.enumcase;

import org.apache.commons.lang3.StringUtils;

/**
 * 业务枚举
 */
public enum AbstractEnum {
    MALE("1") {
        @Override
        public String goToSchool() {
            return "走路";
        }
    },
    FEMALE("2") {
        @Override
        public String goToSchool() {
            return "公交";
        }
    },
    KATEY("3") {
        @Override
        public String goToSchool() {
            return "飞机";
        }
    };

    ;
    private final String code;
    public abstract String goToSchool();

    AbstractEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static String getWayToSchool(String code) {
        for (AbstractEnum value : values()) {
            if (StringUtils.equals(value.code, code)) {
                return value.goToSchool();
            }
        }
        return null;
    }
}
