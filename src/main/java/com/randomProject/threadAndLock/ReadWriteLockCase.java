package com.randomProject.threadAndLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 */
public class ReadWriteLockCase {
    public static void main(String[] args) {
        MyCacheLock cache = new MyCacheLock();
        for (int i = 1; i < 5; i++) {
            final int fi = i;
            new Thread(() -> {
                cache.put(fi + "", fi);
            }, "线程" + fi).start();
        }
        for (int i = 1; i < 5; i++) {
            final int fi = i;
            new Thread(() -> {
                cache.get(fi + "");
            }, "线程" + fi).start();
        }

    }
}

/**
 * 自定义缓存
 */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();



    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "线程写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "线程写入完毕");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "线程读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "线程读取结果" + o);
    }
}

/**
 * 自定义缓存
 */
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    // 读写锁，更加细粒度的控制
    ReadWriteLock lock =  new ReentrantReadWriteLock();

    /**
     * 写入的时候是一个原子性的操作，写入的过程中不允许别人插入（独占锁）
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "线程写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "线程写入完毕");
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * 写的时候不允许读，读的时候其他人也可以读（共享锁）
     * @param key
     */
    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "线程读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "线程读取结果" + o);
        } finally {
            lock.readLock().unlock();
        }

    }
}
