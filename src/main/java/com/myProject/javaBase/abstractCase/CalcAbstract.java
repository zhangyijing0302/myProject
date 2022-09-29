package com.myProject.javaBase.abstractCase;

import java.math.BigDecimal;

public abstract class CalcAbstract {

    public BigDecimal addOne() {
        BigDecimal calculator = this.calculator();
        return calculator.add(BigDecimal.ONE);
    }

    public abstract BigDecimal calculator();

    public abstract CalcEnum calcType();

}
