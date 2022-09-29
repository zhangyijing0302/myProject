package com.myProject.javaBase.abstractCase;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalcMethod1 extends CalcAbstract {
    @Override
    public BigDecimal calculator() {
        return BigDecimal.ONE;
    }

    @Override
    public CalcEnum calcType() {
        return CalcEnum.METHOD1;
    }
}
