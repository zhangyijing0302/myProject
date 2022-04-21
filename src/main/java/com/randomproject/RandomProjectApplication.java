package com.randomproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 测试类
 */
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class RandomProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomProjectApplication.class, args);
    }

}
