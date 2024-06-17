/**
 * @author: Wxj
 * 145. 二叉树的后序遍历
 * 给定一个二叉树的根节点 root ，返回它的 后序 遍历。
 * <p>输入描述:
 * root = [1,null,2,3]
 * <p>输出描述:
 * [3,2,1]
 */
package com.company.brush.tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    // 递归
    public List<Integer> solution(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    // DFS
    public void dfs(TreeNode root, List<Integer> list) {
        if(root == null) return;
        // 左子树
        dfs(root.left, list);
        // 右子树
        dfs(root.right, list);
        // 根节点
        list.add(root.val);
    }
}
