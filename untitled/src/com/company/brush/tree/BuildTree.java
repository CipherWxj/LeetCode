/**
 * @author: Wxj
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>输入描述:
 * preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * <p>输出描述:
 * [3,9,20,null,null,15,7]
 */
package com.company.brush.tree;

public class BuildTree {
    public TreeNode solution(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 递归建立二叉树
     * @param preorder 前序遍历数组
     * @param pLeft 前序遍历数组中 左子树 的起始位置
     * @param pRight 前序遍历数组中 右子树 的起始位置
     * @param inorder 中序遍历数组
     * @param iLeft 中序遍历数组中 左子树 的起始位置
     * @param iRight 中序遍历数组中 右子树 的起始位置
     * @return 根节点
     */
    public TreeNode build(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        // 终止条件：前序数组遍历完（前序数组从根节点开始遍历，比较好控制）
        if (pLeft == pRight) return null;

        // 根结点的值：前序数组的第一个值
        int rootValue = preorder[pLeft];

        // 在中序数组中找到 根节点的位置
        // 那么 rootIndex 左侧的所有元素都属于 root 的 左子树，右侧的所有元素都属于 root 的 右子树
        int rootIndex = 0;
        for (int i = iLeft; i <= iRight; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // 创建根节点
        TreeNode root = new TreeNode(rootValue);

        // 左子树节点的个数
        int leftLength = rootIndex - iLeft;

        // 递归建立左子树
        root.left = build(preorder, pLeft + 1, pLeft + leftLength + 1, inorder, iLeft, rootIndex - 1);
        // 递归建立右子树
        root.right = build(preorder, pLeft + leftLength + 1, pRight, inorder, rootIndex + 1, iRight);
        return root;
    }
}
