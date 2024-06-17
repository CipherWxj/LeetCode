/**
 * @author: Wxj
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>输入描述：
 * [1,3,2,6,5]
 * <p>输出描述:
 * true
 */
package com.company.brush.tree;

public class VerifyPostorder {
    public boolean solution(int[] postorder) {
        if (postorder.length == 0) return true;
        return find(postorder, 0, postorder.length - 1);
    }

    // 区间搜索
    public boolean find(int[] postorder, int l, int r) {
        // 终止条件：左边界 >= 右边界，大于很重要
        if (l >= r) return true;
        // 该区间上根节点的值
        int root = postorder[r];
        // 从区间左侧开始遍历，直到遇到大于根结点的值
        // 所有小于根结点的值都属于左子树
        int i = l;
        while (postorder[i] < root) {
            i++;
        }
        // 在剩下的属于右子树的值中查询是否有小于根节点的值，不满足二叉搜索树的性质
        for (int j = i; j < r; j++) {
            if (postorder[j] < root) return false;
        }
        // 递归左右子树
        return find(postorder, l, i - 1) && find(postorder, i, r - 1);
    }
}
