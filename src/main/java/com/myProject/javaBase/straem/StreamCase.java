package com.myProject.javaBase.straem;


import com.myProject.mvc.entity.StuUser;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void test() {
        List<Long> list = new ArrayList<>();
        list.add(12L);
        list.add(13L);
        list.add(14L);
        list.add(15L);
        list.add(16L);
        list.add(17L);
        int i = list.stream().reduce(0L, Long::sum).intValue();
        System.out.println(i);

        List<Long> list2 = new ArrayList<>();
        list2.add(12L);
        int i2 = list2.stream().reduce(0L, Long::sum).intValue();
        System.out.println(i2);
    }
}
