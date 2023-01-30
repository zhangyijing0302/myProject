package com.myProject.juc;

import com.myProject.springboot.dao.StuMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ThreadInsert {


    @Autowired
    StuMapper databaseCaseMapper;

    @Test
    public void threadInsert() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {

            }).start();
        }
        System.out.println("enheng");
    }
}
