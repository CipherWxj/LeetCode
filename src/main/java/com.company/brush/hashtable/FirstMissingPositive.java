/**
 * @author: Wxj
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>输入描述:
 * nums = [3,4,-1,1]
 * <p>输出描述:
 * 2
 */
package com.company.brush.hashtable;

import java.util.Scanner;

public class FirstMissingPositive {
    public static int solution(int[] nums) {
        // 数组长度为n，如果元素为1到n且不重复，那么缺失的第一个正数就是n+1，
        // 如果元素有重复或有大于n的整数或有小于1的整数，那么缺失的第一个正数一定在[1,n]之间，综上，结果一定在[1,n+1]之间。
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 【原地哈希】：将数组元素nums[i]放到第nums[i]个位置处
            // 如果元素nums[i]在[1,n]之间，就将这个元素与nums[i] - 1位置（第nums[i]个位置）的元素交换
            // 交换后的元素如果还在[1,n]之间，继续交换，所以用while循环
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
//                int temp = nums[i];
//                nums[i] = nums[nums[i] - 1];
//                nums[nums[i] - 1] = temp;
                // 这里交换数组元素只能先给nums[i] - 1处赋值，先给nums[i]赋值，nums[i] - 1就变了……
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) return j + 1;
        }
        return n + 1;
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
        System.out.println(solution(nums));
    }
}
