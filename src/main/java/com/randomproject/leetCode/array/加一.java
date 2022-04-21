package com.randomproject.leetCode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 */
public class 加一 {

    @Test
    public void test() {
        int[] array = new int[]{9,9,9,9};
        int[] ints = testCase(array);
        System.out.println(Arrays.toString(ints));
    }

    public int[] testCase(int[] digits) {

        for(int i = digits.length - 1; i >= 0; i--){
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0) {
                //说明没有进位
                return digits;
            }
        }
        //如果在上述没有返回，则表示最后一位还有进位，需扩展数组
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}