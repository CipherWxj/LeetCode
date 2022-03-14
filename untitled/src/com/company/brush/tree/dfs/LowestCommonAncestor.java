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
        if (root==null || root==p || root==q) return root;
        TreeNode left=solution(root.left,p,q);
        TreeNode right= solution(root.right,p,q);
        if (left==null)return right;
        if (right==null)return left;
        return root;
    }



}
