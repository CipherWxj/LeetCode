package com.company.brush.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangxinjian
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>输入描述:
 * root = [3,9,20,null,null,15,7]
 * <p>输出描述:
 * 3
 */
public class MaxDepth {
    // 深度优先搜索
    public static int maxDepthDFS(TreeNode root) {
        // 终止条件
        if (root == null) return 0;
        // 递归左子树和右子树，取最大值加1
        int leftDepth = maxDepthDFS(root.left);
        int rightDepth = maxDepthDFS(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 广度优先搜索
    public static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 层序遍历，每遍历完一层深度加1
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            max++;
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = new TreeNode(nums);
        System.out.println(maxDepthDFS(root));
        System.out.println(maxDepthBFS(root));
    }
}
