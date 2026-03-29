package com.company.brush.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangxinjian
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>输入描述:
 * nums = [1,1,1], k = 2
 * <p>输出描述:
 * 2
 */
public class SubarraySum {
    /**
     * 如果整个数组的和为sum，将数组分成两段，前一段的和为sum-k，后一段的和为k，
     * (sum-k) + k = sum
     */
    private static int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int res = 0;
        // 初始化前缀和哈希表，key：从第一位开始到第i位的和 value：和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 第一位以前的和记为0
        int sum = 0;
        map.put(0, 1);
        // 从第一位开始遍历
        for (int num : nums) {
            // 求和
            sum += num;
            // 如果map里存在 sum-k，那么一定存在子串的和为k，加到结果里
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            // 更新和出现的次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
