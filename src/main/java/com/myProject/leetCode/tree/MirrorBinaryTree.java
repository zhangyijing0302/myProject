package com.myProject.leetCode.tree;

import com.myProject.leetCode.entity.BinaryTreeNode;

import java.util.HashMap;

/**
 * @author ZhangYijing
 * @Description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Date 2022/5/9
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {
        new HashMap<>();
    }

    public void mirror(BinaryTreeNode tree) {
        if (tree == null) {
            return;
        }
        BinaryTreeNode temp;
        temp = tree.right;
        tree.right = tree.left;
        tree.left = temp;
        mirror(tree.left);
        mirror(tree.right);
    }
}

