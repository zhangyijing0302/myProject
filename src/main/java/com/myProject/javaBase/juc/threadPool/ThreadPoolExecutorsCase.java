package com.myProject.javaBase.juc.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * alibaba不建议用Executors创建线程池是因为
 * newSingleThreadExecutor、newFixedThreadPool 单线程线程池和固定大小线程池会堆积大量的请求
 * newCachedThreadPool 允许创建的线程池数量是Integer。MAX_VALUE，会堆积大量线程
 * 都会导致OOM
 *
 * 手动创建线程池
 * Executors工具类创建的线程池本质上是通过ThreadPoolExecutor来创建的
 * ThreadPoolExecutor 有七个参数
 * @author ZhangYijing
 */
public class ThreadPoolExecutorsCase {



    public static void main(String[] args) {
        // 使用guava包中的ThreadFactoryBuilder工厂类指定线程组的名称，构建线程池工工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("zhangyijing-threadPool-pool-").build();
        // 最大承载量是队列长度 + 最大核心线程数
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                5,
                3, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());


//        while(i < 100) {
//            threadPoolExecutor.execute(new ThreadInPool());
//        }
        CountDownLatch countDownLatch = new CountDownLatch(threadPoolExecutor.getMaximumPoolSize());
        ThreadInPoolResource resource = new ThreadInPoolResource();
        for (int j = 0; j < threadPoolExecutor.getMaximumPoolSize(); j++) {
            threadPoolExecutor.execute(() -> {
                try {
                    resource.sale();
                    resource.poll();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
        System.out.println(threadPoolExecutor.getLargestPoolSize());
        System.out.println("结束");

        // 三种线程池提交任务的方式submit(Callable<T> task)、execute(Runnable command)、submit(Runnable task)
//        threadPoolExecutor.submit()
//        threadPoolExecutor.execute();

    }

//    public ThreadPoolExecutor(int corePoolSize, // 线程池长期维持的线程数，即使线程处于Idle状态，也不会回收。
//                              int maximumPoolSize, // 线程数的上限
//                              long keepAliveTime, // 超过corePoolSize的线程的idle时长，超过这个时间，多余的线程会被回收。
//                              TimeUnit unit, // 时间单位
//                               <Runnable> workQueue, // // 任务的排队队列
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

class ThreadInPoolResource {

    public int i = 0;

    public synchronized void sale() {
        while (i < 5) {
            System.out.println(Thread.currentThread().getName() + " input in " + i++);
        }
    }

    public synchronized void poll() {
        while (i > 0) {
            System.out.println(Thread.currentThread().getName() + " input out " + --i);
        }
    }
}