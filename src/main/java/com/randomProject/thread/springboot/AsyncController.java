package com.randomProject.thread.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/27
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    TestCaseService testCaseService;

    @RequestMapping("/asyncCase")
    public String getSomeThing() {
        testCaseService.letNumAddOne();
        return "Hello";
    }

}