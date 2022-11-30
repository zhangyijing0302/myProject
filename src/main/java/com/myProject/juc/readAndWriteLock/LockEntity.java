package com.myProject.juc.readAndWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockEntity extends UnLockEntity {
    private final ReadWriteLock rw = new ReentrantReadWriteLock();
    private final Lock rl = rw.readLock();
    private final Lock wl = rw.writeLock();
    @Override
    public int get(){
        rl.lock();
        try{
            return super.get();
        }finally {
            rl.unlock();
        }
    }
    @Override
    public void add(){
        wl.lock();
        try{
            super.add();
        }finally{
            wl.unlock();
        }
    }

    public static void main(String[] args) {
        TestCase.test(new LockEntity());
    }
}
