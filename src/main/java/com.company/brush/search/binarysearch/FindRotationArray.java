/**
 * @author: Wxj
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1。
 * <p>输入描述:
 * nums = [4,5,6,7,0,1,2], target = 0
 * <p>输出描述:
 * 4
 */
package com.company.brush.search.binarysearch;

import java.util.Scanner;

public class FindRotationArray {
    public static int solution(int[] nums, int target) {
        int n = nums.length;
        // 排除特殊情况
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;

        // 二分法
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2; // 取中间值
            if (nums[mid] == target) return mid;  // 最后一定有 left=mid=right
            // 左侧还是正常顺序，且target在区间内
            if (nums[left] < nums[mid] && nums[left] <= target && target <= nums[mid]) {
                right = mid;
            // 左侧不是正常顺序，且target在区间内
            // 这里借助了旋转排序数组的规律
            } else if (nums[left] > nums[mid] && (nums[left] <= target || target <= nums[mid])) {
                right = mid;
            // target 在右侧区间
            } else {
                left = mid + 1;
            }
        }
        // 没找到则返回-1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("请输入螺旋排序数组：");
        Scanner sc = new Scanner(System.in);
        System.out.print("nums= ");
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        System.out.println("请输入目标值：");
        System.out.print("target= ");
        int target = sc.nextInt();
        System.out.println(solution(nums, target));
    }
}
