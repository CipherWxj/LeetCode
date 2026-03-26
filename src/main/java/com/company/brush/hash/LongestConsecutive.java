package com.company.brush.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Wxj
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>输入描述:
 * nums = [100,4,200,1,3,2]
 * <p>输出描述:
 * 4
 */
public class LongestConsecutive {
    private static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        // 将数组转换为哈希表,去重
        Set<Integer> set = new HashSet<>();
        for (int j : nums) {
            set.add(j);
        }
        // 初始化最大长度为0
        int max = 0;
        for (int num : nums) {
            // 如果哈希Set中存在前一个num-1,最大长度一定比以 当前数num 为起始位置的长度更长,跳过
            if (set.contains(num - 1)) continue;
            // 以 当前数num 为起始位置的连续序列的最大长度,初始化为1
            int curMax = 1;
            // 向后遍历,更新以 当前数num 为起始位置的最大长度
            while (set.contains(num + 1)) {
                curMax++;
                num++;
            }
            // 比较,更新全局最大长度
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}