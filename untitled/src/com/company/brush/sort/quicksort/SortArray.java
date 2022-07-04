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
        return quickSort(nums, 0, nums.length - 1);
    }

    // 快速排序
    // 每次随机选取一个切分元素，将其放到它该待的位置上
    // 接着向两侧递归，继续执行快排
    public static int[] quickSort(int[] nums, int l, int r) {
        // l >= r，说明排序完成，不需要再递归了！！！
        // 没有这个条件后面会报错！
       if (l < r) {
            int pos = partition(nums, l, r);
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
        return nums;
    }

    // 分割，查找位置
    public static int partition(int[] nums, int l, int r) {
        int randomIndex = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的切分元素
        swap(nums, r, randomIndex); // 将 pivot 放到最后

        // 寻找 pivot 应该待的位置
        int pivot = nums[r];
        int i = l - 1;
        // 从最左侧到右侧前一位（最后一位切分元素）
        for (int j = l; j < r; ++j) {
            // 比切分元素小的都放到切分元素的左侧
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r); // 将 pivot 放到应该待的位置 i+1
        return i + 1; // 返回分割点
    }

    // 交换
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
