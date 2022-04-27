package com.randomProject.design;

import org.junit.Test;

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

class 懒汉绝对安全 {
    private static volatile 懒汉绝对安全 instance = null;
    private 懒汉绝对安全() {}
    public static 懒汉绝对安全 getInstance() {
        if(instance == null) {
            synchronized(懒汉绝对安全.class) {
                if(instance == null) {
                    instance = new 懒汉绝对安全();
                }
            }
        }
        return instance;
    }
}
