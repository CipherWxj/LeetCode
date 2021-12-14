/**
 * @author: Wxj
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>输入描述:
 * nums = [1,3,5,6], target = 5
 * <p>输出描述:
 * 2
 */
package com.company.brush;

import java.util.Scanner;

public class SearchInsert {

    public static int solution(int[] nums, int target) {

        int left = 0; // 初始化区间左索引
        int right = nums.length - 1; // 初始化区间右索引

        // 左索引小于右索引，遍历
        while (left < right) {
            int mid = (left + right) / 2; // 二分法取中间值
            if (nums[mid + 1] < target) {
                left = mid + 1; // 向上查找
            } else if (nums[mid] > target) {
                right = mid; // 向下查找
            } else if (nums[mid] < target && target <= nums[mid + 1]) {
                return mid + 1; // 判断在两数中间，返回插入位置
            } else {
                return mid; // 判断与中间数相等，返回该位置
            }
        }
        // 如果比数组最大值还要大，返回最右侧插入位置，nums.length
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        // 如果比数组最小值还要小，返回最左侧插入位置，0
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个升序排列的数组：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println("请输入所要查找的值：");
        int target = sc.nextInt();
        System.out.println(solution(arr, target));
    }
}
