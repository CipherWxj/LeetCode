/**
 * @author: Wxj
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>输入描述：
 * nums = [1,1,1,2,2,3], k = 2
 * <p>输出描述:
 * [1,2]
 */
package com.company.brush.hashtable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] solution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 优先队列
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的频率
        // 按频率小到大排列
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue(); // 出现的数、出现频率
            // 如果队列中有 k 个元素
            if (queue.size() == k) {
                // 比较队头元素出现频率与当前值出现频率的大小
                // 队头元素频率小，换一个
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else { // 队头元素频率大，舍弃当前元素
                queue.offer(new int[]{num, count});
            }
        }
        // 结果返回前 k 个
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
