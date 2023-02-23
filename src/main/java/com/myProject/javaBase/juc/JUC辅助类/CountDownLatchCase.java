package com.myProject.javaBase.juc.JUC辅助类;

import java.util.concurrent.CountDownLatch;

// 计数器 - 1
public class CountDownLatchCase {
    public static void main(String[] args) throws InterruptedException {
        // 参数是初始值
        CountDownLatch countDownLatch = new CountDownLatch(8);

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "-- go out");
                countDownLatch.countDown();
            }).start();
        }
        // 主程序进入等待，等待计数器归0后继续向下执行
        countDownLatch.await();
        System.out.println("走光了");
    }
}
