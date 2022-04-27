package com.randomProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动类
 * @author admin
 */
@EnableAsync
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class RandomProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomProjectApplication.class, args);
    }

}
