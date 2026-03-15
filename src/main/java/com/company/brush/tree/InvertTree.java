/**
 * @author: Wxj
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>输入描述:
 * root = [4,2,7,1,3,6,9]
 * <p>输出描述:
 * [4,7,2,9,6,3,1]
 */
package com.company.brush.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    // dfs
    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        // 从根节点向下遍历，就是从叶节点开始交换，逐层往上
        // 指针 left、right 分别指向转换后的子节点
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        // 交换
        root.left = right;
        root.right = left;
        return root;
    }

    // bfs
    public TreeNode bfs(TreeNode root) {
        // 排除特殊情况的干扰
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 层序遍历
        while (!queue.isEmpty()) {
            // 每一层节点数，一层一层的遍历（不需要也可）
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                // 交换操作
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                // 节点入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
