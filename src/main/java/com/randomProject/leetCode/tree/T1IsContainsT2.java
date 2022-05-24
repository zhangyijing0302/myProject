package com.randomProject.leetCode.tree;

import com.randomProject.entity.BinaryTreeNode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ZhangYijing
 * @Description 判断 t1 树是否有与 t2 树拓扑结构完全相同的子树
 * @Date 2022/5/16
 */
public class T1IsContainsT2 {

    public static void main(String[] args) {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock lock = rwLock.readLock();
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }
        Lock lock1 = rwLock.writeLock();
    }

    public boolean isContains(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null) {
            return false;
        }
        return check(t1, t2) || isContains(t1.left, t2) || isContains(t1.right, t2);
    }

    public boolean check(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.value == t2.value && check(t1.left, t2.left) && check(t1.right, t2.right);
    }

}