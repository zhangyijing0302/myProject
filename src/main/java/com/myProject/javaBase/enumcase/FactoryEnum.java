package com.myProject.javaBase.enumcase;

import com.myProject.springboot.utils.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * 工厂枚举
 */
public enum FactoryEnum {
    EBS("ebs", EbsMarginCalc.class),
    BBC("bbc", BbcMarginCalc.class);

    private final String type;
    private final Class<?> className;

    FactoryEnum(String type, Class<?> className) {
        this.type = type;
        this.className = className;
    }

    public String getType() {
        return type;
    }

    public Class<?> getClassName() {
        return className;
    }

    public static CaleWay getServiceByType(String type) {
        for (FactoryEnum value : values()) {
            if (StringUtils.equals(value.type, type)) {
                return (CaleWay) SpringContextUtil.getBean(value.getClassName());
            }
        }
        return null;
    }
}
