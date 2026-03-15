/**
 * @author: Wxj
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>输入描述:
 * nums = [5,2,3,1]
 * <p>输出描述:
 * [1,2,3,5]
 */
package com.company.brush.sort.shellsort;

public class SortArray {
    public int[] solution(int[] nums) {
        return shellSort(nums);
    }

    // 希尔排序（缩小增量排序）
    // 将待排序的数组间隔分组成若干个子序列，分别进行插入排序
    // 时间复杂度 O(n^1.3)，空间复杂度 O(1)
    public int[] shellSort(int[] nums) {
        // 分组，共分成 gap 组，nums[0]和nums[gap]一组
        // 开始一组2个元素，第二次4个……
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            int insIndex, insValue;
            // 从 gap 处开始，按 分组 插入排序
            for (int i = gap; i < nums.length; i++) {
                insIndex = i;
                insValue = nums[i];
                while (insIndex - gap >= 0 && nums[insIndex - gap] > insValue) {
                    nums[insIndex] = nums[insIndex - gap];
                    insIndex -= gap;
                }
                nums[insIndex] = insValue;
            }
        }
        return nums;
    }
}    
