package com.myProject.leetCode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
 */
public class 移除元素 {

    @Test
    public void test() {
        int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = testCase(array, 1);
        System.out.println(i);
        System.out.println(Arrays.toString(array));
    }

    public int testCase(int[] array, int target) {
        int j = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != target) {
                array[j] = array[i];
                j++;
            }
        }
        return j;
    }
}