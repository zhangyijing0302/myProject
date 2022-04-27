package com.randomProject.reflex;

import com.randomProject.entity.PrivateDog;

import java.lang.reflect.Constructor;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/27
 */
public class PrivateDogReflex {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.randomProject.entity.PrivateDog");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        PrivateDog o = (PrivateDog)declaredConstructor.newInstance();
        o.setName("zhangsan");
        o.setAge(15);
        System.out.println();
    }
}