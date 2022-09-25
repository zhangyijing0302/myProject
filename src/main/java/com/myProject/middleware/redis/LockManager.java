package com.myProject.middleware.redis;


import org.redisson.Redisson;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

public class LockManager {

    private static final String LOCK_TITLE = "MY_PROJECT_";

    private static final Redisson redisson = RedissonManager.getInstance();

    public static boolean addLock(String lockName) {
        String key = LOCK_TITLE + lockName;
        RLock lock = redisson.getLock(key);
        lock.lock(2, TimeUnit.SECONDS);
        return true;
    }

    public static void unLock(String lockName) {
        String key = LOCK_TITLE + lockName;
        RLock lock = redisson.getLock(key);
        lock.unlock();
    }
}
