package com.randomProject.temp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/25
 */
@Slf4j
public class Test01 {


    @Test
    public void test() {
        String str = "H";
        boolean b = false;
        Boolean aBoolean = Optional.ofNullable(str).map("H"::equals).orElse(false);
        System.out.println(aBoolean);
    }

    @Test
    public void test2() {
        int i = -100;
        System.out.println(~(i - 1));
    }


    @Test
    public void test3() {
        int i = 10;
        int length = 5;
        System.out.println(Math.pow(i, (length - 1)));

    }

    @Test
    public void test4() {
        BigDecimal bigDecimal = new BigDecimal("1.12345");

        System.out.println(bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP));

    }

    @Test
    public void test5() {
        String str = "abcdefghijk";

        System.out.println(str.substring(str.length() - 8));

    }

    @Test
    public void test6() {
        int n = 15;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int i = n + 1;
        System.out.println(i);
    }

    @Test
    public void test7() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);
    }

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1,2);
    }

    @Test
    public void test8() {
        Long ll = null;
        Long lb = 25666666L;
        System.out.println(ll < lb);
    }

}