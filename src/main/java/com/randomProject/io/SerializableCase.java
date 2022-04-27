package com.randomProject.io;

import com.randomProject.entity.Cat;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象序列化Case
 *
 * @author ZhangYijing
 */
public class SerializableCase {
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