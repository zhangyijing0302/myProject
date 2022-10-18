package com.myProject.javaBase.enumcase;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BbcMarginCalc implements CaleWay {
    @Override
    public BigDecimal caleMargin() {
        return BigDecimal.ONE;
    }
}
