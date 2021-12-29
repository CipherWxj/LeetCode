package com.company.brush.tree;

import java.util.LinkedList;

public class CreatBinaryTree {

    Integer[] arr;

    public CreatBinaryTree(Integer[] arr) {
        this.arr = arr;
    }

    /**
     * 前序生成二叉树
     *
     * @param index 数组起始位置的索引
     * @return 根节点（树）
     */
    public TreeNode preCreat(int index) {

        if (arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode();
        // 数组中存在元素直接给节点赋值
        // 不存在元素则为 null
        if (arr[index] != null) {
            root.val = arr[index];
        }
        // 左子树
        if (index * 2 + 1 < arr.length) {
            root.left = preCreat(index * 2 + 1);
        }

        // 右子树
        if (index * 2 + 2 < arr.length) {
            root.right = preCreat(index * 2 + 2);
        }
        return root;
    }

    /**
     * 层序生成二叉树
     *
     * @param index 数组起始位置的索引
     * @return 根节点（树）
     */
    public TreeNode layerCreat(int index) {
        if (arr.length == 0) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>(); // 队列

        TreeNode root = new TreeNode(arr[index++]); // 根节点赋值，非空

        queue.add(root); // 根节点入列

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll(); // 顶上元素依次出列
            if (index < arr.length) {
                if (arr[index] != null) {
                    cur.left = new TreeNode(arr[index++]); // 左子树
                    queue.add(cur.left); // 末端入列
                } else {// 空结点不入列
                    cur.left = null;
                    index++;
                }
            }
            if (index < arr.length) {
                if (arr[index] != null) {
                    cur.right = new TreeNode(arr[index++]); // 右子树
                    queue.add(cur.right); // 末端入列
                } else {//空结点不入队
                    cur.right = null;
                    index++;
                }
            }
        }
        return root;
    }
}
