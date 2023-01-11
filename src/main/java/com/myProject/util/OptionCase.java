package com.myProject.util;


import java.util.Optional;

public class OptionCase {

    public static void main(String[] args) {
        String str = null;
        System.out.println(Optional.ofNullable(str).orElse("unKnow"));
        System.out.println(Optional.of(str).orElseGet(String::new));
    }

}
