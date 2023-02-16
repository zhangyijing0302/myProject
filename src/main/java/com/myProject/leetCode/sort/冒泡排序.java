package com.myProject.leetCode.sort;

import java.util.Arrays;

/**
 * （1）比较前后相邻的二个数据，如果前面数据大于后面的数据，就将这二个数据交换。
 * （2）这样对数组的第 0 个数据到 N-1 个数据进行一次遍历后，最大的一个数据就“沉”到数组第 N-1 个位置。
 * （3）N=N-1，如果 N 不为 0 就重复前面二步，否则排序完成。
 */
public class 冒泡排序 {

    /**
     * 无序数列：1、5、4、2、6、3 <tr/>
     * 从左到右两两比较，交换位置      <tr/>
     * 第一轮 ： 1、4、2、5、3、<b>6</b> <tr/>
     * 第二轮 ： 1、2、4、3、<b>5、6</b> <tr/>
     * 第三轮 ： 1、2、3、<b>4、5、6</b> <tr/>
     * 从这里开始，序列已经有序，无需再进行后续排序<tr/>
     * 第四轮 ： 1、2、<b>3、4、5、6</b> <tr/>
     * 第五轮 ： 1、<b>2、3、4、5、6</b> <tr/>
     * 第六轮 ： <b>1、2、3、4、5、6</b> <tr/>
     *
     * @param n
     */
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,6,4};
        bubbleSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort1(int[] a) {
        int i, j;
        int length = a.length;
        // 优化点2： 记录无需数列的边界，每次比较到这里位置
        int lastExchangeIndex = 0;
        int sortBorder = length - 1;
        for (i = 0; i < length - 1; i++) {//表示 n 次排序过程。
            boolean isSort = true;
            for (j = 1; j <= sortBorder; j++) {
                if (a[j - 1] > a[j]) {//前面的数字大于后面的数字就交换
                    //交换 a[j-1]和 a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    isSort = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;

            // 优化点1：没有进for循环 序列已经是有序的了，无需再进行排序
            if (isSort) {
                break;
            }
        }
    }
    /**
     * 1.时间复杂度
     * 冒泡排序算法的每一轮要遍历所有元素，轮转的次数和元素数量相当，所以时间复杂度是O(N^2)
     * 经过优化后，最优的情况，序列已经是顺序的，那么只要进行一次循环，所以最优时间复杂度是O(N)
     * 2.空间复杂度
     * 冒泡排序算法排序过程中需要一个临时变量进行两两交换，所需要的额外空间为1，因此空间复杂度为O(1)
     * 3.稳定性
     * 冒泡排序算法在排序过程中，元素两两交换时，相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法
     */
}
