package com.myProject.entity;

import java.util.Objects;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/5/5
 */
public class HashSetEntity {
    private String name;

    private Integer id;

    private Integer age;

    public HashSetEntity(Integer id, String name, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public HashSetEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HashSetEntity that = (HashSetEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age);
    }

    @Override
    public String toString() {
        return "HashSetEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}