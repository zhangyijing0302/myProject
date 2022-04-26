package com.randomproject.temp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/25
 */
public class Test01 {

    public static final Logger log = LogManager.getLogger(Test01.class);

    @Test
    public void test() {
        log.info("info....");
        log.error("error....");
        log.warn("warning....");
        new HashMap<>();
        new ConcurrentHashMap<>();
    }

    public static void main(String[] args) {
        log.info("info....");
        log.error("error....");
        log.warn("warning....");
    }

}