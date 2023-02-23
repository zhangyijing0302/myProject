package com.myProject.javaBase.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableCase {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        FutureTask<String> stringFutureTask = new FutureTask<>(new MyCallable());
        Thread thread1 = new Thread(stringFutureTask);
        thread1.start();
        Thread thread2 = new Thread(stringFutureTask); // 结果会被缓存
        thread2.start();
        // 有返回值，可以抛出异常，但是get方法可能会出现阻塞，因为要等待线程执行完毕
        String s = stringFutureTask.get();
        System.out.println(s);
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("aaa");
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("into callable");
        return "123";
    }
}
