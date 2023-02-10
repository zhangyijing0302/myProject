package com.myProject.leetCode.sort;

/**
 * 二分查找 又叫折半查找，要求待查找的序列有序。每次取中间位置的值与待查关键字比较，如果中间位置
 * 的值比待查关键字大，则在前半部分循环这个查找的过程，如果中间位置的值比待查关键字小，
 * 则在后半部分循环这个查找的过程。直到查找到了为止，否则序列中没有待查的关键字。
 */
public class 二分查找 {

    public static int biSearch(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;//中间位置
            if (array[mid] == target) {
                return mid + 1;
            } else if (array[mid] < target) { //向右查找
                lo = mid + 1;
            } else { //向左查找
                hi = mid - 1;
            }
        }
        return -1;
    }
}
