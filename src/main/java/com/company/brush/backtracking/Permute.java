package com.company.brush.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangxinjian
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 * <p>输入描述:
 * nums = [1,2,3]
 * <p>输出描述:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, 0);
        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, int index) {
        // 终止条件：排列长度等于数组长度，将当前排列加入结果集
        if (index == nums.length) {
            List<Integer> ans = new ArrayList<Integer>();
            for (int num : nums) {
                ans.add(num);
            }
            res.add(ans);
        }
        // 遍历数组，进行交换和递归
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrack(nums, res, index + 1);
            // 恢复
            swap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
