package com.myProject.design;

import org.junit.Test;

import java.lang.reflect.Constructor;

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

    public 单例枚举 getInstance() {
        return INSTANCE;
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
 *
 * 懒汉模式不加锁时：
 * 1.由于没有加锁，当线程A刚执行完if判断INSTANCE为null后还没来得及执行INSTANCE = new Singleton()
 * 此时线程B进来，if判断后INSTANCE为null，且执行完INSTANCE = new Singleton()
 * 然后，线程A接着执行，由于之前if判断INSTANCE为null，于是执行INSTANCE = new Singleton()重复创建了对象
 * 2、由于没有加锁，当线程A刚执行完if判断INSTANCE为null后开始执行 INSTANCE = new Singleton()
 *  但是注意，new Singleton()这个操作在JVM层面不是一个原子操作
 * （具体由三步组成：1.为INSTANCE分配内存空间；2.初始化INSTANCE；3.将INSTANCE指向分配的内存空间，
 *  而且这三步在JVM层面有可能发生指令重排，导致实际执行顺序可能为1-3-2）
 *  因为new操作不是原子化操作，因此，可能会出现线程A 执行new Singleton()时发生指令重排，
 *  导致实际执行顺序变为1-3-2，当执行完1-3还没来及执行2时（虽然还没执行2，但是对象的引用已经有了，
 *  只不过引用的是一个还没初始化的对象），此时线程B进来进行if判断后INSTANCE不为null，
 *  然后直接把线程A new到一半的对象返回了
 *
 * 懒汉模式加synchronized锁和volatile禁止指令重排
 * 但每次程序进来都需要进入同步代码块，影响性能
 *
 * 懒汉模式加两层校验，第一次判断不为null后直接返回
 * 第二次虽然已经判断过，但是在第一个if和synchronized之间仍有可能被另外线程插入导致第一个if判断为null时
 * 当进入同步代码块之后再次判断时已经不为null了，所以需要再次判断
 *
 *
 *
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
