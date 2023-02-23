package com.myProject.javaBase.juc.threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/28
 */
public class ThreadPoolUseCase {

    public static ThreadPoolExecutor getThreadPool(int size) {
        // 使用guava包中的ThreadFactoryBuilder工厂类指定线程组的名称，构建线程池工工厂
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(size, 10, 30, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(5), new ThreadFactory() {
            private final AtomicInteger atomicInteger = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "zhangyijing-threadPool-pool-" + atomicInteger.incrementAndGet());
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("队列满啦，而且线程数量达到最大数量啦！");
                try {
                    executor.getQueue().put(r);
                    System.out.println("卡住了嘛？");
                } catch (Exception e) {
                    System.out.println("塞入队列异常啦！");
                }
                System.out.println("塞进队列成功！");
            }
        });
        return threadPoolExecutor;
    }

    public static void work(ThreadPoolExecutor threadPool) {
        try{
            System.out.println("线程: " + Thread.currentThread().getName() + "进来啦！");
            System.out.println("当前队列的剩余容量:" + threadPool.getQueue().remainingCapacity());
            Thread.sleep(1000L);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = getThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> work(threadPool));
        }

    }
}