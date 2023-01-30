package com.myProject.javaBase.straem;

import com.myProject.springboot.entity.Student;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 合并list {
    public static void main(String[] args) {
        List<Student> studentsA = Student.getStudents();
        List<Student> studentsB = Student.getStudents();
        List<Student> collect = Stream.of(studentsA, studentsB).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect.size());
        System.out.println(collect);
    }
}
