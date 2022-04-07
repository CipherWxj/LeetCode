/**
 * @author: Wxj
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>输入描述:
 * root = [-10,9,20,null,null,15,7]
 * <p>输出描述:
 * 42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
package com.company.brush.tree;

public class MaxPathSum {
    // 结果初始化为最小值，作为类的全局变量
    int res = Integer.MIN_VALUE;

    public int solution(TreeNode root) {
        maxSum(root);
        return res;
    }

    public int maxSum(TreeNode root) {
        if (root == null) return 0; // 递归到最底层，返回0

        // 向左递归，如果左子树的路径和小于0，则舍弃左子树路径
        int leftSum = Math.max(maxSum(root.left), 0);
        // 向右递归，如果右子树的路径和小于0，则舍弃右子树路径
        int rightSum = Math.max(maxSum(root.right), 0);

        // 以该节点作为根节点的最大路径和
        int rootSum = root.val + leftSum + rightSum;

        // 以该节点作为路径节点之一的贡献值
        // 仍需向上合并，并且同时只能选择一条子树
        int rootUp = root.val + Math.max(leftSum, rightSum);

        // 更新最大路径和
        res = Math.max(res, rootSum);

        // 返回最大贡献，向上合并
        return rootUp;
    }
}
