package com.myProject.javaBase.enumcase;

import java.math.BigDecimal;

@FunctionalInterface
public interface CalcMarginFunction<T> {

    BigDecimal result(T t);
}
