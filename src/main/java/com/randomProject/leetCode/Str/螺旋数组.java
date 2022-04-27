package com.randomProject.leetCode.Str;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 一个数组A中存有N（N&gt0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（M>=0）个位置，
 * 即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）
 * （最后M个数循环移至最前面的M个位置）。如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 * 输入：6,2,[1,2,3,4,5,6]
 * 返回值：[5,6,1,2,3,4]
 */
public class 螺旋数组 {

    public static void main(String[] args) {
        int[] array = {1,2,4,5,6,7,8,9,22,3};
//        swap1(array.length, 1, array);
        System.out.println(Arrays.toString(array));
//        rotateArray(array.length, 2, array);
//        System.out.println(Arrays.toString(array));
        System.out.println(swap1(array.length, 22, array));
    }

    public static void rotateArray(int size, int m, int[] array) {
        // 向右移动会出现元素超过一圈转回起始位置
        int k = m % size;
        swap(0, size-1, array);
        swap(0, k -1, array);
        swap(k, size-1, array);
    }

    public static List<Integer> swap1(int start, int k, int[] array) {
        List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());
        LinkedList<Integer> queue = new LinkedList<>(collect);
        for (int i = 0; i < k; i++) {
            Integer integer = queue.removeLast();
            queue.addFirst(integer);
        }
        return queue;
    }


    public static void swap(int start, int end, int[] array) {
        while(start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }


}