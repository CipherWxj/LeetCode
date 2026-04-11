package com.company.brush.tree;

/**
 * @author: wangxinjian
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
public class DiameterOfBinaryTree {
    // 最大直径
    static int ans = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        // 找最大深度
        int maxDepth = searchMaxDepth(root);
        return ans;
    }

    public static int searchMaxDepth(TreeNode root) {
        if (root == null) return 0;
        // 左子树的最大深度
        int leftDepth = searchMaxDepth(root.left);
        // 右子树的最大深度
        int rightDepth = searchMaxDepth(root.right);
        // 最大直径 = 左子树最大深度 + 右子树最大深度
        // 可能不经过根节点，所以在递归过程中更新最大直径
        ans = Math.max(ans, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        TreeNode root = new TreeNode(nums);
        System.out.println(diameterOfBinaryTree(root));
    }
}
