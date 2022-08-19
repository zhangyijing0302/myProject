package com.myProject.leetCode.tree;

import com.myProject.entity.BinaryTreeNode;

/**
 * @author ZhangYijing
 * @Description 求给定二叉树的最大深度
 * @Date 2022/5/9
 */
public class MaxLengthTree {


    public int maxDepth(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(maxDepth(treeNode.left), maxDepth(treeNode.right)) + 1;
    }
}