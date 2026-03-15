/**
 * @author: Wxj
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，
 * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>输入描述:
 * [1,2,3,null,5,null,4]
 * <p>输出描述:
 * [1,3,4]
 */
package com.company.brush.tree.dfs;


import com.company.brush.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * 方法1：BFS com/company/brush/tree/bfs/RightSideView.java
 * 方法2：DFS com/company/brush/tree/dfs/RightSideView.java
 */
public class RightSideView {

    static List<Integer> list = new ArrayList<>();

    public static List<Integer> solution2(TreeNode root) {

        dfs(root, 0);
        return list;
    }

    public static void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (list.size() == depth) list.add(root.val); // 第一次出现该深度，添加
        depth++;
        // 先向右子树递归搜索
        dfs(root.right, depth);
        // 右子树不存在，则向左子树递归搜索
        dfs(root.left, depth);
    }
}
