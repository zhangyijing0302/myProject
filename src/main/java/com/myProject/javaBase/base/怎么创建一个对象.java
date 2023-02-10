package com.myProject.javaBase.base;

import com.myProject.javaBase.entity.School;
import org.apache.commons.lang3.SerializationUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 1 判断对象对应的类是否加载、链接、初始化。
 * 当虚拟机碰到new的时候，就先去检查对象的类是否已经被加载过，如果没有被加载过，就要先进行类的加载。
 * 2.分配内存
 * 一个对象所占的内存在类加载完毕后即可以确定了，于是虚拟机就需要在Java的堆上分配一块确定大小的空间给这个新的对象。
 * 分配的方式有“指针碰撞”（适合没有内存碎片的情况）和“空闲列表”（适合内存不规整的情况），
 * 3.初始化零值
 * 给对象分配了内存后，JVM就需要对这个对象里的空间都初始化为零值
 * 4.设置对象头
 * 这个阶段是对对象头进行必要的设置，对象头里有一些信息例如，这个对象是哪个类的实例，对象的hashCode，对象的GC分代以及年龄，等等这些都存放在对象头中。
 * 5.执行init方法
 * 上面工作完成后，这个新生的对象有空间有初值，从JVM的角度来说这个对象已经可以拿来使用了。
 * 但是一个对象需要按照我们程序员自己的想法来进行初值的赋予和构造。
 */
public class 怎么创建一个对象 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException {
        // 1. new
        School school1 = new School();
        // 2. Class.newInstance
        School school2 = School.class.newInstance();
        // 3. class.getConstructor().newInstance()
        School school3 = School.class.getConstructor().newInstance();
        // 4. implement Cloneable 重写clone方法 没有调用构造器
        School school4 = school1.clone();
        // 5 通过序列化与反序列化 没有调用构造器
        byte[] serialize = SerializationUtils.serialize(school1);
        Object deserialize = SerializationUtils.deserialize(serialize);
    }
}
