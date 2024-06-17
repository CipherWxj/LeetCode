/**
 * @author: Wxj
 * 958. 二叉树的完全性检验
 * 给定一个二叉树的 root，确定它是否是一个完全二叉树。
 * 在一个完全二叉树中，除了最后一个关卡外，所有关卡都是完全被填满的，
 * 并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含 1 到 2h 节点之间的最后一级 h 。
 * <p>输入描述:
 * root = [1,2,3,4,5,null,7]
 * <p>输出描述:
 * false
 */
package com.company.brush.tree.bfs;

import com.company.brush.tree.TreeNode;

import java.util.*;

public class IsCompleteTree {
    public boolean solution(TreeNode root) {
        if(root == null) return false; // 不要也行，题目说明不为空
        Queue<TreeNode> queueNode = new LinkedList<>(); // 存节点
        Queue<Integer> queueIndex = new LinkedList<>(); // 存编号
        List<Integer> list = new ArrayList<>(); // 所有节点的编号都保留
        // BFS 套路
        // 每遍历一个节点就将编号添加到 list 中
        queueNode.offer(root);
        queueIndex.offer(0);
        list.add(0);
        while(!queueNode.isEmpty() && !queueIndex.isEmpty()) {
            int size = queueNode.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queueNode.poll();
                int index = queueIndex.poll();
                if(node.left != null) {
                    queueNode.offer(node.left);
                    queueIndex.offer(index * 2 + 1);
                    list.add(index * 2 + 1);
                }
                if(node.right != null) {
                    queueNode.offer(node.right);
                    queueIndex.offer(index * 2 + 2);
                    list.add(index * 2 + 2);
                }
            }
        }
        // 完全就是每一层从左到右节点都连续
        // 如果是完全的，list 的长度一定是 最后一个编号 + 1
        return list.size() - 1 == list.get(list.size() - 1);
    }
}
