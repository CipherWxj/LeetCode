/**
 * @author: Wxj
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>输入描述:
 * nums = [5,2,3,1]
 * <p>输出描述:
 * [1,2,3,5]
 */
package com.company.brush.sort.mergesort;

public class SortArray {
    public int[] solution(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    // 归并排序
    // 将长度为 n 的序列分成长度为 n/2 的子序列，
    // 继续递归拆分成长度为 n/4 的子序列……直到子序列长度为 1或2
    // 开辟一个新数组 temp，将序列从中间分割，遍历比较前后两段中元素大小（两段都已排序）
    // 按从小到大填充到 temp，再依次向上合并
    // 时间复杂度 O(nlog(n))，空间复杂度 O(n)
    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // 递归分治
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            // 合并
            merge(nums, left, right, mid, temp);
        }
    }

    // 合并
    public void merge(int[] nums, int left, int right, int mid, int[] temp) {
        int i = left, j = mid + 1; // 双指针遍历，左右两段
        int k = 0; // 指向 temp，用于填充操作
        // 遍历比较 mid 两侧，从小到大放入 temp
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        // 最后有一侧会有剩余元素（该子序列中最大），也放入 temp
        // 左侧，无剩余 i == mid
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        // 右侧，无剩余 j == right
        while (j <= right) {
            temp[k] = nums[i];
            j++;
            k++;
        }
        // 将 temp 中排序的子序列重新填入原数组 nums
        // 我们每次都是只用到 temp 的前几位，但是返回原数组的子序列是[left, right]
        k = 0; // temp 从头开始
        int l = left; // nums 指定子序列位置
        while (l <= right) {
            nums[l] = temp[k];
            l++;
            k++;
        }
    }
}   
