/**
 * @author: Wxj
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>输入描述:
 * nums = [1,1,2]
 * <p>输出描述:
 * 2
 */
package com.company.brush;

import java.util.Scanner;

public class RemoveDuplicates {

    public static int solution(int[] nums) {

        if (nums.length == 1) return 1; // 单个元素的数组直接返回 1

        // 初始化双指针
        // i 指向最近的不同元素， j 用于遍历
        // 初始 i指向第一个元素，j指向第二个元素
        int i = 0, j = 1;

        // 遍历
        while (j < nums.length) {
            if (nums[j] != nums[i]) { // 遍历到的元素不等于上一个（最近）的不同元素
                i++; // i右移
                nums[i] = nums[j]; // 将该元素赋值给i所指位置，更新为新的不同元素
            }
            // nums[j] == nums[i] 只需 j右移
            j++; //j右移

        }
        return i + 1; // 长度=索引+1
    }

    public static void main(String[] args) {

        System.out.println("请输入一个有序非空数组：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String str = s.substring(1, s.length() - 1);
        String[] arr = str.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(solution(nums));
    }
}
