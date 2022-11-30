package com.myProject.javaBase.enumcase;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * 业务枚举
 */
public enum FunctionEnum {
    TEN("1", BigDecimal.TEN::add),
    ONE("2", BigDecimal.ONE::add),
    ZREO("3", BigDecimal.ZERO::add);

    ;

    private final String code;
    public final CalcMarginFunction<BigDecimal> function;

    FunctionEnum(String code, CalcMarginFunction<BigDecimal> function) {
        this.code = code;
        this.function = function;
    }

    public String getCode() {
        return code;
    }

    public static BigDecimal getResultByInput(String code, BigDecimal input) {
        for (FunctionEnum value : values()) {
            if (StringUtils.equals(value.code, code)) {
                return value.function.result(input);
            }
        }
        return BigDecimal.ZERO;
    }
}
