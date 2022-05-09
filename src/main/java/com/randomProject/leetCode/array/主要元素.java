package com.randomProject.leetCode.array;

import org.junit.Test;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1
 *
 * 超过一半的元素必连续出现起码1次
 * @author admin
 */
public class 主要元素 {

    @Test
    public void test() {
        int[] array = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 3, 2, 3, 2, 5, 2};
        System.out.println(testcase(array));
    }

    public int testcase(int[] array) {
        int temp = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (temp != array[i]) {
                count--;
            } else {
                count++;
            }

            if (count == 0) {
                temp = array[i];
                count = 1;
            }
        }

        int i = array.length / 2 + 1;
        count = 0;
        for (int i1 : array) {
            if (i1 == temp) {
                count++;
            }
            if (count == i) {
                return temp;
            }
        }
        return -1;
    }
}