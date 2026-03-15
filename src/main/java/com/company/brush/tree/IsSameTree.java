/**
 * @author: Wxj
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>输入描述:
 * p = [1,2,3], q = [1,2,3]
 * <p>输出描述:
 * true
 */
package com.company.brush.tree;

import java.util.Scanner;

public class IsSameTree {

    public static boolean solution(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // 同为null
        if (p == null || q == null) return false; // 二者其一为null
        if (p.val != q.val) return false; // 值不等
        return solution(p.left, q.left) && solution(p.right, q.right); // 递归，左右子树都要相同
    }

    public static void main(String[] args) {
        System.out.println("请输入两个数组形式的【层序遍历】二叉树：");
        System.out.print("p= ");
        TreeNode p = input();
        System.out.print("q= ");
        TreeNode q = input();
        System.out.println(solution(p, q));
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
