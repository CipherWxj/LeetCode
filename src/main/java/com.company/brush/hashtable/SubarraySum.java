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
    public static int solution(int[] nums, int k) {
        // 初始化哈希表，key：从数组最左侧开始到某一位的和（前缀和），value：某个前缀和出现的次数
        Map<Integer, Integer> preSumMap = new HashMap<>();
        // preSum[i]表示从数组最左侧开始到第i-1位的和
        // preSum[i+1]表示从数组最左侧开始到第i位的和
        int[] preSum = new int[nums.length + 1];
        int res = 0;
        // 初始化
        preSum[0] = 0;
        preSumMap.put(preSum[0], 1);

        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            // 如果 数组最左侧开始到第i位的和减去第j位的前缀和等于k，即： preSum[i + 1] - pre[j] = k
            // 那么 第j位到第i位的和就是k，[i,j]
            // 取出次数累加
            if (preSumMap.containsKey(preSum[i + 1] - k)) {
                res += preSumMap.get(preSum[i + 1] - k);
            }
            // 将[0,i]的和作为第i+1位的前缀和放到preSumMap里，更新出现次数
            preSumMap.put(preSum[i + 1], preSumMap.getOrDefault(preSum[i + 1], 0) + 1);
        }
        return res;
    }

    public static int solution2(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        // preSum表示前缀和
        int preSum = 0;
        int res = 0;
        preSumMap.put(preSum, 1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSumMap.containsKey(preSum - k)) {
                res += preSumMap.get(preSum - k);
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1}, 2));
    }
}
