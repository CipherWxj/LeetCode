package com.company.brush.greedy;


/**
 * @author: wangxinjian
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>输入描述:
 * nums = [2,3,1,1,4]
 * <p>输出描述:
 * true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        // maxIndex表示能到达的最远位置
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置i小于等于能到达的最远位置maxIndex，说明可以以当前位置为跳板，跳到更远的位置
            if (i <= maxIndex) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
            // 直到能到达的最远位置大于等于数组最后一个位置，返回true
            if (maxIndex >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}