package com.myProject.juc.threadPool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Executors创建线程池 的 三大方法
 * @author ZhangYijing
 */
public class ExecutorsCase {

    public static void main(String[] args) {
        // 创建只有一个线程的线程池
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        // 使用线程池创建线程
//        try {
//            for (int i = 0; i < 10; i++) {
//                singleThreadPool.execute(() -> {
//                    System.out.println(Thread.currentThread().getName() + "input");
//                });
//            }
//        } catch (Exception e) {
//
//        } finally {
//            // 线程池使用完毕要关闭资源
//            singleThreadPool.shutdown();
//        }

        System.out.println("----------------------------------------");

        // 创建固定大小的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // 使用线程池创建线程
        try {
            for (int i = 0; i < 10; i++) {
                fixedThreadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "input");
                });
            }
        } catch (Exception e) {

        } finally {
            // 线程池使用完毕要关闭资源
            fixedThreadPool.shutdown();
        }

        // 创建一个不限线程数上限的线程池，任何提交的任务都将立即执行
        // 遇强则强
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    }

    @Test
    public void test1() {
//       源码分析
//        public static ExecutorService newSingleThreadExecutor() {
//            return new Executors.FinalizableDelegatedExecutorService
//                    (new ThreadPoolExecutor(1, 1,
//                            0L, TimeUnit.MILLISECONDS,
//                            new LinkedBlockingQueue<Runnable>()));
//        }
//
//        public static ExecutorService newFixedThreadPool(int nThreads) {
//            return new ThreadPoolExecutor(nThreads, nThreads,
//                    0L, TimeUnit.MILLISECONDS,
//                    new LinkedBlockingQueue<Runnable>());
//        }
//
//        public static ExecutorService newCachedThreadPool() {
//            return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                    60L, TimeUnit.SECONDS,
//                    new SynchronousQueue<Runnable>());
//        }
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "input");
    }
}