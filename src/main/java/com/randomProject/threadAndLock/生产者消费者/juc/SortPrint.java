package com.randomProject.threadAndLock.生产者消费者.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SortPrint {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }, "AThread").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }, "BThread").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }, "CThread").start();

    }
}

/**
 * Condition 精准的通知和唤醒线程
 */
class Data3 {
    private int num = 1;

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    public void printA() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "print:A");
            num++;
            condition2.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void printB() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "print:B");
            num++;
            condition3.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {

            while (num != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "print:C");
            num = 1;
            condition1.signal();
        } catch (Exception e) {


        } finally {
            lock.unlock();
        }
    }

}
