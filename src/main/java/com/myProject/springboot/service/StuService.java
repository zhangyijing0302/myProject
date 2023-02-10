package com.myProject.springboot.service;

import com.myProject.springboot.dao.StuMapper;
import com.myProject.springboot.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/28
 */
@Service
@Slf4j
public class StuService {

    @Autowired
    StuMapper databaseCaseMapper;

    public void insertStuInfo(Student student, Integer num) {
        databaseCaseMapper.insertIntoStu(student);
        log.info("新增学生信息");
    }

}