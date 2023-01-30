package com.myProject.springboot.annotation.autowired;

import org.springframework.stereotype.Service;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/5/9
 */
@Service("ZhangYijing")
public class AutowiredImpl1 implements AutowiredInterface{
    @Override
    public void say() {
        System.out.println("说话的方式1");
    }
}