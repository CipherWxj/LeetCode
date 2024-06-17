/**
 * @author: Wxj
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>输入描述:
 * root = [3,9,20,null,null,15,7]
 * <p>输出描述:
 * true
 */
package com.company.brush.tree.dfs;

import com.company.brush.tree.TreeNode;

public class IsBalanced {
    // 类的全局变量，标记是否是平衡二叉树
    boolean flag = true;

    public boolean solution(TreeNode root) {
        dfs(root);
        return flag;
    }

    // DFS
    public int dfs(TreeNode root) {
        // 终止条件
        if (root == null) return 0;
        // 左子树的高度
        int leftHeight = dfs(root.left);
        // 右子树的高度
        int rightHeight = dfs(root.right);
        // 不满足条件，标记为 false
        if (Math.abs(leftHeight - rightHeight) > 1) {
            flag = false;
        }
        // 高度+1，root的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
