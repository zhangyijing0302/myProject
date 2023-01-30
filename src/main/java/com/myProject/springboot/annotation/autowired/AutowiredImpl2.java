package com.myProject.springboot.annotation.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/5/9
 */
@Primary
@Service
public class AutowiredImpl2 implements AutowiredInterface{
    @Override
    public void say() {
        System.out.println("说话的方式2");
    }
}