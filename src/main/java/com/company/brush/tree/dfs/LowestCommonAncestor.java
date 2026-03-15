/**
 * @author: Wxj
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>输入描述:
 * root = root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <p>输出描述:
 * 3
 */
package com.company.brush.tree.dfs;


import com.company.brush.tree.CreatBinaryTree;
import com.company.brush.tree.TreeNode;

import java.util.*;

public class LowestCommonAncestor {
    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 只要当前根节点是p和q中的任意一个，就返回（再深入没意义）
        if (root.val == p.val || root.val == q.val) return root;

        // 根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = solution(root.left, p, q);
        TreeNode right = solution(root.right, p, q);

        // 左子树没有找到，就返回右子树的结果
        if (left == null) return right;

        // 右子树没有找到，就返回左子树的结果
        if (right == null) return left;

        // 左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        return root;
    }

    public static void main(String[] args) {
        System.out.println("请以数组形式输入一个层序二叉树：");
        System.out.print("root= ");
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
        TreeNode root = Tree.layerCreat(0);
        System.out.print("p= ");
        TreeNode p = new TreeNode(sc.nextInt());
        System.out.print("q= ");
        TreeNode q = new TreeNode(sc.nextInt());
        System.out.println(solution(root,p,q).val);
    }

}
