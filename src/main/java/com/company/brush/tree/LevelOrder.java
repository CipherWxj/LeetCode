package com.company.brush.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wangxinjian
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>输入描述:
 * root = [3,9,20,null,null,15,7]
 * <p>输出描述:
 * [[3],[9,20],[15,7]]
 */
public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 初始化队列，一次存一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 获取当前层的节点数
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                // 将下一层的节点加入队列
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            // 遍历完一层，将该层节点值加入结果中
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = new TreeNode(nums);
        System.out.println(levelOrder(root));
    }
}
