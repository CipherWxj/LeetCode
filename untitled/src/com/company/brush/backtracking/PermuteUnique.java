/**
 * @author: Wxj
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>输入描述:
 * nums = [1,1,2]
 * <p>输出描述:
 * [[1,1,2],[1,2,1],[2,1,1]]
 */
package com.company.brush.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PermuteUnique {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        // 这一步的排序很重要！！！为了去除重复排列
        Arrays.sort(nums);

        backtrack(nums, visited, res, new ArrayList<>());
        return res;
    }

    public static void backtrack(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> ans) {
        // 终止条件：排列长度等于数组长度
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans)); // 复制，直接添加报错
        }
        // 遍历搜索，每一次遍历都从 数组的第一个元素 开始，这一轮已经遍历的元素跳过
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue; // 跳过已经遍历的元素
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue; // 避免重复，每一层相同元素只排列一次,相同元素从后面排起
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
