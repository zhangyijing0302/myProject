package com.myProject.threading.java.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinTest {

    public static void main(String[] args) {
        test2();
    }

    /**
     * 结果500000000500000000耗时：8108
     */
    public static void test1() {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long j = 0L; j <= 10_0000_0000; j++) {
            sum+=j;
        }
        long end = System.currentTimeMillis();
        System.out.println("结果" + sum + "耗时：" + (end - start));
    }

    /**
     * 结果500000000500000000耗时：349
     */
    public static void test2() {
        long start = System.currentTimeMillis();
        long sum = 0L;
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //forkJoinPool.execute();
        long end = System.currentTimeMillis();
        System.out.println("结果" + sum + "耗时：" + (end - start));
    }

    /**
     * 结果500000000500000000耗时：349
     */
    public static void test3() {
        long start = System.currentTimeMillis();
        // parallel 并行
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("结果" + sum + "耗时：" + (end - start));
    }
}
