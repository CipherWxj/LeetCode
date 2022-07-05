/**
 * @author: Wxj
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * <p>输入描述:
 * nums = [1,1,2,3,3,4,4,8,8]
 * <p>输出描述:
 * 2
 */
package com.company.brush.search.binarysearch;

// 前提条件：该数组元素个数为奇数
public class SingleNonDuplicate {
    public int solution(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 当 mid 是偶数， 左右两侧 剩余元素 的个数也是 偶数
            if (mid % 2 == 0) {
                // 往相等的一侧倾斜，说明右侧除 nums[mid + 1] 意外剩余元素个数为 奇数
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else { // 当 mid 是奇数，左右两侧 剩余元素 的个数也是 奇数
                // 往相等的另一侧倾斜，说明左侧除 nums[mid - 1] 意外剩余元素个数为 偶数
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }

    // 利用按位异或的性质，可以得到 mid 和相邻的数之间的如下关系，其中 ^ 是按位异或运算符
    //当 mid 是偶数时，mid + 1 = mid ^ 1；
    //当 mid 是奇数时，mid - 1 = mid ^ 1。
    public int solution2(int[] nums) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
