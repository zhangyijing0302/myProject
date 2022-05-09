package com.randomProject.threadAndLock;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 8锁问题
 * 1.标准情况下，先打印发消息还是先打印打电话？ 先发消息
 * 2.synchronized锁的是方法的调用者，谁先拿到谁先执行
 */
public class Lock8 {

    @Test
    public void testPhone1() {
        Phone phone = new Phone();
        new Thread(phone::sendMsg, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }
        // 1.标准情况下，先打印发消息还是先打印打电话？ 先发消息
        // 2.synchronized锁的是方法的调用者，谁先拿到谁先执行
        new Thread(phone::call, "B").start( );
    }

    @Test
    public void testPhone2() {
        Phone phone = new Phone();
        new Thread(phone::sendMsg, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }

        new Thread(phone::call, "B").start();
        new Thread(phone::say, "C").start();
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(phone::sendMsg, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }

//        new Thread(phone::call, "B").start();
        new Thread(phone::say, "C").start();
    }
}

class Phone {
    // synchronized 锁的是方法的调用者
    // 加static修饰后，锁的就是class模板 全局唯一
    public synchronized void sendMsg() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {

        }
        System.out.println("sendMsg");
    }

    public synchronized void call() {
        System.out.println("call");
    }

    public void say() {
        System.out.println("Hello");
    }
}