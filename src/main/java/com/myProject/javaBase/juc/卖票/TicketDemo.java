package com.myProject.javaBase.juc.卖票;


public class TicketDemo {

    public static void main(String[] args) {
        // 创建一个资源类，把资源类放进线程中
        SynchronizedTicket ticket = new SynchronizedTicket();
        new Thread(() -> {
            for (int i = 0; i < 600; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 600; i++) {
            ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 600; i++) {
            ticket.sale();
            }
        }, "C").start();

        // 创建一个资源类，把资源类放进线程中
        LockTicket ticketLock = new LockTicket();
        new Thread(() -> {
            for (int i = 0; i < 600; i++) {
                ticketLock.sale();
            }
        }, "E").start();
        new Thread(() -> {
            for (int i = 0; i < 600; i++) {
                ticketLock.sale();
            }
        }, "F").start();
        new Thread(() -> {
            for (int i = 0; i < 600; i++) {
                ticketLock.sale();
            }
        }, "G").start();
    }

}

