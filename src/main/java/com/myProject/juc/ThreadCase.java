package com.myProject.juc;

/**
 * @author ZhangYijing
 * @Description 多线程
 * @Date 2022/4/28
 */
public class ThreadCase {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("子线程");
            }).start();
        }

        System.out.println("执行完毕");
    }
}