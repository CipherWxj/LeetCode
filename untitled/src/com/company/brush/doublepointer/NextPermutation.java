/**
 * @author: Wxj
 * 31. 下一个排列
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>输入描述:
 * nums = [1,2,3]
 * <p>输出描述:
 * [1,3,2]
 */
package com.company.brush.doublepointer;

public class NextPermutation {
    public void solution(int[] nums) {
        // 从后往前 遍历，找到第一个相邻升序的数对，即 nums[i-1]<nums[i]
        // 找到后，前面的元素不用处理，处理后面的就行
        // 没找到说明整个数组都是按降序排列，直接反转
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        // 找到第一个相邻升序数对，此时有 nums[i, len-1] 都是降序排列
        // 只需要在 nums[i, len-1] 中找到比 nums[i-1] 大的第一个（在比nums[i-1]大的元素里是最小的）元素，交换位置
        // 此时，nums[i, len-1] 仍然是降序排列，将其逆转为升序
        if (i > 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }
        reverse(nums, i, nums.length - 1);
    }

    // 交换数组中两个数的位置
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 反转数组区间[left, right]
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
