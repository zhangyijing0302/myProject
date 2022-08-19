package com.myProject.threadAndLock.threadPool.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
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
        try {
            Thread.sleep(5000);
            System.out.println("currentThread:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}