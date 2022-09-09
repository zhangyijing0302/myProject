package com.myProject.mvc.dao;

import com.myProject.mvc.entity.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZhangYijing
 */
public interface StuMapper {
    /**
     * 学生对象插入
     * @param student
     */
    void insertIntoStu(@Param("stu")Student student);

    Student selectStuByName(@Param("stuName") String stuName);
}
