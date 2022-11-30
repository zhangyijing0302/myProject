package com.myProject.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 递归锁 可重入锁
 * 拿到外面的锁以后，里面的锁也自动获得
 */
public class RecursiveLock {
    ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        RecursiveLock recursiveLock = new RecursiveLock();
        /*===========================================Lock===============================================*/
        for (int i = 0; i < 2; i++) {
            new Thread(recursiveLock::eat, "线程" + i).start();
        }
        /*==============================================================================================*/
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
