package com.myProject.springboot.service;

import cn.hutool.extra.spring.SpringUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myProject.springboot.dao.StuMapper;
import com.myProject.springboot.entity.Student;
import com.myProject.springboot.utils.MyWatch;
import com.myProject.springboot.vo.resp.StudentInfoCsvVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class StuInfoExportTask implements Callable<List<StudentInfoCsvVo>> {

    /**
     * 第几页
     */
    private Integer pageNum;
    /**
     * 一页有几条
     */
    private Integer pageSize;
    /**
     * 线程计数
     */
    private CountDownLatch countDownLatch;

    private StuMapper databaseCaseMapper;

    public StuInfoExportTask(Integer pageNum, Integer pageSize, CountDownLatch countDownLatch) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public List<StudentInfoCsvVo> call() throws Exception {
        MyWatch watch = new MyWatch();
        watch.start();
        databaseCaseMapper = SpringUtil.getBean("stuMapper");
        Page<Student> objects = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> databaseCaseMapper.selectStuList());
        List<Student> students = objects.getResult();
        List<StudentInfoCsvVo> result = new ArrayList<>(students.size());
        for (Student student : students) {
            StudentInfoCsvVo studentInfoCsvVo = new StudentInfoCsvVo();
            studentInfoCsvVo.setId(student.getId());
            studentInfoCsvVo.setStuName(student.getName());
            studentInfoCsvVo.setAge(student.getAge());
            studentInfoCsvVo.setAmount(student.getAccount());
            result.add(studentInfoCsvVo);
        }
        watch.stop();
        System.out.println("线程【" + Thread.currentThread().getName() + "】执行第【" + pageNum +"】页分批查询耗时【" + watch.getTotalTimeMillis() + "】毫秒");
        return result;
    }
}
