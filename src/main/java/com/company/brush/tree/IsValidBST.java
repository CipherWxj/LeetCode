package com.company.brush.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangxinjian
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>输入描述:
 * root = [5,1,4,null,null,3,6]
 * <p>输出描述:
 * false
 */
public class IsValidBST {

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTWithRecursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTWithRecursion(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBSTWithRecursion(root.left, min, root.val) && isValidBSTWithRecursion(root.right, root.val, max);
    }

    public static boolean isValidBSTWithIteration(TreeNode root) {
        if (root == null) return true;
        // 二叉搜索树中序遍历的数组，应该是一个递增的数组
        // 初始化前一个节点的值为最小long值
        long pre = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 只要当前节点的值小于等于前一个节点的值，就返回false
            if (root.val <= pre) return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums = {5,1,4,null,null,3,6};
        TreeNode root = new TreeNode(nums);
        System.out.println(isValidBST(root));
        System.out.println(isValidBSTWithIteration(root));
    }
}
