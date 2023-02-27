package com.myProject.javaBase.juc.卖票;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTicket {

    private int number = 500;
    // 新建锁
    Lock lock = new ReentrantLock();

    // 卖票传统的方法
    public void sale() {
        // 加锁

//        boolean b = lock.tryLock();
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + number-- + "票，剩余" + number);
            } else {
                System.out.println(Thread.currentThread().getName() + "发现票已经卖完了");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }
}
