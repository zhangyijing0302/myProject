package com.randomProject.company.jpjl;

import com.randomProject.entity.Cat;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.*;

/**
 * 游戏服务器序列化/反序列化用什么样的技术
 *
 * @author ZhangYijing
 */
public class 序列化反序列化 {
    /**
     * 在服务器内部，大部分数据都是以对象的形式存储的，那么如果可以直接发一个对象发送给客户端或是其他进程来完成通信
     * 序列化和反序列化直观上就完成了对象->字节流以及字节流->对象的转化过程。
     * JAVA中实现序列化反序列化需要使目标对象实现Serializable接口，并约定一个序列化ID，可以实现一个对象从内存中到硬盘中的转换
     * 在网络中传输对象，通过mybatis保存至数据库这些过程都需要序列化
     * JAVA中将对象序列化成一个文件的方式是new ObjectOutputStream(new FileOutputStream("文件名"))。writeObject(对象)；这种方式
     * 除此之外还有什么技术专门来做这件事情的话暂时不太清楚
     */
//    public static void main(String[] args) throws Exception {
//
//        Cat c = new Cat();
//        c.setName("猫猫");
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("catFile"));
//        oos.writeObject(c);
//        oos.flush();
//        oos.close();
//    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        ObjectInputStream catFile = new ObjectInputStream(new FileInputStream("catFile"));
        Cat o = (Cat)catFile.readObject();
        System.out.println(o);
        Connection conn = DriverManager.getConnection("");
        Statement statement = conn.createStatement();
//        PreparedStatement preparedStatement = conn.prepareStatement();
    }
}