package com.myProject.springboot.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 学生
 * @author ZhangYijing
 */
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private BigDecimal account;

    public Student(String name) {
        this.setName(name);
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public Student() {
    }

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(Integer id, String name, Integer age, BigDecimal account) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Student> getStudents() {
        Student student1 = new Student(1, "zhangsan", 11);
        Student student2 = new Student(2, null, 14);
        Student student3 = new Student(3, "zhangsan", 15);
        Student student4 = new Student(1, "zhaoliu", 13);
        Student student5 = new Student(1, "chenqi", 19);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        return students;
    }


    public static List<Student> getStudentsWithAmount() {
        Student student1 = new Student(1, "zhangsan", 11, new BigDecimal("12.88"));
        Student student2 = new Student(2, "lisi", 14, null);
        Student student3 = new Student(3, "wangwu", 15, new BigDecimal("12.88"));
        Student student4 = new Student(1, "zhaoliu", 13, new BigDecimal("12.88"));
        Student student5 = new Student(1, "chenqi", 19, new BigDecimal("12.88"));

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        return students;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}