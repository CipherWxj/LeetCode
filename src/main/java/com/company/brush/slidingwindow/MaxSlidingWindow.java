/**
 * @author: Wxj
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>输入描述:
 * nums = [1,3,-1,-3,5,3,6,7], k = 3
 * <p>输出描述:
 * [3,3,5,5,6,7]
 */
package com.company.brush.slidingwindow;

import java.util.*;

public class MaxSlidingWindow {
    // 单调队列
    public static int[] solution(int[] nums, int k) {
        // 双端队列，存储的元素为数组下标
        // 下标对应的数组元素从小到大排列，即：队列头部存储的下标对应的数组元素最大，尾部存储的下标对应的数组元素最小
        Deque<Integer> deque = new LinkedList<>();
        // 初始化队列，第一个窗口
        for (int i = 0; i < k; i++) {
            // 从队列尾部开始，向队列头部遍历，找到i应该在的队列位置
            // 比nums[i]小的元素对应的下标都丢弃，因为这些下标只可能在i的左边，窗口左侧覆盖它们的时候一定覆盖i
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        // 初始化结果数组，长度算一下
        int[] res = new int[nums.length - k + 1];
        // 第一个窗口最大的元素
        res[0] = nums[deque.peekFirst()];
        // 窗口右侧向右遍历
        for (int j = k; j < nums.length; j++) {
            while (!deque.isEmpty() && nums[j] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
            // 从队列头部开始，向队列尾部遍历
            // 如果队列头部存储的下标不在窗口范围内了，移除
            while (deque.peekFirst() <= j - k) {
                deque.pollFirst();
            }
            // 队列头部存储的下标对应元素最大
            res[j - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static int[] solution1(int[] nums, int k) {
        // 优先队列
        // 队列数组中第一个元素为下标对应的值，第二个元素为下标
        // 重写比较器，默认升序，重写为降序
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 如果元素不同，按元素降序排列；如果元素相同，按下标降序排列（后出现的最优先）
                return o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            pQueue.offer(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = pQueue.peek()[0];
        for (int j = k; j < nums.length; j++) {
            pQueue.offer(new int[]{nums[j], j});
            // 最大元素不在窗口内了
            while (pQueue.peek()[1] <= j - k) {
                pQueue.poll();
            }
            res[j - k + 1] = pQueue.peek()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
