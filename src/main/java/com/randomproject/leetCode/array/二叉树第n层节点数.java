package com.randomproject.leetCode.array;


/**
 * 对于数组通过逐个遍历转换成的平衡二叉树，有一个规律就是对于任意一个节点单纯按照数组的下标来算的话,抛开寻找根节点的父节点，寻找叶子节点的子节点这种奇怪操作
 * 都有2n + 1 是当前节点的左孩子的下标索引，2n + 2 是当前节点的右孩子的下标索引, （n + 1）/2 表示的是当前节点的父节点 【这里n+1表示的已经是我们口头说的第几个元素了】
 * 然后对于这种类型的树我们要计算第几层有多少个元素的话是比较简单的，因为它是有规律的，假设一个数组形成的二叉树的所有节点的左右孩子要么没有要么是包和的情况的话，
 * 第一层 1个元素 第二层 2个元素 第三层 4个元素， 第四层8个元素 所以规律就是2的(层数 - 1)次幂，翻译成java语言就是（1 << (n - 1)）
 * 但是实际情况可能最后一层不一定是饱和的，但是倒数第二层肯定是饱和的。但是一个数组组装成的二叉树一共有几层呢 计算方式是循环【（数组长度 >> 1）如果不等于0的话 层级 + 1】
 * 目标层的元素个数的计算方式就是（如果目标层级是最后一层，个数=数组元素个数 减去 非倒数第一层的元素个数）（如果目标层级非最后一层，则个数=1 << (n - 1)）
 *
 * 如果对于真正的树型结构链表形式而言，一个Tree对象有它自己的左孩子节点，右孩子节点，计算目标层级的元素个数的方法就可以通过简单的从根节点开始递归的方式计算
 * 递归停止的条件是找不到子节点的时候，下面写了两个小demo
 *
 */
public class 二叉树第n层节点数 {

    public static void main(String[] args) {
        Tree tree = buildTree();
        int treeCount = getTreeCount(tree, 2);
        System.out.println(treeCount);
    }

    public int countTagLevelTreeNums(int[] array, int n) {
        int tempLength = array.length;
        // 计算当前数组转换为二叉树后有几个层级\加和倒数第二层往上数的所有层级的元素个数
        int levelCount = 1, lastSecondCount = 1;
        while((tempLength >> 1) != 0) {
            lastSecondCount += 1 << levelCount;
            levelCount++;
            tempLength = tempLength >> 1;
        }
        lastSecondCount = lastSecondCount >> 1;
        if (n > levelCount) {
            return -1;
        }
        if (levelCount == n) {
            // 如果计算的是最后一层的个数的话,最后一层的元素个数是总数减去倒数第二层
            return array.length - lastSecondCount;
        } else {
            // 不是最后一层的话就按照规律计算
            return (1 << (n - 1));
        }
    }

    public static int countTree(int[] array, int n) {
        int count = 0;
        int tempLength = array.length;
        while((tempLength >> 1) != 0) {
            count++;
            tempLength = tempLength >> 1;
        }
        return count;
    }

    public static Tree buildTree() {
        Tree rootTree = new Tree();
        rootTree.value =  1;

        Tree left = new Tree();
        left.value=2;
        Tree right = new Tree();
        right.value=3;

        Tree leftChildTree = new Tree();
        leftChildTree.value=4;
        Tree rightChildTree = new Tree();
        rightChildTree.value=5;

        Tree rightChileTreeLeft = new Tree();
        rightChileTreeLeft.value= 6;

        Tree rightChileTreeRight = new Tree();
        rightChileTreeRight.value= 7;

        left.leftTree=leftChildTree;
        left.rightTree=rightChildTree;
//        right.leftTree=rightChileTreeLeft;
        right.rightTree=rightChileTreeRight;
        rootTree.leftTree=left;
        rootTree.rightTree=right;
        return rootTree;
    }

    public static int getTreeCount(Tree node, int n) {
        if (n <= 0 || node == null) {
            // 某一节点没有孩子节点的时候，比如某一节点有右孩子，没有左孩子，调用左孩子方法进来的时候就是空，没有元素，返回0
            return 0;
        }
        if (n == 1) {
            // 已经从根节点递归到目标层级了，不需要再寻找当前层级的子节点了
            return 1;
        }
        int left = getTreeCount(node.leftTree, n - 1);
        int right = getTreeCount(node.rightTree, n - 1);
        return left + right;
    }

}

class Tree {
    public Tree leftTree;
    public Tree rightTree;
    public int value;
}