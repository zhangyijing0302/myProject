package com.randomProject.leetCode.tree;

import com.randomProject.entity.BinaryTreeNode;

/**
 * @author ZhangYijing
 * @Description 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 * 两颗二叉树是:
 * Tree 1
 *          1
 *         / \
 *        3   2
 *       /
 *      5
 *
 * Tree 2
 *         2
 *        / \
 *       1   3
 *          / \
 *         4   7
 *
 * 合并后的树为
 *         3
 *        / \
 *       4   5
 *      /   / \
 *     5   4   7
 * @Date 2022/5/10
 */
public class 合并二叉树 {

    public BinaryTreeNode buildTwoTree(BinaryTreeNode sourcetree, BinaryTreeNode targetTree) {

        mergeTree(sourcetree, targetTree);

        return null;
    }

    public void mergeTree(BinaryTreeNode sourcetree, BinaryTreeNode targetTree) {

        targetTree.value += sourcetree.value;
        if (sourcetree.left != null && targetTree.left != null) {
            mergeTree(sourcetree.left, targetTree.left);
        } else if (targetTree.left == null && sourcetree.left != null) {
            targetTree.left = sourcetree.left;
        }

        if (sourcetree.right != null && targetTree.right != null) {
            mergeTree(sourcetree.right, targetTree.right);
        } else if (targetTree.right == null && sourcetree.right != null) {
            targetTree.right = sourcetree.right;
        }
    }
}