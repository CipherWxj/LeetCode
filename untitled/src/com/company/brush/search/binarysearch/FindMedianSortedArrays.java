/**
 * @author: Wxj
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>输入描述:
 * nums1 = [1,2], nums2 = [3,4]
 * <p>输出描述:
 * 2.50000
 */
package com.company.brush.search.binarysearch;

import java.util.Scanner;

public class FindMedianSortedArrays {

    // 遍历比较，时间复杂度O（m+n）
    public static double solution1(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        int len = m + n;
        // i 用于遍历 nums1，j 用于遍历 nums2
        int i = 0, j = 0;
        // left、right用于偶数个元素时计算中位数
        int left = 0, right = 0;
        // 遍历 （len / 2）+1 次
        // 奇数个元素 right 正好遍历到中位数位置len / 2
        // 偶数个元素 right 正好遍历到（len / 2）+1处，left 还位于len / 2处
        for (int k = 0; k <= len / 2; k++) {
            left = right;
            // 防止数组越界很重要！！
            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                right = nums1[i++];
            } else if (j < n && (i >= m || nums1[i] >= nums2[j])) {
                right = nums2[j++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    // 二分法，时间复杂度O（log（m+n））
    public static double solution2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        // 奇数个找 第 k = (len / 2) + 1 小的元素
        if ((len & 1) == 1) {
            return getKthLarge(nums1, nums2, (len / 2) + 1, 0, 0, m, n);
        } else { // 偶数个找 第 (len / 2) 和 第 (len / 2) + 1 小的元素
            int left = getKthLarge(nums1, nums2, (len / 2), 0, 0, m, n);
            int right = getKthLarge(nums1, nums2, (len / 2) + 1, 0, 0, m, n);
            return (left + right) / 2.0;
        }
    }

    // 寻找第 k 小 的元素
    /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 这里的 "/" 表示整除
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */
    public static int getKthLarge(int[] nums1, int[] nums2, int k, int start1, int start2, int length1, int length2) {
        // 边界条件
        // 一个数组遍历完直接去另一个数组找
        if (start1 == length1) return nums2[start2 + k - 1];
        if (start2 == length2) return nums1[start1 + k - 1];

        // 终止条件，递归到最后就是找最小了
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        // 根据 k 确定比较的元素位置
        // 要防止越界
        int index1 = Math.min(length1, start1 + k / 2) - 1;
        int index2 = Math.min(length2, start2 + k / 2) - 1;
        // 递归寻找
        // k 的值要更新
        if (nums1[index1] > nums2[index2]) {
            // nums2[start2]~nums2[index2] 舍弃掉
            return getKthLarge(nums1, nums2, k - (index2 - start2 + 1), start1, index2 + 1, length1, length2);
        } else {
            // nums1[start1]~nums1[index1] 舍弃掉
            return getKthLarge(nums1, nums2, k - (index1 - start1 + 1), index1 + 1, start2, length1, length2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nums1= ");
        String s1 = sc.nextLine();
        int[] nums1 = input(s1);
        System.out.print("nums2= ");
        String s2 = sc.nextLine();
        int[] nums2 = input(s2);
        System.out.println(solution1(nums1, nums2));
    }

    public static int[] input(String s) {
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        return nums;
    }
}
