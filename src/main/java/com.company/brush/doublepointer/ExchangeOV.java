/**
 * @author: Wxj
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>输入描述:
 * nums = [1,2,3,4]
 * <p>输出描述:
 * [1,3,2,4]
 */
package com.company.brush.doublepointer;

import java.util.Arrays;

public class ExchangeOV {

    public static int[] solution(int[] nums) {
        // i 用作遍历
        // j 用作标记从左数第一个偶数
        for(int i = 0, j = 0; i < nums.length; i++) {
            // 当遍历到 奇数 交换，并将 j 后移
            // 当遍历到 偶数，不做操作，继续遍历
            // 因为我们的目的是将奇数尽可能往左放，所以只需要标记最左侧偶数的位置
            if(nums[i] % 2 == 1) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4})));
    }
}
