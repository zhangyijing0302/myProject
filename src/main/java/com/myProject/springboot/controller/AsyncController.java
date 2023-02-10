package com.myProject.springboot.controller;

import com.myProject.springboot.service.AsyncCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/27
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    AsyncCaseService asyncCaseService;

    @RequestMapping("/asyncCase")
    public String getSomeThing() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> asyncCaseService.threadInsert2()).start();
        }
        return "Hello";
    }
    
    @RequestMapping("/asyncTask")
    public String getTask() {
        try {
            String s = asyncCaseService.asyncManagerCase();
            return s;
        } catch (ExecutionException e) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return "a123";
    }

}