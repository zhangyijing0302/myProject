package com.randomproject.entity;

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
        return "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}