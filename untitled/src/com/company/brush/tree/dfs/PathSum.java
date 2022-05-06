/**
 * @author: Wxj
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>输入描述:
 * root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * <p>输出描述:
 * [[5,4,11,2],[5,8,4,5]]
 */
package com.company.brush.tree.dfs;

import com.company.brush.tree.CreatBinaryTree;
import com.company.brush.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static List<List<Integer>> solution(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, res, new ArrayList<>());
        return res;
    }

    public static void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> ans) {
        // 终止条件
        if (root == null) return;
        // 更新targetSum，添加节点值
        targetSum -= root.val;
        ans.add(root.val);
        // 判断 ！！从根节点到叶子节点！！ 整个路径
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(ans));
            // 这里的回溯不能少！！
            // 满足条件return的话不会执行最后一行的回溯，所以在这里添加回溯（去掉return就不需要了）
            ans.remove(ans.size() - 1);
            return;
        }
        // 左递归
        dfs(root.left, targetSum, res, ans);
        // 右递归
        dfs(root.right, targetSum, res, ans);
        // 回溯
        ans.remove(ans.size() - 1);
    }

    public static void main(String[] args) {
        CreatBinaryTree tree = new CreatBinaryTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        TreeNode root = tree.layerCreat(0);
        int targetSum = 22;
        System.out.println(solution(root,targetSum));
    }
}
