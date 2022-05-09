package com.randomProject.sourceCode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhangYijing
 * add         增加一个元索                      如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove   移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
 * element  返回队列头部的元素              如果队列为空，则抛出一个NoSuchElementException异常
 * offer       添加一个元素并返回true        如果队列已满，则返回false
 * poll         移除并返问队列头部的元素     如果队列为空，则返回null
 * peek       返回队列头部的元素              如果队列为空，则返回null
 * put         添加一个元素                       如果队列满，则阻塞
 * take        移除并返回队列头部的元素
 *
 *
 * 队列先进先出
 */
public class QueueCase {
    @Test
    public void test() {
        Queue<String> q = new LinkedList<>();
        q.add("a");
        q.add("b");
        q.add("c");
        q.add("d");
        q.add("e");
        q.offer("f");
        q.offer("g");
        q.offer("h");

        // remove() 和 poll() 方法都是从队列中删除第一个元素。如果队列元素为空，
        // 调用remove() 的行为与 Collection 接口的版本相似会抛出异常，
        // 但是新的 poll() 方法在用空集合调用时只是返回 null。因此 poll() 更适合容易出现异常条件的情况。
        String remove = q.remove();
        System.out.println(remove);
        String poll = q.poll();
        System.out.println(poll);

        // element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，
        // 在队列为空时， element() 抛出一个异常，而 peek() 返回 null。
        String element = q.element();
        System.out.println(element);
        String peek = q.peek();
        System.out.println(peek);
        System.out.println(q);
    }

    @Test
    public void queryCase() {
        Queue<String> s = new LinkedList<>();
        String element = s.element();
        String peek = s.peek();
    }
}