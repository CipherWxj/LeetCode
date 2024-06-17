/**
 * @author: Wxj
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>输入描述:
 * nums = [5,2,3,1]
 * <p>输出描述:
 * [1,2,3,5]
 */
package com.company.brush.sort.heapsort;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static int[] solution(int[] nums) {
        return heapSort(nums);
    }

    // 堆排序
    // 将原数组构成大根堆（小根堆），根元素则为最大（小）值，将根元素放到数组末尾
    // 将除末尾外的其余元素重新构成大（小）根堆，放到数组倒数第二位
    // 继续操作，直到剩下最后一个元素
    // 时间复杂度 O(nlog(n))，空间复杂度 O(1)
    public static int[] heapSort(int[] nums) {
        // 原始数组建立大顶堆
        // 从最后一个非叶子节点开始 (nums.length / 2 - 1)
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(nums, i, nums.length);
        }

        // 将根节点（最大值）放到数组末尾
        // 再将除去末尾元素的数组重新建立大顶堆，直到排序完（最后一个元素不需要了）
        for (int j = nums.length - 1; j > 0; j--) {
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            adjustMaxHeap(nums, 0, j); // 注意要进行排序的 length
        }
        return nums;
    }

    // 调整大顶堆
    public static void adjustMaxHeap(int[] nums, int i, int length) {
        int left = 2 * i + 1, right = 2 * i + 2, largest = i; // 左子节点 右子节点 根节点（假设 arr[i] 是最大）
        // 判断是否需要调整
        // 如果 arr[i] 就是最大的，不需要调整
        if (left < length && nums[largest] < nums[left]) {
            largest = left; // 左子节点大
        }
        if (right < length && nums[largest] < nums[right]) {
            largest = right; // 右子节点（更）大
        }
        // 调整操作
        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            // 继续向子节点递归调整
            adjustMaxHeap(nums, largest, length);
        }
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
