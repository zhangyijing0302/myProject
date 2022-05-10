package com.randomProject.threadAndLock.array;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ZhangYijing
 * CopyOnWriteArrayList 写入时复制
 */
public class CopyOnWriteArrayListCase {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("a");
    }
}