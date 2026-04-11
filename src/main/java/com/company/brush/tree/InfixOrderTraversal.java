package com.company.brush.tree;

import java.util.*;

/**
 * @author: wangxinjian
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>输入描述:
 * root = [1,null,2,3]
 * <p>输出描述:
 * [1,3,2]
 */
class InfixOrderTraversal {

    public static List<Integer> infixOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return infixOrderTraversalWithRecursion(root, res);
    }

    // 递归
    public static List<Integer> infixOrderTraversalWithRecursion(TreeNode root, List<Integer> res) {
        if (root == null) return res;
        infixOrderTraversalWithRecursion(root.left, res);
        res.add(root.val);
        infixOrderTraversalWithRecursion(root.right, res);
        return res;
    }

    // 迭代
    public static List<Integer> infixOrderTraversalWithIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 初始化栈，存储遍历到的节点
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            // 一直遍历到左子树最底层
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 左子树为空，根节点出栈，添加到结果中
            root = stack.pop();
            res.add(root.val);
            // 遍历右子树
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode root = new TreeNode(nums);
        System.out.println(infixOrderTraversal(root));
        System.out.println(infixOrderTraversalWithIteration(root));
    }
}
