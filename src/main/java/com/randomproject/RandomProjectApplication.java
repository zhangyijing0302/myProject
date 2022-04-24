package com.randomproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 */
// 忽略jdbc连接
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class RandomProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomProjectApplication.class, args);
    }

}
