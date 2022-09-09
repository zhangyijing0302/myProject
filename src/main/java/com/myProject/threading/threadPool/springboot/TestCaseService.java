package com.myProject.threading.threadPool.springboot;

import com.myProject.mvc.dao.StuMapper;
import com.myProject.mvc.entity.Student;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

/**
 * 多线程测试类
 * @author ZhangYijing
 */
@Slf4j
@Service
public class TestCaseService {

    @Autowired
    private AsyncManager manager;


    @Autowired
    StuMapper databaseCaseMapper;

    public String asyncManagerCase() throws ExecutionException, InterruptedException, TimeoutException {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        List<CompletableFuture<String>> collect = list.stream().map(ele -> manager.transTaskForCompletableFuture(ele)).collect(Collectors.toList());
        List<String> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        return collect1.toString();
    }

//    List<String> batchGetUserInfoByCompletableFuture(List<String> userNameList) throws InterruptedException, ExecutionException{
//        List<CompletableFuture<String>>  userInfoFutrues = userNameList.stream()
//                .map(userName->asyncTask.getUserInfoByCompletableFuture(userName)).collect(Collectors.toList());
//        return userInfoFutrues.stream().map(CompletableFuture::join).collect(Collectors.toList());
//    }

    @Async("zyjAsyncPool")
    public void letNumAddOne() {
        System.out.println("currentThread:" + Thread.currentThread().getName());
        Student zhangfangxin = databaseCaseMapper.selectStuByName("zhangfangxin");
        if (zhangfangxin != null) {
            System.out.println("重复插入");
        } else {
            Student student = new Student(null, "zhangfangxin", 12, BigDecimal.ZERO);
            databaseCaseMapper.insertIntoStu(student);
        }
    }


}