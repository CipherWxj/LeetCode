package com.company.brush.greedy;

/**
 * @author: wangxinjian
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * <p>输入描述:
 * nums = [2,3,1,1,4]
 * <p>输出描述:
 * 2
 */
public class Jump {

    public static int jump(int[] nums) {
        // 步数
        int step = 0;
        // 当前能到达的最远位置
        int maxIndex = 0;
        // 当前跳跃范围的结束位置
        int end = 0;
        // 最后一个位置一定能到，不用考虑了
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            // 到达当前跳跃范围的结束位置，需要进行下一次跳跃，下一次跳跃能到达的最大位置maxIndex就是下一次跳跃的结束位置
            if (i == end) {
                end = maxIndex;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}