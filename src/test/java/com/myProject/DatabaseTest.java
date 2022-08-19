package com.myProject;

import com.myProject.dao.StuMapper;
import com.myProject.entity.Student;
import com.myProject.spring.autowired.AutowiredInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DatabaseTest {


    @Autowired
    StuMapper databaseCaseMapper;

    @Test
    public void insertStuInfo() {
        Student student = new Student(null, "zhangfangxin", 12, BigDecimal.ZERO);
        databaseCaseMapper.insertIntoStu(student);
        log.info("新增学生信息");
    }
}
