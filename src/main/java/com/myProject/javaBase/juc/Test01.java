package com.myProject.javaBase.juc;

import org.junit.Test;

public class Test01 {
    @Test
    public void test01() throws InterruptedException {
        // 获取CPU核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        //


        Thread.State.values();

        new Thread().wait();
        Thread.sleep(100);
    }

    @Test
    public void test02() {

    }
}
