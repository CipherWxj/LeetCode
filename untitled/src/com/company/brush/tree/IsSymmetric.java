/**
 * @author: Wxj
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
package com.company.brush.tree;

import java.util.LinkedList;
import java.util.Scanner;

public class IsSymmetric {

    public static boolean solution(TreeNode root) {
//        return isSym1(root.left, root.right);
        return isSym2(root.left, root.right);
    }

    /**
     * 递归方法
     *
     * @param p 左子树
     * @param q 右子树
     * @return 结果
     */
    public static boolean isSym1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // 同为null
        if (p == null || q == null) return false; // 二者其一为null
        if (p.val != q.val) return false; // 值不等
        //  左子树的左孩子 = 右子树的右孩子
        //  左子树的右孩子 = 右子树的左孩子
        return isSym1(p.left, q.right) && isSym1(p.right, q.left); // 递归
    }

    /**
     * 迭代方法
     *
     * @param p 左子树
     * @param q 右子树
     * @return 结果
     */
    public static boolean isSym2(TreeNode p, TreeNode q) {

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            // 每次比较前两个节点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 同为null，进入下次循环
            if (left == null && right == null) {
                continue;
            }
            // 二者其一为null，返回false
            if (left == null || right == null) {
                return false;
            }
            // 值不等，返回false
            if (left.val != right.val) {
                return false;
            }
            // 左子树的左孩子 = 右子树的右孩子
            queue.add(left.left);
            queue.add(right.right);
            // 左子树的右孩子 = 右子树的左孩子
            queue.add(left.right);
            queue.add(right.left);
        }
        return true; // 遍历完，为true
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数组形式的【层序遍历】二叉树：");
        System.out.print("root= ");
        TreeNode root = input();
        System.out.println(solution(root));
    }

    public static TreeNode input() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        Integer[] arr = new Integer[str.length];
        for (int i = 0; i < arr.length; i++) {
            if (str[i].equals("")) {
                arr[i] = null;
            } else arr[i] = Integer.parseInt(str[i]);
        }
        CreatBinaryTree Tree = new CreatBinaryTree(arr);
        return Tree.layerCreat(0);
    }
}
