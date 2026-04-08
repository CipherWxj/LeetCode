package com.company.brush.tree;

import java.util.LinkedList;
import java.util.Queue;

// 树节点类
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 根据数组层序创建树
     * @param arr 数组
     */
    public TreeNode(Integer[] arr) {
        if (arr.length > 0) {
            this.val = arr[0];
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (index < arr.length) {
                    if (arr[index] != null) {
                        cur.left = new TreeNode(arr[index++]);
                        queue.add(cur.left);
                    } else {
                        cur.left = null;
                        index++;
                    }
                }
                if (index < arr.length) {
                    if (arr[index] != null) {
                        cur.right = new TreeNode(arr[index++]);
                        queue.add(cur.right);
                    } else {
                        cur.right = null;
                        index++;
                    }
                }
            }
        }
    }
}