/**
 * @author: Wxj
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 前序 遍历。
 * <p>输入描述:
 * root = [1,null,2,3]
 * <p>输出描述:
 * [1,2,3]
 */
package com.company.brush.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal {
    static List<Integer> res = new ArrayList<>(); // 为了方便添加元素，将res放在方法外进行初始化

    // 递归
    public static List<Integer> solution(TreeNode root) {
        if (root == null) return res;
        // 先将父节点的值添加
        res.add(root.val);
        // 遍历左子树
        if (root.left != null) {
            solution(root.left);
        }
        // 遍历右子树
        if (root.right != null) {
            solution(root.right);
        }
        return res;
    }

    // 迭代
    public static List<Integer> solution1(TreeNode root) {
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            // 一直遍历到左子树最底层
            while (root != null) {
                // 遍历到父节点添加
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            // 依次出栈，遍历右子树
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}
