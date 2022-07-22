package com.randomProject.threadAndLock.threadPool.springboot;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangYijing
 * @Description
 * @date 2022/7/20
 */
@Service
@EnableAsync
public class AsyncManager {

    /**
     * 从Java 8开始引入了CompletableFuture，它针对Future做了改进，可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法
     * 最主要是可以提供复杂的
     * CompletableFuture可以指定异步处理流程：
     *     thenAccept()处理正常结果；
     *     exceptional()处理异常结果；
     *     thenApplyAsync()用于串行化另一个CompletableFuture；
     *     anyOf()和allOf()用于并行化多个CompletableFuture。
     * 详解请看 https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650
     * @param s
     * @return
     */
    @Async(value = "zyjAsyncPool")
    public CompletableFuture<String> transTaskForCompletableFuture(String s) {
        String result=null;
        try {
            result= s;
            System.out.println(Thread.currentThread().getName()+" 线程执行" + result);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(result);
    }

}