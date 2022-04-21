package com.randomproject.reflex;

import com.randomproject.entity.Cat;

import java.lang.reflect.Constructor;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/21
 */
public class ReflexTest {

    public static void main(String[] args) throws Exception {
        Class<?> cat = Class.forName("com.randomproject.entity.Cat");
        Constructor<?> constructor = cat.getConstructor();
        Cat cat1 = (Cat) cat.newInstance();
        cat1.setName("aa");
        Cat cat2 = (Cat) constructor.newInstance();
        cat2.setName("bb");
        System.out.println(cat1);
        System.out.println(cat2);
    }
}