package com.myProject.entity;

import java.io.Serializable;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/21
 */
public class Cat implements Serializable {

    private static final long serialVersionUID = 6236572045570410208L;

    private String name;
    private Integer age;

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
        return "{name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void fly() {
        System.out.println("cat is flying");
    }

    public void food(String food) {
        System.out.println("cat is eating");
    }

    private void privateMethod(String name) {
        this.setName(name);
        System.out.println("private Cat" + name);
    }

    private void privateMethod(String name, String s, Integer age) {
        this.setName(name);
        this.setAge(age);
        System.out.println("private Cat" + name);
    }
}