package com.company.brush.hash;

import java.util.*;

/**
 * @author: wangxinjian
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>输入描述：
 * nums = [1,1,1,2,2,3], k = 2
 * <p>输出描述:
 * [1,2]
 */
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        // 初始化哈希表，key：出现过的元素，value：元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 优先队列，存储的是数组，数组第一位o[0]为nums中遍历到的数，0[1]为数o[0]出现的次数
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 按出现次数从小到大排序
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 如果优先队列大小小于k，直接加入
            if (priorityQueue.size() < k) {
                priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
            } else { // 如果优先队列大小等于k，比较当前元素出现次数与队列中最优先的次数（元素出现的最小次数）
                // 如果当前元素出现次数更大，则取代队首元素，保持队列 maxSize=k
                if (!priorityQueue.isEmpty() && entry.getValue() > priorityQueue.peek()[1]) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
