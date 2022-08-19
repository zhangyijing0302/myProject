package com.myProject.threadAndLock.threadPool.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步线程池
 * @author ZhangYijing
 */
@Configuration
public class MyAsyncPool {

    ThreadPoolConfig threadPoolConfig;

    @Autowired
    public void setThreadPoolConfig(ThreadPoolConfig threadPoolConfig) {
        this.threadPoolConfig = threadPoolConfig;
    }

    @Bean("zyjAsyncPool")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程池大小
        executor.setCorePoolSize(threadPoolConfig.getCorePoolSize());
        // 最大线程数
        executor.setMaxPoolSize(threadPoolConfig.getMaxPoolSize());
        // 队列容量
        executor.setQueueCapacity(threadPoolConfig.getQueueCapacity());
        // 线程名字前缀
        executor.setThreadNamePrefix(threadPoolConfig.getThreadNamePrefix());
        // 拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 执行初始化
        executor.initialize();
        return executor;
    }
}