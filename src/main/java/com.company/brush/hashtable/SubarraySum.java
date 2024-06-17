/**
 * @author: Wxj
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>输入描述:
 * nums = [1,1,1], k = 2
 * <p>输出描述:
 * 2
 */
package com.company.brush.hashtable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int solution(int[] nums, int k) {
        int n = nums.length;
        int count = 0; // 计数器
        // 前缀和数组
        // pre[i] 对应数组中前 i 位的和
        int[] pre = new int[n + 1];
        // 最左边边界值 pre[0]=0
        pre[0] = 0;
        // map 记录已经存在的前缀和
        Map<Integer, Integer> map = new HashMap<>();
        // 将边界值添加到 map 中
        map.put(pre[0], 1);
        // 遍历
        for (int i = 0; i < n; i++) {
            // 计算从左到第 i 位的前缀和
            pre[i + 1] = pre[i] + nums[i];
            // 核心！！！！！
            // 假设子数组索引为 [j, i],则 pre[i + 1] - pre[j + 1] = k
            if (map.containsKey(pre[i + 1] - k)) {
                count += map.get(pre[i + 1] - k);
            }
            // 添加，注意重复
            map.put(pre[i + 1], map.getOrDefault(pre[i + 1], 0) + 1);
        }
        return count;
    }

    // 做一下空间复杂度优化，只需要保存前一位的 前缀和
    public int solution2(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(pre, 1);
        for(int i = 0; i < n; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
