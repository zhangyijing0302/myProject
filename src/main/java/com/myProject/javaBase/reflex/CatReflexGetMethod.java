package com.myProject.javaBase.reflex;

import com.myProject.springboot.entity.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author ZhangYijing
 */
public class CatReflexGetMethod {
    public static void main(String[] args) throws Exception {
        Class<?> catClass = Class.forName("com.myProject.springboot.entity.Cat");

        Constructor<?>[] constructors = catClass.getConstructors();
        Cat catObj = (Cat)catClass.newInstance();

        // getMethods可以获取目标类及其父类的公共方法
        Method[] methods = catClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("--------------------------------");
        // getDeclaredMethods可以获取目标类的公有私有方法
        Method[] declaredMethods = catClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            // 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查
            declaredMethod.setAccessible(true);
            System.out.println(declaredMethod.getName());
        }
        System.out.println("--------------------------------");
        Method privateMethod = catClass.getDeclaredMethod("privateMethod", String.class);
        privateMethod.setAccessible(true);
        privateMethod.invoke(catObj, "xiaozhang");
        System.out.println(catObj);

    }
}