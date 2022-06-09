package com.randomProject.java.function;

import java.util.function.Function;

public class FunctionCase {
    public static void main(String[] args) {
        Function<Integer, String> function1 = new Function<Integer, String>() {
            @Override
            public String apply(Integer i) {
                return "aaa" + i;
            }
        };

        Function<Integer, String> function2 = ele -> ele + "aaa";

        System.out.println(function2.apply(1));
    }
}
