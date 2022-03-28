/**
 * @author: Wxj
 * 40. 组合总和 II
 * 给定一个候选人编号的集合candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * <p>输入描述:
 * candidates = [10,1,2,7,6,1,5], target = 8
 * <p>输出描述:
 * [[1,1,6],[1,2,5],[1,7],[2,6]]
 */
package com.company.brush.backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum2 {
    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); // 结果List
        ArrayList<Integer> temp = new ArrayList<Integer>(); // 子集
        Arrays.sort(candidates); // 排序
        // 按子集长度遍历回溯查找
        dfs(candidates, res, temp, 0, target);
        return res;
    }

    /**
     * dfs
     *
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
        // target>0, 继续遍历数组
        for (int j = i; j < nums.length; j++) {
            // 去除重复
            if (j != i && nums[j] == nums[j - 1]) continue;
            temp.add(nums[j]); // 添加数组元素
            // 同一个 数字只能选一次，从当前元素继续递归
            dfs(nums, res, temp, j + 1, target - nums[j]);
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
