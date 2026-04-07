package com.company.brush.slidingWindow;

import java.util.*;

/**
 * @author: wangxinjian
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>输入描述:
 * nums = [1,3,-1,-3,5,3,6,7], k = 3
 * <p>输出描述:
 * [3,3,5,5,6,7]
 */
public class MaxSlidingWindow {
    /**
     * 优先队列
     */
    private static int[] maxSlidingWindowWithPriorityQueue(int[] nums, int k) {
        // 优先队列，存储的是数组，数组第一位o[0]为nums中遍历到的数，o[1]为数o[0]在nums中的位置
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            // 重写比较器，
            // 当两个数不相等时，根据数从大到小排列（大根堆）: o2[0] - o1[0]
            // 当两个数相等时，后出现的数排在前面，即索引从大到小排列：o2[1] - o1[1]，这么做的好处在执行移除操作时减少操作
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        // 结果数组
        int[] res = new int[nums.length - k + 1];
        // 先处理前k个数
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        res[0] = priorityQueue.peek()[0];
        // 后边遍历时需要去除不在窗口里的数
        for (int j = k; j < nums.length; j++) {
            priorityQueue.offer(new int[]{nums[j], j});
            // 当优先队列队头（堆顶）元素（最大的数）不在窗口范围里，需要移除
            // 只要最大的元素在窗口范围里，就是滑动窗口最大值
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] < j - k + 1) {
                priorityQueue.poll();
            }
            res[j - k + 1] = priorityQueue.peek()[0];
        }
        return res;
    }

    /**
     * 单调队列
     */
    private static int[] maxSlidingWindowWithDeque(int[] nums, int k) {
        // 单调队列，双端队列中存储的是nums中数的位置索引，保证队头索引对应的数最大
        Deque<Integer> deque = new LinkedList<Integer>();
        // 结果数组
        int[] res = new int[nums.length - k + 1];
        // 先处理前k个数
        for (int i = 0; i < k; i++) {
            // 保证队头存储的索引对应的数最大，从队尾开始移除小于当前数的索引
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        // 后边遍历时需要去除不在窗口里的数
        for (int j = k; j < nums.length; j++) {
            while (!deque.isEmpty() && nums[j] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
            // 队头索引不在窗口范围里，移除队头元素
            while (!deque.isEmpty() && deque.peekFirst() < j - k + 1) {
                deque.pollFirst();
            }
            res[j - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindowWithPriorityQueue(nums, k)));
        System.out.println(Arrays.toString(maxSlidingWindowWithDeque(nums, k)));
    }
}
