/**
 * @author: Wxj
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * 并且每个节点值不同，请你构造并返回这颗二叉树。
 * <p>输入描述:
 * inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * <p>输出描述:
 * [3,9,20,null,null,15,7]
 * 解释：输出层序遍历
 */
package com.company.brush.tree;

import java.util.HashMap;
import java.util.Map;

// 后序遍历：左子树->右子树->根节点  【根节点在最后！】
// 中序遍历：左子树->根节点->右子树  【根节点左侧都属于左子树，右侧都属于右子树！】
public class BuidTree {
    int curRootIdx; // 当前节点（子树根节点）在后序遍历中的索引位置
    int[] inorder; // 中序数组
    int[] postorder; // 后序数组
    Map<Integer, Integer> map = new HashMap<>(); // 存储 <节点值, 在中序中的索引>   （题目说了节点值各不相同）

    public TreeNode solution(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.curRootIdx = postorder.length - 1; // 根节点在后序数组最末尾
        int index = 0;
        for (int val : inorder) {
            map.put(val, index++);
        }
        return build(0, inorder.length - 1);
    }

    public TreeNode build(int l, int r) {
        // 当前子树创建完
        if (l > r) return null;
        // 创建当前节点
        TreeNode root = new TreeNode(postorder[curRootIdx]);
        // 找到其在中序数组中的位置，分割左右子树
        int index = map.get(postorder[curRootIdx]);
        // 因为后序数组倒序来看跟根节点相邻的就是右子树的根节点
        // 我们只需要先构建右子树，依次 -1，避免用Map记录后序数组中节点值位置的麻烦
        curRootIdx--;
        // 先构建右子树，后构建左子树！！！
        root.right = build(index + 1, r);
        root.left = build(l, index - 1);
        return root;
    }
}
