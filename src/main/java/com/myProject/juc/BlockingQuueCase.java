package com.myProject.juc;

import org.junit.Test;

import java.util.concurrent.*;

public class BlockingQuueCase {

    public static void main(String[] args) {
        BlockingQueue array = new ArrayBlockingQueue(1);
        BlockingQueue licked = new LinkedBlockingQueue();
        BlockingQueue sync = new SynchronousQueue();

        test5();

    }

    /**
     * 会抛出异常 add remove
     */
    @Test
    public void test1() {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.element()); // 获取第一个元素
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

    }

    /**
     * 不跑出异常的队列 offer poll
     */
    @Test
    public void test2() {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d")); // false
        System.out.println(blockingQueue.peek()); //  获取第一个元素 a
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll()); // null
    }

    /**
     * 等待阻塞，一直等待 put take
     */
    @Test
    public void test3() throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d"); 一直等待
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    /**
     * 等待阻塞，超时等待 offer poll 带等待时间参数
     */
    @Test
    public void test4() throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d", 2, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
    }

    /**
     * 同步队列, 不存储元素，
     */
    public static void test5() {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " T1 first put a");
                synchronousQueue.put("a");
                System.out.println(Thread.currentThread().getName() + " T1 second put b");
                synchronousQueue.put("b");
                System.out.println(Thread.currentThread().getName() + " T1 third put c");
                synchronousQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " get first " + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " get second " + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " get third " + synchronousQueue.take());
            } catch (InterruptedException e) {

            }
        }, "T2").start();
    }

}
