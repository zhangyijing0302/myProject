package com.myProject.leetCode.array;

import org.junit.Test;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class 最大子序和 {

    @Test
    public void test() {
        int[] array = new int[]{-2,1,-3,4,-1,2,-1,-5,-4};
        int i = testCase(array);
        System.out.println(i);
    }

    public int testCase(int[] array) {
        int max = array[0];
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (temp > 0) {
                temp += array[i];
            } else {
                temp = array[i];
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}