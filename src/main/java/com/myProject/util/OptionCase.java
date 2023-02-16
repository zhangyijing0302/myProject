package com.myProject.util;


import com.myProject.springboot.entity.Student;
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
        Student temp = new Student();
        System.out.println(temp.getHobbies()); // null
        System.out.println(CollectionUtils.isEmpty(temp.getHobbies())); // true

        Student temp1 = null;
        System.out.println(Optional.ofNullable(temp).map(Student::getHobbies).orElse(Collections.singletonList("a")));
        System.out.println(Optional.ofNullable(temp).map(Student::getHobbies).map(CollectionUtils::isEmpty).orElse(true));

    }

}

