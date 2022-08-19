package com.myProject.company.xyxx;

/**
 *
 * <p>
 * 功能: 实现16个线程分别打印A~P，编程实现调度这16个线程,屏幕循环打印10次A~P
 *
 */
public class ThreadCase {

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            Thread t = new Thread(new SleepPrint());
            t.start();
        }

    }

}

class SleepPrint implements Runnable {

    public static String[] array = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};

    public static int i = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" +array[i]);
        i++;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
