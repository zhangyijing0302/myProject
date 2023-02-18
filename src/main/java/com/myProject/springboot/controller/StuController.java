package com.myProject.springboot.controller;

import com.myProject.springboot.entity.Student;
import com.myProject.springboot.service.StuService;
import com.myProject.springboot.utils.MyWatch;
import com.myProject.springboot.vo.resp.StudentInfoCsvVo;
import com.myProject.util.CsvExportUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/28
 */
@Api("学生信息控制层")
@Slf4j
@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    StuService stuService;


    @GetMapping("/add")
    @ApiOperation("测试add")
    public String addStu() {
        Student student = new Student(null, "zhangsan", 12, BigDecimal.ZERO);
        stuService.insertStuInfo(student, 88);

        return "add";
    }

    @GetMapping("/batchInsert")
    @ApiOperation("百万数据插入")
    public Long batchInsert() {
        Long aLong = stuService.batchInsert();
        return aLong;
    }

    /**
     * ---------------------------------------------
     * Task name		耗时			占比
     * ---------------------------------------------
     * 【查询任务】		【15970】ms		【84%】
     * 【导出任务】		【2999】ms		【16%】
     * 【结果汇总】		【18970】ms		【100】
     * ---------------------------------------------
     */
    @PostMapping("/exportStuInfo")
    @ApiOperation("【单线程】百万数据导出")
    public String exportStu(HttpServletResponse response) throws Exception {
        StopWatch watch = new MyWatch();
        watch.start("查询任务");
        List<StudentInfoCsvVo> studentInfoCsvVos = stuService.selectStuInfo2Export();
        watch.stop();
        log.info("【单线程】{}条学生信息统计耗时【{}】毫秒", studentInfoCsvVos.size(), watch.getLastTaskTimeMillis());
        watch.start("导出任务");
        CsvExportUtils.csvExport("学生信息", StudentInfoCsvVo.class, studentInfoCsvVos, response);
        watch.stop();
        log.info("【单线程】学生信息导出耗时【{}】毫秒", watch.getLastTaskTimeMillis());
        log.info("【单线程】学生信息导出总耗时【{}】毫秒", watch.getTotalTimeMillis());
        log.info("【单线程】打个表格记录一下{}", watch.prettyPrint());
        return watch.prettyPrint();
    }

    /**
     * ---------------------------------------------
     * Task name		耗时			占比
     * ---------------------------------------------
     * 【查询任务】		【9694】ms		【77%】
     * 【导出任务】		【2896】ms		【23%】
     * 【结果汇总】		【12591】ms		【100】
     * ---------------------------------------------
     */
    @PostMapping("/exportStuInfoGood/{pageSize}")
    @ApiOperation("【多线程】百万数据导出")
    public String exportStuGood(HttpServletResponse response, @PathVariable("pageSize") Integer pageSize) throws Exception {
        MyWatch watch = new MyWatch();
        watch.start("查询任务");
        List<StudentInfoCsvVo> studentInfoCsvVos = stuService.concurrencySelectStuInfo2Export(pageSize);
        watch.stop();
        log.info("【多线程】{}条学生信息统计耗时【{}】毫秒", studentInfoCsvVos.size(), watch.getLastTaskTimeMillis());
        watch.start("导出任务");
        CsvExportUtils.csvExport("学生信息", StudentInfoCsvVo.class, studentInfoCsvVos, response);
        watch.stop();
        log.info("【多线程】学生信息导出耗时【{}】毫秒", watch.getLastTaskTimeMillis());
        log.info("【多线程】学生信息导出总耗时【{}】毫秒", watch.getTotalTimeMillis());
        log.info("【多线程】打个表格记录一下{}", watch.prettyPrint());
        return watch.prettyPrint();
    }
}