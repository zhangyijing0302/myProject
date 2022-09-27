package com.myProject.middleware.redis;


import org.redisson.Redisson;
import org.redisson.config.Config;

public class RedissonManager {
    private static final Config config = new Config();

    private static Redisson redisson = null;

    static {
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        redisson = (Redisson)Redisson.create(config);
    }

    public static Redisson getInstance() {
        return redisson;
    }
}
