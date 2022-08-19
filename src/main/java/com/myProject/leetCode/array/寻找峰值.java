package com.myProject.leetCode.array;

/**
 * 山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，
 * 任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
 *
 * 假设 nums[-1] = nums[n] = -∞。
 *
 * 示例1
 * 输入：[2,4,1,2,7,8,4]
 * 返回值：5
 */
public class 寻找峰值 {

    public static void main(String[] args) {
        int[] array = {2,4,1,2,7,8,4};
    }

    public static int findTop(int[] array) {

        int index = 0;
        for(int i = array.length - 1; i >= 1; i--) {
            //找到一个索引最大的山峰元素
            //此时元素的索引已经最大，且该元素一定大于右边元素，（否则在上一步就return了）
            if(array[i] >= array[i-1])   {
                //即只要找到大于左边元素即可
                return i;
            }
        }
        return -1;
    }


}