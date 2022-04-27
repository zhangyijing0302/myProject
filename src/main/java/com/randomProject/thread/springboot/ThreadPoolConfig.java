package com.randomProject.thread.springboot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 线程池配置类
 * @author ZhangYijing
 */
@Data
@Component
public class ThreadPoolConfig {
    /**
     * 核心线程池大小
     */
    @Value("${thread.asyncPool.corePoolSize:5}")
    private Integer corePoolSize;
    /**
     * 最大线程数
     */
    @Value("${thread.asyncPool.maxPoolSize:20}")
    private Integer maxPoolSize;
    /**
     * 队列容量
     */
    @Value("${thread.asyncPool.queueCapacity:20}")
    private Integer queueCapacity;
    /**
     * 线程名称前缀
     */
    @Value("${thread.asyncPool.threadNamePrefix:ZhangYiJingAsyncPool-}")
    private String threadNamePrefix;
}