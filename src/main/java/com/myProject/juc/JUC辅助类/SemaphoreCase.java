package com.myProject.juc.JUC辅助类;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 1.多个资源共享
 * 2.限流，控制最大线程数量
 */
public class SemaphoreCase {
    public static void main(String[] args) {
        // 参数表示线程数量， 可以做限流
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < 28; i++) {
            new Thread(() -> {
                try {
                    // 拿到信号量
                    semaphore.acquire(); // 得到
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // +1 释放当前信号量
                    semaphore.release();
                }
            }, i + "线程").start();
        }
    }
}
