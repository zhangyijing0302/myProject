package com.myProject.leetCode.sort;

/**
 * 选择排序（Selection sort）是最简单直观的一种算法，基本思想为每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，直到所有元素排完为止
 */
public class 选择排序 {

    /**
     * 无序数列：1、5、4、2、6、3 <br/>
     * 第一轮，1去比较最小：<b>1、</b>5、4、2、6、3 <br/>
     * 第二轮，5去比较最小：<b>1、2、</b>4、5、6、3 <br/>
     * 第三轮，4去比较最小：<b>1、2、3、</b>5、6、4 <br/>
     * 第四轮，5去比较最小：<b>1、2、3、4、</b>6、5 <br/>
     * 第五轮，6去比较最小：<b>1、2、3、4、5、</b>6 <br/>
     *
     *
     * @param arrays
     */
    public static void sort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int min = arrays[i];
            int temp = i;
            for (int j = arrays.length - 1; j > i; j--) {
                if (min > arrays[j]) {
                    min = arrays[j];
                    temp = j;
                }
            }
            arrays[temp] = arrays[i];
            arrays[i] = min;
        }
    }
    /**
     * 1.时间复杂度
     * 选择排序算法的每一轮要遍历所有元素，共遍历n-1轮，所以时间复杂度是O(N^2)
     * 2.空间复杂度
     * 选择排序算法排序过程中需要一个临时变量存储最小元素（最大元素），所需要的额外空间为1，因此空间复杂度为O(1)
     * 3.稳定性
     * 选择排序算法是一种不稳定排序算法，当出现相同元素的时候有可能会改变相同元素的顺序
     */
}
