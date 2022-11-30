package com.myProject.juc.lock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

/**
 * public ReentrantLock() {
 *      sync = new ReentrantLock.NonfairSync();
 * }
 * 默认非公平锁
 * ReentrantLock reentrantLock = new ReentrantLock();
 */
public class UnFairLock {
    ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        /*======================================Synchronized============================================*/
        // 传统的Synchronized就是非公平锁
        UnFairLock unFairLock = new UnFairLock();
        for (int i = 0; i < 2; i++) {
            new Thread(unFairLock::sms, "线程" + i).start();
        }
        /*==============================================================================================*/
        /*===========================================Lock===============================================*/
        for (int i = 0; i < 2; i++) {
            new Thread(unFairLock::eat, "线程" + i).start();
        }
        /*==============================================================================================*/
    }

    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName() + ">>sms");
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + ">>call");
    }

    /**
     * 锁必须配对，否则会死在里面
     */
    public void eat() {
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ">>eat");
            shit();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * 锁必须配对，否则会死在里面
     */
    public void shit() {
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ">>shit");
        } finally {
            reentrantLock.unlock();
        }
    }
}


