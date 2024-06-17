/**
 * @author: Wxj
 * 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>输入描述:
 * 输入:
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 * <p>输出描述:
 * 4
 * 解释：最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 */
package com.company.brush.tree.bfs;

import com.company.brush.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {
    // bfs
    public int solution(TreeNode root){
        // 空
        if (root == null) return 0;

        // 初始化两个队列，一个队列用作常规bfs的节点队列，另一个双端队列编号
        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<Integer> count = new LinkedList<>(); // 要取首、尾的值，所以用双端队列

        // 两个队列元素数一模一样，你进我进，你出我出，如影随形
        // 按 完全二叉树 编号：左子节点2i+1,右子节点2i+2
        queue.offer(root);
        count.offer(0);
        while (!queue.isEmpty()){
            int n = queue.size();
            // 计算宽度
            maxWidth = Math.max(maxWidth, count.peekLast() - count.peekFirst() + 1);
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                int cou = count.poll();
                if (node.left != null){
                    // 左子节点
                    queue.offer(node.left);
                    count.offer(2 * cou + 1);
                }
                if (node.right != null){
                    // 右子节点
                    queue.offer(node.right);
                    count.offer(2 * cou - 1);
                }
            }
        }
        return maxWidth;
    }
}
