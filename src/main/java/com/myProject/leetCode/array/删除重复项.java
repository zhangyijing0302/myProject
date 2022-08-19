package com.myProject.leetCode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
 */
public class 删除重复项 {

    @Test
    public void test() {
        int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = testCase(array);
        System.out.println(i);
        System.out.println(Arrays.toString(array));
    }

    public int testCase(int[] array) {
        int i = 0;
        for (int j = 1; j < array.length; j++) {
           if (array[j] != array[i]) {
               i++;
               array[i] = array[j];
           }
        }
        return i + 1;
    }
}