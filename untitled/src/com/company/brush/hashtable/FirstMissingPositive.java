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
        int n = nums.length;
        // 第一遍遍历
        // 首先，我们要找的数一定在区间 [1，n+1] 内,只有当数组中全部包括 [1,n], 才返回 n+1
        // 然后，我们将数组的索引 i 作为哈希值，即 元素 1 放到 索引为 0 的位置
        for (int i = 0; i < n; i++) {
            // 如果元素 nums[i] 在 [1,n] 之间，将它放到 nums[i] - 1 的位置
            // 这个地方用 while 是因为一次交换后的元素可能也满足，我们继续判断交换，用if就忽略了交换后的元素
            while (nums[i] > 0 && nums[i] < n + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // 全部放好后，只需要比较 元素值和索引的关系，遇到的第一个不满足条件的返回
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        // 全部满足说明数组中n个元素对应[1,n]，返回n+1
        return n + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
