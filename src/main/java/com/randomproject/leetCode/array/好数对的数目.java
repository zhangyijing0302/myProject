package com.randomproject.leetCode.array;

import org.junit.Test;


/**
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 */
public class 好数对的数目 {


    @Test
    public void test() {
        int[] array = new int[]{1,1,1,1};
        System.out.println(testCase(array));
    }

    public int testCase(int[] array) {
        int count = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] == array[j]) {
                    count ++;
                }
            }
        }
        return count;
    }

    public int testCase1(int[] array) {
        int[] temp = new int[100];
        int count = 0;
        // {1,1,1,1} = 1 + 2 + 3
        for (int i : array) {
            count += temp[i - 1];
            temp[i - 1]++;
        }
        return count;
    }
}