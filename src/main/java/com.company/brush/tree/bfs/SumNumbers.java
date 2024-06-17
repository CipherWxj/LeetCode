/**
 * @author: Wxj
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * <p>输入描述:
 * root = [4,9,0,5,1]
 * <p>输出描述:
 * 1026
 */
package com.company.brush.tree.bfs;

import com.company.brush.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 法1：dfs com/company/brush/tree/bfs/SumNumbers.java
// 法2：bfs com/company/brush/tree/dfs/SumNumbers.java
public class SumNumbers {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return bfs(root);
    }

    public int bfs(TreeNode root) {
        // 节点队列
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        // 自上而下遍历，对应遍历到该节点的和
        Queue<Integer> sumQueue = new LinkedList<>();
        int sum = 0;

        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = sumQueue.poll();

            // 遍历到叶节点
            if (node.left == null && node.right == null) {
                sum += num;
            }
            // 判断左子树
            if (node.left != null) {
                nodeQueue.offer(node.left);
                sumQueue.offer(num * 10 + node.left.val);
            }
            // 右子树
            if (node.right != null) {
                nodeQueue.offer(node.right);
                sumQueue.offer(num * 10 + node.right.val);
            }
        }
        return sum;
    }
}

