package com.myProject.leetCode.Str;

import org.junit.Test;

import java.util.Arrays;

public class 倒序字符串 {

    /**
     * 输入: I am a student 输出: student a am I
     * >
     * > #### 输入是数组 输出也是数组 不允许用 split splice reverse
     */
    @Test
    public void test25() {
        String[] strArr = new String[]{"I", "am", "a", "student"};
        String[] targetArr = new String[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            targetArr[i] = strArr[length - 1 - i];
        }
        System.out.println(Arrays.asList(targetArr));
    }
    @Test
    public void test26() {
        String[] strArr = new String[]{"I", "am", "a", "student"};
        int length = strArr.length;
        for (int i = 0; i < length / 2; i++) {
            String temp = strArr[i];
            strArr[i] = strArr[length - 1 - i];
            strArr[length - 1 - i] = temp;
        }
        System.out.println(Arrays.asList(strArr));
    }
}
