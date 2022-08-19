package com.myProject.company.xyxx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * <p>功能: 有一个列表含有N个学生，学生可以获取姓名和班级编号，其中姓名为字符串，班级编号为int。
 * <p>现在对这些学生按班级分组和排序，班级之间按编号递增排序，
 * 班级内学生按照姓名字母序排序，然后顺序打印分组信息

 */
public class StudentCase {
    public static void main(String[] args) {
        List<Student> studentList = getStudentList();
        Collections.sort(studentList);
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.println(student);
            if (i + 1 < studentList.size() && student.getClassNo().compareTo(studentList.get(i + 1).getClassNo()) != 0) {
                System.out.println("--------------墙------------------");
            }
        }
    }

    public static List<Student> getStudentList() {
        List<Student> stuList = new ArrayList<>(10);
        stuList.add(new Student("a",1));
        stuList.add(new Student("b",1));
        stuList.add(new Student("c",1));
        stuList.add(new Student("e",3));
        stuList.add(new Student("f",3));
        stuList.add(new Student("g",3));
        stuList.add(new Student("d",2));
        stuList.add(new Student("c",2));
        stuList.add(new Student("a",2));
        return stuList;
    }
}

class Student implements Comparable {

    public Student() {
    }

    public Student(String name, Integer classNo) {
        this.name = name;
        this.classNo = classNo;
    }

    /**
     * 姓名
     */
    private String name;
    /**
     * 班级
     */
    private Integer classNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }


    @Override
    public int compareTo(Object o) {
        Student targetStu = (Student) o;
        if (targetStu.getName() == null || targetStu.getClassNo() == null) {
            return 0;
        }
        if (this.getClassNo().compareTo(targetStu.getClassNo()) != 0) {
            return this.getClassNo().compareTo(targetStu.getClassNo());
        } else {
            return this.getName().compareTo(targetStu.getName());
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classNo=" + classNo +
                '}';
    }
}