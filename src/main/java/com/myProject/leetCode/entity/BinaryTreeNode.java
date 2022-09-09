package com.myProject.leetCode.entity;

/**
 * @author ZhangYijing
 * @Description 二叉树
 * @Date 2022/5/9
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public static BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode l1Left = new BinaryTreeNode(3);
        BinaryTreeNode l1Right = new BinaryTreeNode(7);
        BinaryTreeNode l21Left = new BinaryTreeNode(2);
        BinaryTreeNode l21Right = new BinaryTreeNode(4);
        BinaryTreeNode l22Left = new BinaryTreeNode(6);
        BinaryTreeNode l22Right = new BinaryTreeNode(8);

        root.left = l1Left;
        root.right = l1Right;

        l1Left.left = l21Left;
        l1Left.right = l21Right;
        l1Right.left = l22Left;
        l1Right.right = l22Right;

        return root;
    }
}