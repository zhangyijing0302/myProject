package com.myProject.javaBase.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 * 1、互斥条件：一个资源每次只能被一个进程使用；
 * 2、请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放；
 * 3、不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺；
 * 4、循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系；
 *
 * 工具查看死锁：
 * jps -l 查看进程号
 * jstack 进程号
 *              Java stack information for the threads listed above:
 *              ===================================================
 *              "T2":
 *                      at com.myProject.javaBase.juc.lock.DeadLock.run(DeadLock.java:34)
 *                      - waiting to lock <0x0000000740f17a00> (a java.lang.String)
 *                      - locked <0x0000000740f17a30> (a java.lang.String)
 *                      at java.lang.Thread.run(Thread.java:748)
 *              "T1":
 *                      at com.myProject.javaBase.juc.lock.DeadLock.run(DeadLock.java:34)
 *                      - waiting to lock <0x0000000740f17a30> (a java.lang.String)
 *                      - locked <0x0000000740f17a00> (a java.lang.String)
 *                      at java.lang.Thread.run(Thread.java:748)
 *
 *              Found 1 deadlock.
 * windows杀死进程
 * taskkill /F /pid 97240
 */
public class DeadLock implements Runnable{
    private final String lock1;
    private final String lock2;

    public DeadLock(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "线程持有" + lock1 + "锁，想要获取" + lock2 + "锁");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "两个都拿到");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new DeadLock("A", "B"), "T1").start();
        new Thread(new DeadLock("B", "A"), "T2").start();
    }
}
