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

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    // 单调队列
    public int[] solution(int[] nums, int k) {
        // 双端队列
        // 存储数组下标，保持队列从头到尾所存下标递增，其对应的元素递减，即
        // 队列头部存储的下标对应的元素最大
        Deque<Integer> deque = new LinkedList<>();
        // 初始化队列，第一个窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        // 初始化结果数组
        int[] res = new int[nums.length - k + 1];
        // 第一个窗口最大的元素
        res[0] = nums[deque.peekFirst()];
        for (int j = k; j < nums.length; j++) {
            while (!deque.isEmpty() && nums[j] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
            // 如果队列头部下标不在窗口范围内了，移除
            while (deque.peekFirst() <= j - k) {
                deque.pollFirst();
            }
            res[j - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
