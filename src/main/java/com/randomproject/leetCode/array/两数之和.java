package com.randomproject.leetCode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 */
public class 两数之和 {

    @Test
    public void test() {
        int[] array = {3,3};
        System.out.println(Arrays.toString(count(array, 6)));
    }

    public int[] count(int[] array, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (record.containsKey(target - array[i])) {
                return new int[] {record.get(target - array[i]), i};
            }
            record.put(array[i], i);
        }
        return null;

    }

}