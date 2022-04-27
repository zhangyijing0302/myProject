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

    @Test
    public void test1() throws Exception{
        Cat c = new Cat();
        c.setName("猫猫");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("catFile"));
        oos.writeObject(c);
        oos.flush();
        oos.close();
    }

    @Test
    public void test2() throws Exception {
        ObjectInputStream catFile = new ObjectInputStream(new FileInputStream("catFile"));
        Cat o = (Cat)catFile.readObject();
        System.out.println(o);
    }
}