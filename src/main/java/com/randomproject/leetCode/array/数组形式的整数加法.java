package com.randomproject.leetCode.array;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 */
public class 数组形式的整数加法 {

    @Test
    public void test(){
        int[] array = new int[]{1, 2, 3 , 1};
        System.out.println(testCase(array, 11));
    }

    public LinkedList<Integer> testCase(int[] array, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = array.length;
        int i = n - 1;
        int lastnum = k;
        while(i >= 0 || lastnum > 0){
            if(i >= 0)  {
                //在A还没完，K直接加上A本位的数，省略将进位单独拿出来
                lastnum += array[i];
            }
            list.addFirst(lastnum % 10);
            lastnum /= 10;
            i--;
        }
        return list;
    }
}