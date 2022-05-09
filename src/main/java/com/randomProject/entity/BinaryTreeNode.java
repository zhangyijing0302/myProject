package com.randomProject.entity;

/**
 * @author ZhangYijing
 * @Description 二叉树
 * @Date 2022/5/9
 */
public class BinaryTreeNode {
    public String value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(String value) {
        this.value = value;
    }

    public static BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode("ROOT");
        BinaryTreeNode l1Left = new BinaryTreeNode("1L");
        BinaryTreeNode l1Right = new BinaryTreeNode("1R");
        BinaryTreeNode l21Left = new BinaryTreeNode("1L1L");
        BinaryTreeNode l21Right = new BinaryTreeNode("1L1R");
        BinaryTreeNode l22Left = new BinaryTreeNode("1L2L");
        BinaryTreeNode l22Right = new BinaryTreeNode("1L2R");

        root.left = l1Left;
        root.right = l1Right;

        l1Left.left = l21Left;
        l1Left.right = l21Right;
        l1Right.left = l22Left;
        l1Right.right = l22Right;

        return root;
    }
}