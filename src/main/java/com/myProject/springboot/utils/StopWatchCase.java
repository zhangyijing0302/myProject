package com.myProject.springboot.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangYijing
 * @Date 2022/5/12
 */
@Slf4j
public class StopWatchCase {
    public static void main(String[] args) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start("任务1");
        TimeUnit.SECONDS.sleep(1);
        watch.stop();
        watch.start("任务2");
        TimeUnit.SECONDS.sleep(2);
        watch.stop();
        log.info("上一个任务执行的纳秒 " + watch.getLastTaskTimeNanos());
        log.info("打印总纳妙 " + watch.shortSummary()); // running time = 2019142800 ns
        log.info("打印上一个任务的执行时间毫秒 " + watch.getLastTaskTimeMillis()); // 1015
        log.info("打印总耗时毫秒 " + watch.getTotalTimeMillis()); // 1015
        log.info("打印总耗时秒 " + watch.getTotalTimeSeconds()); // 1015
        // prettyPrint() 优雅的格式打印结果，表格形式
        log.info("打印一个纳米表格 " + watch.prettyPrint());
        // shortSummary() 返回简短的总耗时描述
        log.info("===================================================================");
        MyWatch myWatch = new MyWatch();
        myWatch.start("任务1");
        TimeUnit.SECONDS.sleep(1);
        myWatch.stop();
        myWatch.start("任务2");
        TimeUnit.SECONDS.sleep(2);
        myWatch.stop();
        log.info("上一个任务执行的纳秒 " + myWatch.getLastTaskTimeNanos());
        log.info("打印总纳妙 " + myWatch.shortSummary()); // running time = 2019142800 ns
        log.info("打印上一个任务的执行时间毫秒 " + myWatch.getLastTaskTimeMillis()); // 1015
        log.info("打印总耗时毫秒 " + myWatch.getTotalTimeMillis()); // 1015
        log.info("打印总耗时秒 " + myWatch.getTotalTimeSeconds()); // 1015
        // prettyPrint() 优雅的格式打印结果，表格形式
        log.info("打印一个毫秒表格 " + myWatch.prettyPrint());
        // getTotalTimeSeconds() 获取总耗时秒，同时也有获取毫秒的方法
    }
}