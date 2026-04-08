package com.company.brush.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangxinjian
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>输入描述:
 * root = [1,2,2,3,4,4,3]
 * <p>输出描述:
 * true
 */
public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        // return isSymmetricWithRecursion(root.left, root.right);
        return isSymmetricWithIteration(root.left, root.right);
    }

    public static boolean isSymmetricWithRecursion(TreeNode l, TreeNode r) {
        // 两个节点都为空，对称
        if (l == null && r == null) return true;
        // 两个节点中只有一个为空，不对称
        if (l == null || r == null) return false;
        // 两个节点都不为空，值不相等，不对称
        if (l.val != r.val) return false;
        // 两个节点都不为空，值相等，递归子节点
        return isSymmetricWithRecursion(l.left, r.right) && isSymmetricWithRecursion(l.right, r.left);
    }

    public static boolean isSymmetricWithIteration(TreeNode l, TreeNode r) {
        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(l);
        queue.add(r);

        while (!queue.isEmpty()) {
            // 每次比较前两个节点
            TreeNode right = queue.poll();
            TreeNode left = queue.poll();
            // 两个节点都为空，对称
            if (left == null && right == null) {
                continue;
            }
            // 两个节点中只有一个为空，不对称
            if (left == null || right == null) {
                return false;
            }
            // 两个节点都不为空，值不相等，不对称
            if (left.val != right.val) {
                return false;
            }
            // 两个节点都不为空，值相等，继续比较子节点
            // 左子树的左孩子与右子树的右孩子比较
            queue.add(left.left);
            queue.add(right.right);
            // 左子树的右孩子与右子树的左孩子比较
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = new TreeNode(nums);
        System.out.println(isSymmetric(root));

    }

}
