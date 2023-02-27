package com.myProject.javaBase.juc.卖票;


public class SynchronizedTicket {

    private int number = 500;

    // 卖票传统的方法
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + number-- + "票，剩余" + number);
        } else {
            System.out.println(Thread.currentThread().getName() + "发现票已经卖完了");
        }
    }
}
