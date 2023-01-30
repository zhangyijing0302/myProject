package com.myProject;

import com.myProject.springboot.dao.StuMapper;
import com.myProject.springboot.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@EnableAsync
public class DatabaseTest {


    @Autowired
    StuMapper databaseCaseMapper;

    @Test
    public void insertStuInfo() {
        Student student = new Student(null, "zhangfangxin", 12, BigDecimal.ZERO);
        databaseCaseMapper.insertIntoStu(student);
        log.info("新增学生信息");
    }
    @Test
    public void threadInsert() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Student zhangfangxin = databaseCaseMapper.selectStuByName("zhangfangxin");
                if (zhangfangxin != null) {
                    throw new RuntimeException("重复插入！！！");
                } else {
                    Student student = new Student(null, "zhangfangxin", 12, BigDecimal.ZERO);
                    databaseCaseMapper.insertIntoStu(student);
                }
                System.out.println("8886");
            }).start();
        }
        System.out.println("enheng");
    }
}
