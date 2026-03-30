package com.company.brush.hash;

/**
 * @author: wangxinjian
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>输入描述:
 * nums = [3,4,-1,1]
 * <p>输出描述:
 * 2
 */
public class FirstMissingPositive {
    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 缺失的第一个正数：
        // 要么等于n+1，此时数组中n个数为1到n且不重复
        // 要么在1到n之间，此时数组中存在负数 或 重复的数 或大于n的数，对于存在负数的情况，将负数变为大于n的正数，不影响结果
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) nums[i] = n + 1;
        }
        // 原地哈希，对于1到n，用 负号 标识 i+1 出现过
        for (int i = 0; i < n; i++) {
            // 实际的数都是正的，计算绝对值
            int realNum = Math.abs(nums[i]);
            // 绝对值在1到n之间，才需要标识
            if (realNum <= n) {
                nums[realNum - 1] = -Math.abs(nums[realNum - 1]);
            }
        }
        // 第一个没有标识的位置索引+1，即为缺失的第一个正数
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }
        // 都有标识，即为n+1
        return n + 1;
    }


    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }
}
