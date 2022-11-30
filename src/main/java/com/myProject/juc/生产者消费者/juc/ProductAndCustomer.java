package com.myProject.juc.生产者消费者.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductAndCustomer {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                data.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "D").start();
    }
}

/**
 * Condition 精准的通知和唤醒线程
 */
class Data2 {
    private int num = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            // 业务处理
            num++;
            System.out.println(Thread.currentThread().getName() + "->" + num);
            // 通知其他线程
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void decrement() {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            // 业务处理
            num--;
            System.out.println(Thread.currentThread().getName() + "->" + num);
            // 通知其他线程
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


}
