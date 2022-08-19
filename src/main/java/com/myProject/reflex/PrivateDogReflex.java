package com.myProject.reflex;

import com.myProject.entity.PrivateDog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/27
 */
public class PrivateDogReflex {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.myProject.entity.PrivateDog");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        PrivateDog o = (PrivateDog)declaredConstructor.newInstance();
        o.setName("zhangsan");
        o.setAge(15);
        System.out.println(o);


        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.invoke(o, "lisi");
        System.out.println(o);

    }
}