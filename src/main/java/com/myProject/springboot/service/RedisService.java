package com.myProject.springboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myProject.springboot.entity.Cat;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {

    @Resource
    private RedisTemplate myRedisTemplate;

    public Cat test() throws JsonProcessingException {
        Cat cat = new Cat();
        cat.setName("小锅");
        cat.setAge(18);
        String s = new ObjectMapper().writeValueAsString(cat);
        myRedisTemplate.opsForValue().set("aaa", s);
        Object aaa = myRedisTemplate.opsForValue().get("aaa");
        Cat result = new ObjectMapper().readValue(aaa.toString(), Cat.class);
        return result;
    }

}
