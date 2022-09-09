package com.myProject.leetCode.tree;

import com.myProject.leetCode.entity.BinaryTreeNode;
import org.junit.Test;

/**
 * @author ZhangYijing
 * @Description 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * @Date 2022/5/10
 */
public class 二叉搜索树的第k个节点 {
    BinaryTreeNode target = null;
    int count = 0;

    @Test
    public void test() {
        BinaryTreeNode binaryTreeNode = BinaryTreeNode.buildTree();
        findTargetNode(binaryTreeNode, 3);
        System.out.println(target.value);
    }

    public void findTargetNode(BinaryTreeNode binaryTreeNode, int i) {
        if (count < i && binaryTreeNode.left != null) {
            findTargetNode(binaryTreeNode.left, i);
        }
        count++;
        if (count == i) {
            target = binaryTreeNode;
        }
        if (count < i && binaryTreeNode.right != null) {
            findTargetNode(binaryTreeNode.right, i);
        }
    }
}