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
package com.company.brush.tree.bfs;


import com.company.brush.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 方法1：BFS com/company/brush/tree/bfs/RightSideView.java
 * 方法2：DFS com/company/brush/tree/dfs/RightSideView.java
 */
public class RightSideView {
    public static List<Integer> solution1(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        // 注意List null 和 [] 的不同
        if (root == null) return list;

        // 层序遍历
        // 将每层最后一个节点的值添加进 list
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (i == n - 1) list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return list;
    }
}
