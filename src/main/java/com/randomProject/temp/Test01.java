package com.randomProject.temp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/25
 */
@Slf4j
public class Test01 {


    @Test
    public void test() {
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        if (log.isDebugEnabled()) {
            log.debug("aaa");
        }
        log.debug("de....");
        log.info("info....");
        log.error("error1....");
        log.error("error2....");
        log.warn("warning....");
    }

}