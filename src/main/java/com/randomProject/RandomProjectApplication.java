package com.randomProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动类
 * @author admin
 */
@EnableAsync
@MapperScan(basePackages = {"com.randomProject.dao"})
@SpringBootApplication
public class RandomProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomProjectApplication.class, args);
    }

}
