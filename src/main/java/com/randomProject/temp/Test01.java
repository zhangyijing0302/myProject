package com.randomProject.temp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
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

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1,2);
    }

}