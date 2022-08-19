package com.myProject.dao;

import com.myProject.entity.Student;
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
}
