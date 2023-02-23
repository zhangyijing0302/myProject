package com.myProject.javaBase.juc.生产者消费者.sync;

/**
 * 线程之间的通讯问题
 */
public class ProductAndCustomer {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();

    }
}

/**
 * 使用while防止虚假唤醒
 *
 * 假设有两个线程A、B 调用生产者 两个线程C、D调用消费者
 * A线程调用生产者后num+1 然后可能会唤醒B线程继续调用生产者，此时num+1=1并且num!=0于是进入等待状态，
 * 由于if只判断一次 所以进入等待状态后会继续执行num++的操作 届时num=2 生产数量为2，生产过多，而每次消费为1 消费无法及时赶上生产 就会出现线程安全问题
 */
class Data {
    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        while (num != 0) {
            // 等待
            this.wait();
        }
        // 业务处理
        num++;
        System.out.println(Thread.currentThread().getName() + "->" + num);
        // 通知其他线程
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (num == 0) {
            // 等待
            this.wait();
        }
        // 业务处理
        num--;
        System.out.println(Thread.currentThread().getName() + "->" + num);
        // 通知其他线程
        this.notifyAll();
    }


}
