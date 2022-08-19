package com.myProject.exception;

import org.junit.Test;

/**
 * @author ZhangYijing
 * @Description 去过try块在for循环之内的话，如果catch不抛出异常整个for循环是可以循环完的
 * @Date 2022/5/19
 */
public class TryInForCase {

    @Test
    public void test1() throws Exception {
        int i = 0;
        for (; i < 10000000; i++) {
            try {
                if (i == 5) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("hehehe");
                throw new Exception("hehehe");
            }
        }
        System.out.println(i);
    }

    @Test
    public void test2() {
        int i = 0;
        try {
            for (; i < 10; i++) {
                if (i == 5) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("hehehe");
        }
        System.out.println(i);
    }

}