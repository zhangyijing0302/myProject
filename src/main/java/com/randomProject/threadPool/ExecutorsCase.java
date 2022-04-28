package com.randomProject.threadPool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Executors创建线程池
 * @author ZhangYijing
 */
public class ExecutorsCase {

    @Test
    public void test1() {
        // 创建固定大小的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // 创建只有一个线程的线程池
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        // 创建一个不限线程数上限的线程池，任何提交的任务都将立即执行
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        // 最大线程数为Integer最大值
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    }
}