package com.myProject.threading.arraySet;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ConcurrentModificationException
 * 多线程情况下边读边写会抛出异常
 * 并发情况下ArrayList是不安全的
 * 解决方案
 * 1.List<String> list = new Vector<>();
 * 2. Collections.synchronizedList(new ArrayList<>());
 * 3.new CopyOnWriteArrayList<>(); CopyOnWrite写入时复制，多个线程调用的时候，list在读取的时候 是固定的，但写入的时候可能存在一种覆盖操作，
 * @author admin
 */
public class UnSelfList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
            }, "Thread" + i);
            thread.start();
            thread.join();
        }
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(list);
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());

        CopyOnWriteArrayList<Object> copyList = new CopyOnWriteArrayList<>();
        copyList.add("11");

        ListIterator<Object> objectListIterator = copyList.listIterator();
        // UnsupportedOperationException 实现了ListIterator接口需要重写add方法，但是又不支持这个操作
        objectListIterator.add("sss");

    }
}
