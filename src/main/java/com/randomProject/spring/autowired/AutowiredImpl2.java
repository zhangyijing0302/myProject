package com.randomProject.spring.autowired;

import org.springframework.stereotype.Service;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/5/9
 */
@Service
public class AutowiredImpl2 implements AutowiredInterface{
    @Override
    public void say() {
        System.out.println("说话的方式2");
    }
}