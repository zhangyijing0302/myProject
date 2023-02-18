package com.myProject.springboot.dao;

import com.myProject.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhangYijing
 */
@Mapper
public interface StuMapper {
    /**
     * 学生对象插入
     * @param student
     */
    void insertIntoStu(@Param("stu")Student student);

    Student selectStuByName(@Param("stuName") String stuName);

    List<Student> selectStuList();

    int selectCount();

    void batchInsert(List<Student> list);
}
