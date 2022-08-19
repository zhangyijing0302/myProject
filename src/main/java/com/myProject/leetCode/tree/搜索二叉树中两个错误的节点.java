package com.myProject.leetCode.tree;

import com.myProject.entity.BinaryTreeNode;
import org.junit.Test;

/**
 * @author ZhangYijing
 * @Description 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请按升序输出这两个错误节点的值
 * @Date 2022/5/10
 */
public class 搜索二叉树中两个错误的节点 {



    @Test
    public void findTwoNode() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        BinaryTreeNode right = new BinaryTreeNode(3);
        root.right = right;
        root.left = left;
        int[] impl = findImpl(root);
        System.out.println(impl[0] + "--" + impl[1]);

    }

    public int[] findImpl(BinaryTreeNode treeNode) {

        // findNodeLeft
        if (treeNode.left != null) {
            if (treeNode.left.value > treeNode.value) {
                return new int[]{treeNode.value, treeNode.left.value};
            } else {
                findImpl(treeNode.left);
            }
        }
        // findNodeRight
        if (treeNode.right != null) {
            if (treeNode.right.value < treeNode.value) {
                return new int[]{treeNode.right.value, treeNode.value};
            } else {
                findImpl(treeNode.right);
            }
        }

        return new int[]{0, 0};
    }

    int[] result = new int[2];
    BinaryTreeNode pre;
    int index = 1;
    public int[] findError (BinaryTreeNode root) {
        // write code here
        //二叉搜索树中序遍历是升序的，可能交换顺序的两个数不是相连的，所以需要从头到尾遍历一遍
        if(root == null)
            return result;

        findError(root.left);

        if(pre == null)
            pre = root;

        if(index == 1 && root.value < pre.value){
            result[index] = pre.value;
            index--;
        }

        if(index == 0 && root.value < pre.value)   //碰到合适的并不会停止，而是一直遍历，
            result[index] = root.value;          //直到结束，即查找最后一个符合条件的节点

        pre = root;

        findError(root.right);

        return result;

    }
}