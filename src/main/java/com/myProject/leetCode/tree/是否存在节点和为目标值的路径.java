package com.myProject.leetCode.tree;

import com.myProject.leetCode.entity.BinaryTreeNode;

/**
 * @author ZhangYijing
 * @Description 二叉树中是否存在节点和为指定值的路径
 * @Date 2022/5/10
 */
public class 是否存在节点和为目标值的路径 {

    public boolean isExists(BinaryTreeNode treeNode, int sum) {

        if (treeNode == null) {
            return false;
        }
        sum += treeNode.value;

        if (sum == 88 && treeNode.left == null && treeNode.right == null) {
            return true;
        }

        return isExists(treeNode.left, sum) || isExists(treeNode.right, sum);
    }
}