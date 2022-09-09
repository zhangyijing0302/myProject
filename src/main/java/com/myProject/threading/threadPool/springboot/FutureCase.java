package com.myProject.threading.threadPool.springboot;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author ZhangYijing
 * @Description
 * @date 2022/7/20
 */
public class FutureCase {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // int i = 1/0;
                    return "珍珠奶茶";
                });

        CompletableFuture<String> b = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "拜拜甜甜圈";
                });
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(a, b);
        System.out.println(a.get(1000, TimeUnit.SECONDS));
        System.out.println(b.get(1000, TimeUnit.SECONDS));
    }


}