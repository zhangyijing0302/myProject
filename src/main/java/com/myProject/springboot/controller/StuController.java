package com.myProject.springboot.controller;

import com.myProject.springboot.entity.Student;
import com.myProject.springboot.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/28
 */
@Slf4j
@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    StuService stuService;

    @RequestMapping("/add")
    public String addStu() {
        Student student = new Student(null, "zhangsan", 12, BigDecimal.ZERO);
        stuService.insertStuInfo(student, 88);

        return "add";
    }
}