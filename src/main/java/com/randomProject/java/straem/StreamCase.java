package com.randomProject.java.straem;


import com.randomProject.entity.StuUser;

import java.util.Comparator;
import java.util.List;

public class StreamCase {

    public static void main(String[] args) {
        List<StuUser> stuUser = StuUser.getStuUser();
        Integer reduce = stuUser.stream()
                // 过滤id大于2
                .filter(ele -> ele.getId() > 2)

                .map(StuUser::getAge)
                // 倒叙
                .sorted(Comparator.reverseOrder())
                // 正序
                .sorted(Integer::compareTo)
                .limit(2)
                // 加和
                .reduce(0, Integer::sum);

        System.out.println(reduce);

    }
}
