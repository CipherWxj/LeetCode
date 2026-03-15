/**
 * @author: Wxj
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>输入描述:
 * root = [3,9,20,null,null,15,7]
 * <p>输出描述:
 * [[3],[20,9],[15,7]]
 */
package com.company.brush.tree.bfs;

import com.company.brush.tree.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {

    public static List<List<Integer>> solution(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>(); // 结果

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>(); // 初始化一个队列
        queue.add(root); // 根节点入列

        boolean isOrderLeft = true; // 用于标记从哪一端开始，true：左，false：右

        // 遍历
        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>(); // 双端队列
            int n = queue.size();
            // 每次遍历一层
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll(); // 队列最前端元素出队列
                if (isOrderLeft) {
                    // 从左端遍历，在队列末端添加
                    level.addLast(node.val);
                } else {
                    // 从右端遍历，在队列头部添加
                    level.addFirst(node.val);
                }
                // 左右子节点入列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(new LinkedList<>(level));
            isOrderLeft = !isOrderLeft; // 反转
        }
        return res;
    }
}
