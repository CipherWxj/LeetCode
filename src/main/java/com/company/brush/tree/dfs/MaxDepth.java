/**
 * @author: Wxj
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>输入描述:
 * root = [3,9,20,null,null,15,7]
 * <p>输出描述:
 * 3
 */
package com.company.brush.tree.dfs;

import com.company.brush.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    // DFS
    public int dfs(TreeNode root, int max) {
        // 终止条件
        if (root == null) return max;
        // 左子树最大深度
        int leftDepth = dfs(root.left, max);
        // 右子树最大深度
        int rightDepth = dfs(root.right, max);
        // 取最大，并加上父节点的深度
        max = Math.max(leftDepth, rightDepth) + 1;
        return max;
    }

    // BFS
    public int bfs(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 层序遍历，每遍历完一层深度 +1
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
}
