package com.randomProject.reflex;

import com.randomProject.entity.Cat;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 反射
 * @author ZhangYijing
 */
public class ReflexTest {

    public static void main(String[] args) throws Exception {
        Class<?> cat = Class.forName("com.randomProject.entity.Cat");
        Constructor<?> constructor = cat.getConstructor();
        Cat cat1 = (Cat) cat.newInstance();
        cat1.setName("aa");
        Cat cat2 = (Cat) constructor.newInstance();
        cat2.setName("bb");
        System.out.println(cat1);
        System.out.println(cat2);
    }


}