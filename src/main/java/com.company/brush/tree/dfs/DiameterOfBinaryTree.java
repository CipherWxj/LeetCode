/**
 * @author: Wxj
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]
 * <p>输入描述:
 * root = [1,2,3,4,5]
 * <p>输出描述:
 * 3
 */
package com.company.brush.tree.dfs;

import com.company.brush.tree.TreeNode;

public class DiameterOfBinaryTree {
    // 最大直径
    int max = 0;

    public int solution(TreeNode root) {
        dfs(root);
        return max;
    }

    // DFS
    public int dfs(TreeNode root) {
        // 终止条件
        if (root == null) return 0;
        // 左子树的深度
        int left = dfs(root.left);
        // 左子树的深度
        int right = dfs(root.right);
        // 更新最大直径：左子树深度+右子树深度
        max = Math.max(max, left + right);
        // 返回最大深度
        return Math.max(left, right) + 1;
    }
}
