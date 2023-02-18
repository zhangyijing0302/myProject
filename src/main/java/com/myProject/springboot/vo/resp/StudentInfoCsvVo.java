package com.myProject.springboot.vo.resp;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.math.BigDecimal;

public class StudentInfoCsvVo {

    @Excel(name = "序号", orderNum = "1")
    private Integer id;

    @Excel(name = "姓名", orderNum = "2")
    private String stuName;

    @Excel(name = "年龄", orderNum = "3")
    private Integer age;

    @Excel(name = "存款", orderNum = "4")
    private BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
