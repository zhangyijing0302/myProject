package com.myProject.leetCode.array;

import org.junit.Test;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class 子数组的最大平均数 {
    @Test
    public void test() {
        int[] array = new int[]{1,12,-5,-6,50,3};
        double i = testCase(array, 4);
        System.out.println(i);
    }

    public double testCase(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxs = sum;
        for(int i = k; i < nums.length; i++){
            sum = sum + nums[i] - nums[i - k];
            maxs = Math.max(maxs, sum);
        }

        return 1.0 * maxs / k;
    }
}