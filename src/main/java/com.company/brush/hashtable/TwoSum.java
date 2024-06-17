/**
 * @author: Wxj
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
package com.company.brush.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static int[] solution(int[] nums, int target) {
        // 初始化一个哈希表，key：target与已经遍历过元素的差值，value：已遍历过元素的数组下标
        Map<Integer, Integer> diffMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 计算target与当前元素的差值
            int diff = target - nums[i];
            if (diffMap.containsKey(diff)) { // 当前元素与已遍历元素的和是target，返回下标数组
                return new int[]{diffMap.get(diff), i};
            } else { // 当前元素与已遍历元素的和不是target，差值添加到diffMap，继续遍历
                diffMap.put(diff, i);
            }
        }
        // 默认返回
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数组：");
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        System.out.println("请输入target：");
        int target = sc.nextInt();
        System.out.println((Arrays.toString(solution(nums, target))));
    }
}
