package com.myProject.threading.threadPool.springboot;

import com.myProject.mvc.dao.StuMapper;
import com.myProject.mvc.entity.Student;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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


    @Resource
    StuMapper stuMapper;

    ReadWriteLock lock = new ReentrantReadWriteLock();

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

    @Async("zyjAsyncPool")
    public void threadInsert() {
        synchronized (TestCaseService.class) {
            Student zhangfangxin = stuMapper.selectStuByName("zhangfangxin");
            if (zhangfangxin != null) {
                System.out.println("重复插入");
            } else {
                Student student = new Student(null, "zhangfangxin", 12, BigDecimal.ZERO);
                stuMapper.insertIntoStu(student);
            }
        }
    }

    @Transactional
    public void threadInsert2() {
        Lock readLock = this.lock.readLock();
        Lock writeLock = this.lock.writeLock();

        try {
            readLock.lock();
            Student stu = stuMapper.selectStuByName("zhangfangxin");
            if (Objects.nonNull(stu)) {
                System.out.println("重复插入");
                return;
            }
        } finally {
            readLock.unlock();
        }
        try {
            writeLock.lock();
            Student student = new Student(null, "zhangfangxin", 12, BigDecimal.ZERO);
            stuMapper.insertIntoStu(student);
        } finally {
            writeLock.unlock();
        }


    }

    @Transactional
    public void threadInsert3() {
        Student stu = stuMapper.selectStuByName("zhangfangxin");
        if (Objects.isNull(stu)) {
            Student student = new Student(null, "zhangfangxin", 12, BigDecimal.ZERO);
            stuMapper.insertIntoStu(student);
        } else {
            System.out.println("重复插入");
        }
    }


}