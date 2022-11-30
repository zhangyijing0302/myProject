package com.myProject.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock {
    public static void main(String[] args) {
//        public ReentrantLock(boolean fair) {
//            sync = fair ? new ReentrantLock.FairSync() : new ReentrantLock.NonfairSync();
//        }
        // 构造参数指定true创建公平锁
        ReentrantLock reentrantLock = new ReentrantLock(true);
    }
}
