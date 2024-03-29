/**
 * @author: Wxj
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 * <p>输入描述:
 * nums = [1,2,3]
 * <p>输出描述:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
package com.company.brush.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permute {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length]; // 记录是否已经遍历，初始全为 false
        backtrack(nums, visited, res, new ArrayList<Integer>());
        return res;
    }

    public static void backtrack(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> ans) {
        // 返回
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
        }
        // 遍历搜索，每一次遍历都从 数组的第一个元素 开始，这一轮已经遍历的元素跳过
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue; // 跳过已经遍历的元素
            visited[i] = true; // 标记
            ans.add(nums[i]); // 添加
            backtrack(nums, visited, res, ans); // dfs
            // 回溯
            ans.remove(ans.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数组：");
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solution(nums));
    }
}
