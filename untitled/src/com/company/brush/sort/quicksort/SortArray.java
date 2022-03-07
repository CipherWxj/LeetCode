/**
 * @author: Wxj
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>输入描述:
 * nums = [5,2,3,1]
 * <p>输出描述:
 * [1,2,3,5]
 */
package com.company.brush.sort.quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortArray {
    public static int[] solution(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 快排
    public static void quickSort(int[] nums, int l, int r) {
        // l >= r，说明排序完成，不需要再递归了！！！
        // 没有这个条件后面会报错！
       if (l < r) {
            int pos = partition(nums, l, r);
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
    }

    // 分割
    public static int partition(int[] nums, int l, int r) {
        int randomIndex = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, randomIndex); // 将主元 pivot 放到最后

        // 寻找 pivot 应该待的位置
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r); // 将 pivot 放到应该待的位置
        return i + 1; // 返回分割点
    }

    // 交换位置
    private static void swap(int[] nums, int i, int j) {
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

        System.out.println(Arrays.toString(solution(nums)));
    }
}
