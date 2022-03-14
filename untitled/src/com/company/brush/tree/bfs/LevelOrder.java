/**
 * @author: Wxj
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>输入描述:
 * root = [3,9,20,null,null,15,7]
 * <p>输出描述:
 * [[3],[9,20],[15,7]]
 */
package com.company.brush.tree.bfs;

import com.company.brush.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); // 结果

        Queue<TreeNode> queue = new LinkedList<>(); // 初始化一个队列
        queue.offer(root); // 根节点入列

        // 遍历
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            // 每次遍历一层
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll(); // 队列最前端元素出队列
                level.add(node.val);
                // 左右子节点入列
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        res.add(level);
        }
        return res;
    }
}
