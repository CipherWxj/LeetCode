package com.company.brush.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangxinjian
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>输入描述:
 * nums = [-1,0,1,2,-1,-4]
 * <p>输出描述:
 * [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 从大到小排序
        Arrays.sort(nums);
        // 固定第一个数,将三数和转化为两数和
        for (int first = 0; first < nums.length - 2; first++) {
            // 第一个数去重
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            // 后两个数的目标和
            int target = -nums[first];
            // 固定第一个数,后两个数从两侧向中间逼近
            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                // 第二个数去重
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                int twoSum = nums[second] + nums[third];
                if (twoSum < target) { // 两数和小于目标值,排序后较小的数右移
                    second++;
                } else if (twoSum > target) { // 两数和大于目标值,排序后较大的数左移
                    third--;
                } else { // 两数和等于目标值,添加到结果List里,左右两边向中间逼近,由于第二个数已经做了去重处理,天然第三个数不需要去重
                    res.add(new ArrayList<>(Arrays.asList(nums[first], nums[second], nums[third])));
                    second++;
                    third--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1, 0, 0, 0, 0};
        System.out.println(threeSum(nums));
    }
}
