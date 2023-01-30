package com.myProject.springboot.service.cache;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myProject.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RedisCacheService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    public Student getStudentByNameFromCache(String name) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.readValues((JsonParser) redisTemplate.opsForValue().get(name), Student.class);

        Student stu = new Student();
        stu.setName("测试缓存名称" + name);
        String jsonValue = new ObjectMapper().writeValueAsString(stu);
        redisTemplate.opsForValue().set(name, jsonValue);


        return null;
    }

}
