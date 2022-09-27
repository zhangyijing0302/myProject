package com.myProject.middleware.redis;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class RedissonLock {
    private static volatile int count = 1000;

    public static void main(String[] args) {

//        CyclicBarrier cyclicBarrier = new CyclicBarrier(1000, () -> {
//            System.out.println("召唤神龙");
//        });
        String key = "zhangyijing";
        for (int i = 0; i < 1000; i++) {
            final int j = i;
            new Thread(() ->  {
                LockManager.addLock(key);
                count--;
                System.out.println("第" + j + "次的结果：" + count);
                LockManager.unLock(key);
//                try {
//                    cyclicBarrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
            }).start();
        }
    }
}
