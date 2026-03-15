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
package com.company.brush.tree.dfs;

import com.company.brush.tree.TreeNode;

public class SumNumbers {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int ans) {
        // 根节点在高位，先把值计算出来
        ans = ans * 10 + root.val;
        // 终止条件：遍历到叶子节点
        if (root.left == null && root.right == null) {
            return ans;
        }
        int leftSum = 0, rightSum = 0;
        // 左子树
        if (root.left != null) {
            leftSum = dfs(root.left, ans);
        }
        // 右子树
        if (root.right != null) {
            rightSum = dfs(root.right, ans);
        }
        // 和
        return leftSum + rightSum;
    }
}

