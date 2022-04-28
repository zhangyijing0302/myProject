package com.randomProject.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 手动创建线程池
 * @author ZhangYijing
 */
public class ThreadPoolExecutorsCase {
    public static void main(String[] args) {
        // 使用guava包中的ThreadFactoryBuilder工厂类指定线程组的名称，构建线程池工工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("zhangyijing-threadPool-pool-d%").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        // 三种线程池提交任务的方式submit(Callable<T> task)、execute(Runnable command)、submit(Runnable task)
//        threadPoolExecutor.submit()
//        threadPoolExecutor.execute();

    }

//    public ThreadPoolExecutor(int corePoolSize, // 线程池长期维持的线程数，即使线程处于Idle状态，也不会回收。
//                              int maximumPoolSize, // 线程数的上限
//                              long keepAliveTime, // 超过corePoolSize的线程的idle时长，超过这个时间，多余的线程会被回收。
//                              TimeUnit unit, // 时间单位
//                              BlockingQueue<Runnable> workQueue, // // 任务的排队队列
//                              ThreadFactory threadFactory, // 新线程的产生方式
//                              RejectedExecutionHandler handler) { // 拒绝策略 AbortPolicy、CallerRunsPolicy、DiscardOldestPolicy、DiscardPolicy 【new ThreadPoolExecutor.CallerRunsPolicy()】
//        if (corePoolSize < 0 ||
//                maximumPoolSize <= 0 ||
//                maximumPoolSize < corePoolSize ||
//                keepAliveTime < 0)
//            throw new IllegalArgumentException();
//        if (workQueue == null || threadFactory == null || handler == null)
//            throw new NullPointerException();
//        this.acc = System.getSecurityManager() == null ?
//                null :
//                AccessController.getContext();
//        this.corePoolSize = corePoolSize;
//        this.maximumPoolSize = maximumPoolSize;
//        this.workQueue = workQueue;
//        this.keepAliveTime = unit.toNanos(keepAliveTime);
//        this.threadFactory = threadFactory;
//        this.handler = handler;
//    }
}