package com.myProject.javaBase.abstractCase;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalcMethod2 extends CalcAbstract {
    @Override
    public BigDecimal calculator() {
        return BigDecimal.TEN;
    }

    @Override
    public CalcEnum calcType() {
        return CalcEnum.METHOD2;
    }
}
