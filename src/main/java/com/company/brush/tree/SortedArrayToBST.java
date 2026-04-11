package com.company.brush.tree;

import static com.company.brush.tree.LevelOrder.levelOrder;

/**
 * @author: wangxinjian
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 * 平衡二叉树：一棵二叉树中每个节点的两个子树的高度差的绝对值不超过 1。
 * 二叉搜索树：左子树所有节点值小于根节点值，右子树所有节点值大于根节点值。
 * <p>输入描述:
 * nums = [-10,-3,0,5,9]
 * <p>输出描述:
 * 0,-10,5,null,-3,null,9
 */
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBalanceTree(nums, 0, nums.length - 1);
    }

    public static TreeNode buildBalanceTree(int[] nums, int start, int end) {
        // 终止条件：区间里没有数了
        if (end < start) return null;
        // 中间位置的节点作为根节点
        int mid = start + (end - start) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        // 递归构建左子树和右子树
        midNode.left = buildBalanceTree(nums, start, mid - 1);
        midNode.right = buildBalanceTree(nums, mid + 1, end);
        return midNode;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(levelOrder(sortedArrayToBST(nums)));
    }
}
