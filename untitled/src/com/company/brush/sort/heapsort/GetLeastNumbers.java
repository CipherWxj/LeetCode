/**
 * @author: Wxj
 * 剑指 Offer 40. 最小的k个数
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>输入描述:
 * [3,2,1,5,6,4] 和 k = 2
 * <p>输出描述:
 * 5
 */
package com.company.brush.sort.heapsort;


public class GetLeastNumbers {
    public static int[] solution(int[] nums, int n) {
        int[] res = new int[n];

        // 原始数组建立小顶堆
        // 从最后一个非叶子节点开始 (nums.length / 2 - 1)
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            minHeap(nums, i, nums.length);
        }

        // 将根节点（最小值）放到结果数组中
        // 再将除去末尾元素的数组重新建立大顶堆，直到找出第 k 个最大值
        for (int j = 0; j < n; j++) {
            res[j] = nums[j];
            minHeap(nums, j + 1, nums.length - 1 - j); // 注意length
        }
        // 返回数组中倒数第 k 个元素
        return res;
    }


    public static void minHeap(int[] nums, int i, int length) {
        int left = 2 * i + 1, right = 2 * i + 2, least = i;
        if (left < length && nums[left] < nums[least]) {
            least = left;
        }
        if (right < length && nums[right] < nums[least]) {
            least = right;
        }
        if (least != i) {
            int temp = nums[i];
            nums[i] = nums[least];
            nums[least] = temp;
            minHeap(nums, least, length);
        }
    }


}
