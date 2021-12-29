/**
 * @author: Wxj
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>输入描述:
 * root = [1,null,2,3]
 * <p>输出描述:
 * [1,3,2]
 */
package com.company.brush.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfixOrderTraversal {
    static List<Integer> res = new ArrayList<>(); // 为了方便添加元素，将res放在方法外进行初始化

    public static List<Integer> solution(TreeNode root) {
        if (root == null) return res;
        // 遍历左子树
        if (root.left != null) {
            solution(root.left);
        }
        res.add(root.val);
        // 遍历右子树
        if (root.right != null) {
            solution(root.right);
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
