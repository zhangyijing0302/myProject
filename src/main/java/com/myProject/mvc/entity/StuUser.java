package com.myProject.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuUser {
    private int id;
    private String username;
    private int age;

    public static List<StuUser> getStuUser() {
        StuUser user1 = new StuUser(1, "zhangsan", 12);
        StuUser user2 = new StuUser(2, "lisi", 13);
        StuUser user3 = new StuUser(3, "wangwu", 14);
        StuUser user4 = new StuUser(4, "zhaoliu", 15);
        StuUser user5 = new StuUser(5, "chenqi", 16);
        StuUser user6 = new StuUser(6, "gaoba", 17);
        return Arrays.asList(user1,user2,user3,user4,user5,user6);
    }
}
