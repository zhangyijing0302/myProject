package com.myProject.juc.readAndWriteLock;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class CommonMethod {
    private static AtomicLong UNIQ_ID = new AtomicLong();
    public static void sleep(long time){
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void log(String log){
        System.out.println(new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS").format(new Date())+ "  "+ Thread.currentThread().getName() + "  " + log);
    }

    public static void start(Collection<Thread> threads){
        threads.forEach(Thread::start);
    }

    public static void join(Thread thread){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void join(Collection<Thread> threads){
        threads.forEach(CommonMethod::join);
    }


    public static int randomInt(int high){
        return new Random().nextInt(high);
    }

    public static Long getUniqId(){
        return UNIQ_ID.getAndIncrement();
    }
}
