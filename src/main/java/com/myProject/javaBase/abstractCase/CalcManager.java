package com.myProject.javaBase.abstractCase;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CalcManager implements ApplicationContextAware {

    public static Map<CalcEnum, CalcAbstract> ruleMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, CalcAbstract> dividendsRuleMap = applicationContext.getBeansOfType(CalcAbstract.class);
        dividendsRuleMap.values().forEach(rule -> {
            ruleMap.put(rule.calcType(), rule);
        });
    }


    public BigDecimal calc() {
        BigDecimal result = BigDecimal.ZERO;
        for (Map.Entry<CalcEnum, CalcAbstract> calcEnumCalcManagerEntry : ruleMap.entrySet()) {
            CalcAbstract calcImplement = calcEnumCalcManagerEntry.getValue();
            BigDecimal value = calcImplement.addOne();
            result = result.add(value);
        }
        return result;
    }

}
