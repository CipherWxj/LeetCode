/**
 * @author: Wxj
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>输入描述:
 * nums = [3,2,2,3], val = 3
 * <p>输出描述:
 * 2
 */
package com.company.brush.doublepointer;

import java.util.Scanner;

public class RemoveElement {
    public static int solution(int[] nums, int val) {

        // 初始化双指针
        // i 指向最近的不等于 val 的元素， j 用于遍历
        // 初始 i指向第 0 个元素，j指向第 1 个元素
        int i = -1, j = 0;

        // 遍历
        while (j < nums.length) {
            if (nums[j] != val) { // 遍历到的元素不等于 val
                i++; // i右移
                nums[i] = nums[j]; // 将该元素赋值给i所指位置
            }
            // nums[j] == val 只需 j右移
            j++; //j右移
        }
        return i + 1;
    }

    public static void main(String[] args) {

        System.out.println("请输入一个非空数组：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String str = s.substring(1, s.length() - 1);
        String[] arr = str.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        System.out.println("请输入一个整数：");
        int val = sc.nextInt();

        System.out.println(solution(nums, val));
    }
}

