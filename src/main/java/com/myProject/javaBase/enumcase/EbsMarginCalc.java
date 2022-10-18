package com.myProject.javaBase.enumcase;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class EbsMarginCalc implements CaleWay {
    @Override
    public BigDecimal caleMargin() {
        return BigDecimal.TEN;
    }
}
