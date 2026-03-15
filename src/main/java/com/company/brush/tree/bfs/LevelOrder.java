/**
 * @author: Wxj
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>输入描述:
 * root = [3,9,20,null,null,15,7]
 * <p>输出描述:
 * [[3],[9,20],[15,7]]
 */
package com.company.brush.tree.bfs;

import com.company.brush.tree.CreatBinaryTree;
import com.company.brush.tree.TreeNode;

import java.util.*;

public class LevelOrder {
    public static List<List<Integer>> solution(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>(); // 结果

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>(); // 初始化一个队列
        queue.add(root); // 根节点入列

        // 遍历
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = queue.size(); // 这个很重要！！！如果直接for循环控制用queue.size会报错，因为queue一直在动态变化
            // 每次遍历一层
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll(); // 队列最前端元素出队列
                level.add(node.val);
                // 左右子节点入列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数组形式的【层序遍历】二叉树：");
        Scanner sc=new Scanner(System.in);
        System.out.print("root= ");
        String s=sc.nextLine();
        s=s.substring(1,s.length()-1);
        String[] str=s.split(",");
        Integer[] arr=new Integer[str.length];
        for (int i = 0; i < arr.length; i++) {
            if(str[i].equals("")){
                arr[i]= null;
            }else arr[i]=Integer.parseInt(str[i]);
        }
        CreatBinaryTree Tree=new CreatBinaryTree(arr);
        TreeNode root=Tree.layerCreat(0);
        System.out.println(solution(root));
    }
}
