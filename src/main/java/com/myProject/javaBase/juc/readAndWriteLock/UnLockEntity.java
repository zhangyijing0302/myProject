package com.myProject.javaBase.juc.readAndWriteLock;


public class UnLockEntity {
    public static final int MAX = 2;

    public int value;

    int get() {
        return value;
    }

    void add() {
        value++;
        CommonMethod.sleep(100);
        if (value > MAX) {
            value = 0;
        }
    }

    public static void main(String[] args) {
        TestCase.test(new UnLockEntity());
    }

}
