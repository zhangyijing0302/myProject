package com.myProject.leetCode.sort;

/**
 * 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法，归并排序对序列的元素进行逐层折半分组，然后从最小分组开始比较排序，合并成一个大的分组，
 * 逐层进行，最终所有的元素都是有序的
 */
public class 归并排序 {
    /**
     * 无序数列：4、5、8、1、7、2、6、3 <br/>
     * 分解：（4、5、8、1）、（7、2、6、3）<br/>
     * 分解：（4、5）、（8、1）、（7、2）、（6、3）<br/>
     * 分解：（4）、（5）、（8）、（1）、（7）、（2）、（6）、（3）<br/>
     * 组装：（4、5）、（1、8）、（2、7）、（3、6）<br/>
     * 组装：（1、4、5、8）、（2、3、6、7）<br/>
     * 组装：（1、2、3、4、5、6、7、8）<br/>
     * @param args
     */
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        mergeSort(data);
        System.out.println("排序后的数组：");
        print(data);
    }
    public static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }
    public static void sort(int[] data, int left, int right) {
        if (left >= right)
            return;
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        sort(data, left, center);
        // 对右边数组进行递归
        sort(data, center + 1, right);
        // 合并
        merge(data, left, center, right);
        print(data);
    }
    /**
     * 将两个数组进行归并，归并前面 2 个数组已有序，归并后依然有序
     * @param data 数组对象
     * @param left 左数组的第一个元素的索引
     * @param center 左数组的最后一个元素的索引，center+1 是右数组第一个元素的索引
     * @param right 右数组最后一个元素的索引
     */
    public static void merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个 while 只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原 left-right 范围的内容被复制回原数组）
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 1.时间复杂度
     * 归并排序算法每次将序列折半分组，共需要logn轮，因此归并排序算法的时间复杂度是O(nlogn)
     * 2.空间复杂度
     * 归并排序算法排序过程中需要额外的一个序列去存储排序后的结果，所占空间是n，因此空间复杂度为O(n)
     * 3.稳定性
     * 归并排序算法在排序过程中，相同元素的前后顺序并没有改变，所以归并排序是一种稳定排序算法
     */
}
