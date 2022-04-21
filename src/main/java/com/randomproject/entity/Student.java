package com.randomproject.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 学生
 * @author ZhangYijing
 */
public class Student {
    private Integer id;
    private String name;
    private Long age;
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

    public Student(Integer id, String name, Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
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
        Student student1 = new Student(1, "zhangsan", 11L);
        Student student2 = new Student(2, null, 14L);
        Student student3 = new Student(3, "zhangsan", 15L);
        Student student4 = new Student(1, "zhaoliu", 13L);
        Student student5 = new Student(1, "chenqi", 19L);

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