package com.myProject.javaBase.juc.arraySet;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentModificationException
 * 解决方案：
 *
 *
 *
 */
public class UnSelfMap {

    public transient int 转瞬即逝的变量反序列化后得不到 = 0;

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        // map
        HashMap<Object, Object> hashMap = Maps.newHashMapWithExpectedSize(12);
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                hashMap.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
                System.out.println(hashMap);
            }, "Thread" + i).start();
        }
    }
}
