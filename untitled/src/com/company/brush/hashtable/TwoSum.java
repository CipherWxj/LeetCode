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
        Map<Integer, Integer> difference = new HashMap<>(); // 哈希表存储遍历过的元素 key：元素值  value：索引
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i]; // 计算差值
            if (difference.containsKey(diff)) { // 判断已经遍历过的元素是否存在该差值
                return new int[]{difference.get(diff), i}; // 存在，则返回两个索引
            }
            difference.put(nums[i], i); // 不存在，添加进哈希表，继续遍历
        }
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
