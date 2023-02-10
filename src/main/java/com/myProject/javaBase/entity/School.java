package com.myProject.javaBase.entity;

import java.io.Serializable;

public class School implements Cloneable, Serializable {
    private String scName;

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public static void goBack() {
        System.out.println("倒闭");
    }

    @Override
    public School clone() throws CloneNotSupportedException {
        return (School)super.clone();
    }
}
