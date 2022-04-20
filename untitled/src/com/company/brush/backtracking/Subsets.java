/**
 * @author: Wxj
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>输入描述:
 * nums = [1,2,3]
 * <p>输出描述:
 * [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
package com.company.brush.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // 结果List
        ArrayList<Integer> temp = new ArrayList<Integer>(); // 子集
        // 按子集长度遍历回溯查找
        for (int length = 0; length <= nums.length; length++) {
            backtracking(nums, res, temp, 0, length);
        }
        return res;
    }

    /**
     * 回溯
     * @param nums 数组
     * @param res 结果List
     * @param temp 当前子集
     * @param i 递归元素索引
     * @param length 子集长度
     */
    public static void backtracking(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int i, int length) {
        if (temp.size() == length) {
//            res.add(temp); // 错误！！！会发生引用传递
            res.add(new ArrayList<>(temp)); // 子集copy，再添加
            return;
        }
        // 遍历数组
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]); // 添加数组元素
            backtracking(nums, res, temp, j + 1, length); // 递归
            temp.remove(temp.size() - 1); // 回溯擦除操作
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数组：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        List<List<Integer>> res = solution(nums);
        System.out.println(res);
    }
}
