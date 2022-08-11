package com.randomProject.design;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 单例
 */
public class 单例 {
    @Test
    public void test() {
        单例枚举 instance1 = 单例枚举.INSTANCE;
        instance1.doSomeThing();
        单例枚举 instance2 = 单例枚举.INSTANCE;
        instance2.doSomeThing();
        System.out.println(instance1 == instance2);
    }
}


final class 单例静态方法 {

    private 单例静态方法(){}

    private static 单例静态方法 instanceObject = null;

    public static 单例静态方法 getInstance() {
        if (instanceObject == null) {
            synchronized(单例静态方法.class) {
                if (instanceObject == null) {
                    instanceObject = new 单例静态方法();
                }
            }
        }
        return instanceObject;
    }
}

enum 单例枚举 {
    /**
     * 示例
     */
    INSTANCE;

    public void doSomeThing () {
        System.out.println("dodododoododo");
    }
}

class 饿汉 {
    private static 饿汉 instance = new 饿汉();

    private 饿汉() {

    }

    public static 饿汉 getInstance() {
        return instance;
    }
}

class 懒汉不安全 {
    private static 懒汉不安全 instance = null;
    private 懒汉不安全() {
    }
    public static 懒汉不安全 getInstace() {
        if(null == instance) {
            instance = new 懒汉不安全();
        }
        return instance;
    }
}

class 懒汉安全 {
    private static 懒汉安全 instance = null;
    private 懒汉安全() {}
    public static 懒汉安全 getInstance() {
        if(instance == null) {
            synchronized (懒汉安全.class) {
                if(instance == null){
                    instance = new 懒汉安全();
                }
            }
        }
        return instance;
    }
}

/**
 * 也不太安全
 */
class 懒汉绝对安全 {

    private static Boolean flag = false;
    private static volatile 懒汉绝对安全 instance = null;
    private 懒汉绝对安全() {
        System.out.println("flag..." + flag.hashCode());
        if (flag) {
            throw new RuntimeException("error......");
        }
    }
    public static 懒汉绝对安全 getInstance() {
        if(instance == null) {
            synchronized(懒汉绝对安全.class) {
                if(instance == null) {
                    instance = new 懒汉绝对安全();
                    flag = true;
                }
            }
        }
        return instance;
    }
}

class 静态内部类 {
    private 静态内部类() {

    }

    private static class newer {
        private static final 静态内部类 instance = new 静态内部类();
    }

    public static 静态内部类 getInstance() {
        return newer.instance;
    }
}

class TestCase {
    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 300; i++) {
//            new Thread(() -> {
//                饿汉 instance = 饿汉.getInstance();
//                System.out.println(instance);
//            }).start();
//        }

//        Class<饿汉> aClass = 饿汉.class;
//        饿汉 instance = 饿汉.getInstance();
//        Constructor<饿汉> constructor = aClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        饿汉 instance1 = constructor.newInstance();
//        饿汉 instance2 = constructor.newInstance();
//        System.out.println(instance);
//        System.out.println(instance1);
//        System.out.println(instance2);

        Class<懒汉绝对安全> aClass = 懒汉绝对安全.class;
//        懒汉绝对安全 instance = 懒汉绝对安全.getInstance();
        Constructor<懒汉绝对安全> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        懒汉绝对安全 instance1 = constructor.newInstance();
        懒汉绝对安全 instance2 = constructor.newInstance();
        懒汉绝对安全 instance3 = constructor.newInstance();
        System.out.println(instance3);
        System.out.println(instance1);
        System.out.println(instance2);






//        Class<?> declaringClass = aClass.getDeclaringClass();
//        Class<?>[] declaredClasses = aClass.getDeclaredClasses();
//        for (Class<?> declaredClass : declaredClasses) {
//            String name = declaredClass.getName();
//            System.out.println(name);
//            Object o1 = declaredClass.newInstance();
//            Object o2 = declaredClass.newInstance();
//            System.out.println(o1);
//            System.out.println(o2);
//        }


//        constructor.setAccessible(true);
//        静态内部类 instance1 = constructor.newInstance();
//        静态内部类 instance2 = constructor.newInstance();
//
//        System.out.println(instance1);
//        System.out.println(instance2);


    }
}
