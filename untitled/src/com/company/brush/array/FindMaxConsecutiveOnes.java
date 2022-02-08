/**
 * @author: Wxj
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>输入描述:
 * [1,1,0,1,1,1]
 * <p>输出描述:
 * 3
 */
package com.company.brush.array;

import java.util.Scanner;

public class FindMaxConsecutiveOnes {
    public static int solution(int[] nums) {
        int count = 0; // 计数器
        int max = 0; // 最大连续1的个数
        for (int num : nums) {
            if (num == 1) {
                count++; // 遍历，等于1计数器自增
            } else
                count = 0; // 不等于1计数器置0
            // 比较，找出最大
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个只含0和1的数组：");
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
