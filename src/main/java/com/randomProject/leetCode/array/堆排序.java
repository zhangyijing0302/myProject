package com.randomProject.leetCode.array;

import java.util.Arrays;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/19
 */
public class 堆排序 {

    public static void main(String[] args) {
        int[] array = {1,2,4,5,6,7,8,9,22,3};
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void buildMaxHeap(int[] tree, int p, int size) {
        // 只有发生交换时才会继续循环，以被交换的子结点作为父节点继续向下重构
        // i 初始定位为待调整父结点的左孩子
        for (int i = 2 * p + 1; i < size; i = 2 * i + 1) {
            // 右孩子存在比较两个孩子的值
            if (i + 1 < size && tree[i] < tree[i + 1]) {
                // 右孩子大，将 i 指向右孩子
                i += 1;
            }
            // 孩子结点大于父结点，进行交换
            if (tree[i] > tree[p]) {
                int temp = tree[i];
                tree[i] = tree[p];
                tree[p] = temp;
                // 交换后，以被交换的节点作为父节点继续构造
                p = i;
                System.out.println(Arrays.toString(tree));
            } else {  // 如果父结点比孩子节点大，直接退出即可，因为是从底层调整到上层
                System.out.println(Arrays.toString(tree));
                break;
            }
        }
    }

    public static void heapSort(int[] tree) {
        // 第一步：将无序序列当作完全二叉树，并构建成大顶堆
        // p 指向父节点，从最后一个 非叶子节点 调整到根节点
        for (int p = tree.length / 2 - 1; p >= 0; p--) {
            buildMaxHeap(tree, p, tree.length);
        }
        // System.out.println(Arrays.toString(tree));

        // 第二步：交换根节点和尾节点，缩小堆的尺寸，重构大顶堆
        // 重复这个过程，直到尺寸减少为 1
        int size = tree.length;
        int temp = 0;
        while (size > 1) {
            // 交换根节点与尾节点
            temp = tree[0];
            tree[0] = tree[size - 1];
            tree[size - 1] = temp;
            // 缩小尺寸
            size--;
            // 从根节点开始重构大顶堆
            buildMaxHeap(tree, 0, size);
        }
    }

}