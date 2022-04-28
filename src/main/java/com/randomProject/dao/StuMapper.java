package com.randomProject.dao;

import com.randomProject.entity.Student;
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
