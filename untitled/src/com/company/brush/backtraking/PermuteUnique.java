/**
 * @author: Wxj
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>输入描述:
 * nums = [1,1,2]
 * <p>输出描述:
 * [[1,1,2],[1,2,1],[2,1,1]]
 */
package com.company.brush.backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PermuteUnique {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrak(nums, visited, res, new ArrayList<Integer>());
        return res;
    }

    public static void backtrak(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> ans) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue; // 避免重复
            visited[i] = true;
            ans.add(nums[i]);
            backtrak(nums, visited, res, ans);
            visited[i] = false;
            ans.remove(ans.size() - 1);
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
