package com.myProject.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Aba {
    public static void main(String[] args) {
        // AtomicStampedReference维护一个对象引用以及一个整数“stamp”，可以原子地更新。
        // 初始值， 初始版本戳
        AtomicStampedReference<Integer> i = new AtomicStampedReference<>(12, 1);
        new Thread(() -> {
            int stamp = i.getStamp();
            System.out.println("a1version>>:" + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i.compareAndSet(12, 15, i.getStamp(), i.getStamp() + 1);
            i.compareAndSet(15, 16, i.getStamp(), i.getStamp() + 1);
            System.out.println("a2version>>" + i.getReference());
        }, "a").start();
        new Thread(() -> {
            int stamp = i.getStamp();
            System.out.println("b1version>>:" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i.compareAndSet(12, 18, stamp, stamp + 1);
            System.out.println("b2version>>" + i.getReference());
        }, "b").start();
    }
}
