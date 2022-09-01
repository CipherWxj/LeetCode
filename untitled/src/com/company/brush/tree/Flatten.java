/**
 * @author: Wxj
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>输入描述:
 * root = [1,2,5,3,4,null,6]
 * <p>输出描述:
 * [1,null,2,null,3,null,4,null,5,null,6]
 */
package com.company.brush.tree;

import java.util.ArrayList;
import java.util.List;

public class Flatten {
    List<TreeNode> list = new ArrayList<>(); // 存储前序遍历的节点

    public void solution(TreeNode root) {
        // 前序遍历
        dfs(root);
        // 根据前序遍历的顺序组成链表
        TreeNode cur = root;
        for (int i = 1; i < list.size(); i++) {
            cur.left = null; // 根据题意，左节点断开
            cur.right = list.get(i); // 右节点连接后继节点
            cur = cur.right;
        }
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }

    // 如果一个节点的左子节点不为空，则该节点的左子树中的最后一个节点被访问之后，该节点的右子节点被访问。
    // 该节点的左子树中最后一个被访问的节点是左子树中的最右边的节点，也是该节点的前驱节点。
    // 该问题转化为寻找当前节点的前驱节点
    public void solution1(TreeNode root) {
        TreeNode cur = root;
        // 遍历
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode preNode = next; // 最右侧节点记为 前驱节点
                // 找左子树的最右侧节点
                while (preNode.right != null) {
                    preNode = preNode.right;
                }
                // 连接
                preNode.right = cur.right;
                // 断开左子树
                cur.left = null;
                // 连接右子树
                cur.right = next;
            }
            // 一直向右遍历
            cur = cur.right;
        }
    }
}
