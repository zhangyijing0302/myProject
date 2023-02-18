package com.myProject.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myProject.config.MyAsyncPool;
import com.myProject.springboot.dao.StuMapper;
import com.myProject.springboot.entity.Student;
import com.myProject.springboot.utils.MyWatch;
import com.myProject.springboot.vo.resp.StudentInfoCsvVo;
import com.myProject.util.PageHelperHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/28
 */
@Service
@Slf4j
public class StuService {

    @Autowired
    StuMapper databaseCaseMapper;

    @Autowired
    MyAsyncPool asyncPool;

    public void insertStuInfo(Student student, Integer num) {
        databaseCaseMapper.insertIntoStu(student);
        log.info("新增学生信息");
    }

    public Long batchInsert() {
        long start = System.currentTimeMillis();
        ArrayList<Student> list = new ArrayList<>(1_000_000);
        for (int i = 0; i < 1_000_000; i++) {
            Student student = new Student(null, "zhangsan", i + 1, BigDecimal.ZERO);
            list.add(student);
        }
        List<List<Student>> listByPage = PageHelperHandler.getListByPage(list);
        for (List<Student> students : listByPage) {
            databaseCaseMapper.batchInsert(students);
        }
        long total = System.currentTimeMillis() - start;
        log.info("百万数据插入耗时【{}】毫秒", total);
        return total;
    }

    public List<StudentInfoCsvVo> selectStuInfo2Export() {
        List<Student> students = databaseCaseMapper.selectStuList();
        List<StudentInfoCsvVo> result = new ArrayList<>(students.size());
        for (Student student : students) {
            StudentInfoCsvVo studentInfoCsvVo = new StudentInfoCsvVo();
            studentInfoCsvVo.setId(student.getId());
            studentInfoCsvVo.setStuName(student.getName());
            studentInfoCsvVo.setAge(student.getAge());
            studentInfoCsvVo.setAmount(student.getAccount());
            result.add(studentInfoCsvVo);
        }
        return result;
    }

//    private static final int pageSize = 100000;

    public List<StudentInfoCsvVo> concurrencySelectStuInfo2Export(int pageSize) {
        // 先获取总导出数量
        int total = databaseCaseMapper.selectCount();
        // 看看需要分几页,需要跑多少个线程  我先一夜20000条
        int count = total / pageSize + (total % pageSize > 0 ? 1 : 0);
        CountDownLatch countDownLatch = new CountDownLatch(count);
        List<StuInfoExportTask> taskList = new ArrayList<>(count);
        for (int i = 1; i <= count; i++) {
            taskList.add(new StuInfoExportTask(i, pageSize, countDownLatch));
        }
        List<StudentInfoCsvVo> result = new ArrayList<>(total);
        ThreadPoolExecutor oneExecutor = asyncPool.getOneExecutor();
        try {
            List<Future<List<StudentInfoCsvVo>>> futures = oneExecutor.invokeAll(taskList);
            for (Future<List<StudentInfoCsvVo>> future : futures) {
                result.addAll(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}