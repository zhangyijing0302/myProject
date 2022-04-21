package com.randomproject.leetCode.array;

import org.junit.Test;

/**
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,…] 。第 5 个缺失的正整数为 9 。
 */
public class 第k个缺失的正整数 {

    @Test
    public void test() {
        int[] array = new int[]{1};
        int[] array1 = new int[]{3,4,5, 7,11};
//        int[] array = new int[]{3,4,5, 7,11};
        System.out.println(testCase1(array, 5));
        System.out.println(testCase(array1, 1));
    }

    public int testCase(int[] array, int k) {
        for (int i = 1; i <= array.length; i++) {
            if ((array[i] - i) >= k) {
                return k + i;
            }
        }
        return k + array.length;
    }

    public int testCase1(int[] array, int k) {
        if (array[0] > 1) {
            k -= (array[0] - 1);
        }
        int result = 0;
        for (int i = 1; i < array.length; i++) {
            if ((array[i] - array[i - 1])>1) {
                result = array[i - 1];
                for (int j = 1; j < (array[i] - array[i - 1]); j++) {
                    k--;
                    result++;
                    if(k == 0) {
                        return result;
                    }
                }
            }
        }
        result = array[array.length - 1];
        for(int i = 0; i < k; i++ ) {
            result++;
        }
        return result;
    }
}