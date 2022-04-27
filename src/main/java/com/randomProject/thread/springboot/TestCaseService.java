package com.randomProject.thread.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 多线程测试类
 * @author ZhangYijing
 */
@Slf4j
@Service
public class TestCaseService {

    @Async("zyjAsyncPool")
    public void letNumAddOne() {
        try {
            Thread.sleep(5000);
            System.out.println("currentThread:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}