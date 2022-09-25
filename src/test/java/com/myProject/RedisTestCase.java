package com.myProject;

import com.alibaba.fastjson.JSONObject;
import com.myProject.middleware.redis.RedisEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTestCase {

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test1()  {
        // redis 基本操作
//        redisTemplate.opsForValue();
//        redisTemplate.opsForList();
//        redisTemplate.opsForSet();
//        redisTemplate.opsForHash();
//        redisTemplate.opsForZSet();
//        redisTemplate.opsForGeo();
//        redisTemplate.opsForHyperLogLog();

        // redis 连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();



        redisTemplate.opsForValue().set("mykey", "zhangsan");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    /**
     * JSON序列化
     */
    @Test
    public void test2(){
        RedisEntity redisEntity = new RedisEntity("gg01", "guoyiting", 12);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("usr", redisEntity);
        redisTemplate.opsForValue().set("user", jsonObject);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    /**
     * 对象序列化
     */
    @Test
    public void test3(){
        RedisEntity redisEntity = new RedisEntity("gg01", "guoyiting", 12);
        redisTemplate.opsForValue().set("user", redisEntity);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
