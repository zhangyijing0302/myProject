package com.randomProject.threadAndLock.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ConcurrentModificationException
 * 多线程情况下边读边写会抛出异常
 * 并发情况下ArrayList是不安全的
 * 解决方案
 * 1.List<String> list = new Vector<>();
 * 2. Collections.synchronizedList(new ArrayList<>());
 * 3.new CopyOnWriteArrayList<>(); CopyOnWrite写入时复制，多个线程调用的时候，list在读取的时候 是固定的，但写入的时候可能存在一种覆盖操作，
 */
public class unSelfList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, "Thread" + i).start();
        }

        List<Object> objects = Collections.synchronizedList(new ArrayList<>());

        List<Object> objects1 = new CopyOnWriteArrayList<>();
    }
}
