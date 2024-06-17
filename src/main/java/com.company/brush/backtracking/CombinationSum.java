/**
 * @author: Wxj
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>输入描述:
 * candidates = [2,3,6,7], target = 7
 * <p>输出描述:
 * [[2,2,3],[7]]
 */
package com.company.brush.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); // 结果List
        ArrayList<Integer> temp = new ArrayList<Integer>(); // 子集
        // 按子集长度遍历回溯查找
        dfs(candidates, res, temp, 0, target);
        return res;
    }

    /**
     * dfs
     * @param nums   数组
     * @param res    结果List
     * @param temp   当前子集
     * @param i      递归元素索引
     * @param target 目标值
     */
    public static void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int i, int target) {
        // target==0，满足条件，添加进结果List
        if (target == 0) {
//            res.add(temp); // 错误！！！会发生引用传递
            res.add(new ArrayList<>(temp)); // 子集copy，再添加
            return;
        }
        // target<0，不满足条件，无需继续递归，返回
        if (target < 0) {
            return;
        }
        // target>0,继续遍历数组
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]); // 添加数组元素
            // 同一个 数字可以 无限制重复被选取，从当前元素继续递归
            dfs(nums, res, temp, j, target - nums[j]);
            // 回溯
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.print("candidates= ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] candidates = new int[str.length];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = Integer.parseInt(str[i]);
        }
        System.out.print("target= ");
        int target = sc.nextInt();
        List<List<Integer>> res = solution(candidates, target);
        System.out.println(res);
    }
}
