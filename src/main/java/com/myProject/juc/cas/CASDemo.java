package com.myProject.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    // CAS compare and set 比较并交换
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        // public final boolean compareAndSet(int expect, int update)
        System.out.println(atomicInteger.compareAndSet(2021, 2022));
        System.out.println(atomicInteger.get());

        atomicInteger.getAndIncrement();
    }
}
