/**
 * @author: Wxj
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>输入描述:
 * root = [3,1,4,null,2], k = 1
 * <p>输出描述:
 * 1
 */
package com.company.brush.tree;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallest {
    int res = 0, count = 0; // 维护两个全局变量，方便 dfs 查找

    public int solution1(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    // dfs 中序遍历
    public void dfs(TreeNode root, int k) {
        // 终止条件：找到了 第 k 个
        if (count == k) return;
        // 左递归
        if (root.left != null) {
            dfs(root.left, k);
        }
        // 计数
        count++;
        // 赋值
        if (count == k) res = root.val;
        // 右递归
        if (root.right != null) {
            dfs(root.right, k);
        }
    }

    // 栈写法
    public int solution2(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) break;
            root = root.right;

        }
        return root.val;
    }
}
