package com.myProject.javaBase.enumcase;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Objects;

public class TestCase {

    @Test
    public void test1() {
        System.out.println(SeasonEnum.SPRING.getCode());
        System.out.println(SeasonEnum.SPRING.getName());
        System.out.println(Objects.requireNonNull(SeasonEnum.getEnumByCode(SeasonEnum.SPRING.getCode())).getName());
    }

    @Test
    public void test2() {
        System.out.println(CurrencyEnum.getCodeByEnglish("CNY"));
    }

    @Test
    public void test3() {
        System.out.println(AbstractEnum.getWayToSchool("88"));
    }

    @Test
    public void test4() {
        System.out.println(FunctionEnum.getResultByInput("1", new BigDecimal("120")));
    }
}
