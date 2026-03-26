package com.company.brush.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangxinjian
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>输入描述:
 * nums = [2,7,11,15], target = 9
 * <p>输出描述:
 * [0,1]
 */
public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        // 初始化哈希表, key:当前位置的值与目标值target的差值, value:当前位置的索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果当前值已经存在,说明存在遍历过的数与当前值的和等于目标值
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else { // 如果当前值不存在,将目标值与当前值的差值及当前位置的索引存放在哈希表中
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}