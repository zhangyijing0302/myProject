package com.myProject.util;


import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class OptionCase {

    public static void main(String[] args) {
        String str = null;
        System.out.println(Optional.ofNullable(str).orElse("unKnow"));
        System.out.println(Optional.of(str).orElseGet(String::new));
    }

    @Test
    public void test() {
        Temp temp = new Temp();
        System.out.println(temp.getList()); // null
        System.out.println(CollectionUtils.isEmpty(temp.getList())); // true

        Temp temp1 = null;
        System.out.println(Optional.ofNullable(temp).map(Temp::getList).orElse(Collections.singletonList("a")));
        System.out.println(Optional.ofNullable(temp).map(Temp::getList).map(CollectionUtils::isEmpty).orElse(true));

    }

}
class Temp {
    List<String> list = Collections.singletonList("g");

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
