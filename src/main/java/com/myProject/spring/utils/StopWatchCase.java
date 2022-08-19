package com.myProject.spring.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * @author ZhangYijing
 * @Date 2022/5/12
 */
@Slf4j
public class StopWatchCase {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        // prettyPrint() 优雅的格式打印结果，表格形式
        log.info("优雅{}", watch.prettyPrint());
        // shortSummary() 返回简短的总耗时描述
        log.info("shortSummary(" + watch.shortSummary());
        // getTaskCount() 返回统计时间任务的数量

        // getTotalTimeSeconds() 获取总耗时秒，同时也有获取毫秒的方法
    }
}