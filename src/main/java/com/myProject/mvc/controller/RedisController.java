package com.myProject.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myProject.mvc.entity.Cat;
import com.myProject.mvc.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("redis接口测试")
@RestController("redis")
public class RedisController {

    @Autowired
    RedisService redisService;

    @ApiOperation("第一个放进Redis的key")
    @PostMapping("/firstKey")

    public Cat test1() {
        try {
            Cat test = redisService.test();
            return test;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new Cat();
    }
}
