package com.myProject.threading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhangYijing
 *  可重入锁：
 *  在外层使用锁之后，在内层仍然可以使用，并且不发生死锁（前提得是同一个对象或者class），这样的锁就叫做可重入锁。
 *  ReentrantLock
 *  实现可重入的关键是静态内部类sync 里面维护了一个int state 每内部加一次锁就+1 解锁一次就 -1  等于0的时候线程处于无锁状态
 */
public class ReentrantLockCase implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    public void get() {
        //第一个断点打再这  state 0->1 由无锁转入有锁
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId());
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //state 由1->0 至此同一线程的锁变成无锁状态
            lock.unlock();
        }

    }

    public void set() {
        //第二个断点打在这 state 1->2
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId());
            doubleSet();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 2 -> 1
            lock.unlock();
        }

    }

    public void doubleSet() {
        //第二个断点打在这 state 2 -> 3
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3  - > 2
            lock.unlock();
        }
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReentrantLockCase ss = new ReentrantLockCase();
        new Thread(ss).start();
        //new Thread(ss).start();
        //new Thread(ss).start();
    }


    public void unReentrantCase() {

    }
}