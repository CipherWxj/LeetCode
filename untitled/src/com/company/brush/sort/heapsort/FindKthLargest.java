/**
 * @author: Wxj
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>输入描述:
 * [3,2,1,5,6,4] 和 k = 2
 * <p>输出描述:
 * 5
 */
package com.company.brush.sort.heapsort;

import java.util.Scanner;

public class FindKthLargest {
    public static int solution(int[] nums, int k) {
        // 原始数组建立大顶堆
        // 从最后一个非叶子节点开始 (nums.length / 2 - 1)
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(nums, i, nums.length);
        }

        // 将根节点（最大值）放到数组末尾
        // 再将除去末尾元素的数组重新建立大顶堆，直到找出第 k 个最大值
        for (int j = nums.length - 1; j > nums.length - 1 - k; j--) {
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            adjustMaxHeap(nums, 0, j+1);
        }
        // 返回数组中倒数第 k 个元素
        return nums[nums.length - k];
    }

    // 调整大顶堆
    public static void adjustMaxHeap(int[] arr, int i, int length) {
        int left = 2 * i + 1, right = 2 * i + 2, largest = i; // 左子节点 右子节点 根节点
        // 判断是否需要调整
        if (left < length && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < length && arr[largest] < arr[right]) {
            largest = right;
        }
        // 调整操作
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // 继续向子节点调整
            adjustMaxHeap(arr, largest, length);
        }
    }

//    public static void minHeap(int[] nums,int i, int length){
//        int left=2*i+1,right=2*i+2,largest=i;
//        if(left<length&&nums[left]<nums[largest]){
//            largest=left;
//        }
//        if(right<length&&nums[right]<nums[largest]){
//            largest=right;
//        }
//        if (largest!=i){
//            int temp=nums[i];
//            nums[i]=nums[largest];
//            nums[largest]=temp;
//            minHeap(nums,largest,length);
//        }
//    }

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
        System.out.println("请输入k：");
        int k = sc.nextInt();
        System.out.println((solution(nums, k)));
    }
}
