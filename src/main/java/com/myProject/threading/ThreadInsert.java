package com.myProject.threading;

import com.myProject.mvc.dao.StuMapper;
import com.myProject.mvc.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;



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
