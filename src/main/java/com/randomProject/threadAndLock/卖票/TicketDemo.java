package com.randomProject.threadAndLock.卖票;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketDemo {

    public static void main(String[] args) {
        // 创建一个资源类，把资源类放进线程中
        Ticket2 ticket = new Ticket2();
        new Thread(() -> {
            for (int i = 0; i < 600; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 600; i++) {
            ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 600; i++) {
            ticket.sale();
            }
        }, "C").start();
    }

}

// 资源类
class Ticket {
    private int number = 500;



    // 卖票传统的方法
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + number-- + "票，剩余" + number);
        }
    }
}
// 资源类 Lock锁三步实现
class Ticket2 {
    private int number = 500;
    // 新建锁
    Lock lock = new ReentrantLock();

    // 卖票传统的方法
    public void sale() {
        // 加锁
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + number-- + "票，剩余" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }
}
