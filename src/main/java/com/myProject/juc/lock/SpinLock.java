package com.myProject.juc.lock;


import com.myProject.mvc.entity.Student;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 不断的尝试 直到成功为止
 */
public class SpinLock {
    // 可以自动更新的对象引用
    AtomicReference<Student> atomicReference = new AtomicReference<>();
    Student stu = new Student();

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(() -> {
            spinLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {

            } finally {
                spinLock.myUnLock();
            }
        }, "T1").start();

        new Thread(() -> {
            spinLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {

            } finally {
                spinLock.myUnLock();
            }
        }, "T2").start();
    }
    /**
     * 加锁
     */
    public void myLock() {
        while (!atomicReference.compareAndSet(null, stu)) {
            //System.out.println(Thread.currentThread().getName() + "==> 旋转中");
        }
        System.out.println(Thread.currentThread().getName() + "==> lock");
    }

    /**
     * 解锁
     */
    public void myUnLock() {
        System.out.println(Thread.currentThread().getName() + "==> unlock");
        atomicReference.compareAndSet(stu, null);
    }
}
