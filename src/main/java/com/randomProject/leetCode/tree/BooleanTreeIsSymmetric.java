package com.randomProject.leetCode.tree;

import com.randomProject.entity.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhangYijing
 * @Description 判断二叉树是否对称
 *      1
 *     /\
 *    2 2
 *   /\ /\
 *  3 4 4 3
 * @Date 2022/5/9
 */
public class BooleanTreeIsSymmetric {


    public void isSymmetric(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        boolean check = check(treeNode.left, treeNode.right);
    }

    public boolean check(BinaryTreeNode left, BinaryTreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.value == right.value && check(left.left, right.right) && check(left.right, right.left);
    }

    /**
     * add()和offer()都是向队列中添加一个元素。一些队列有大小限制，
     * 因此如果想在一个满的队列中加入一个新项，调用 add() 方法就会抛出一个 unchecked 异常，
     * 而调用 offer() 方法会返回 false。因此就可以在程序中进行有效的判断！
     * @param treeNode
     * @return
     */
    public boolean QueueCheck(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(treeNode.left);
        queue.offer(treeNode.right);

        while (!queue.isEmpty()) {
            BinaryTreeNode right = queue.poll();
            BinaryTreeNode left = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (right.value != left.value) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

}