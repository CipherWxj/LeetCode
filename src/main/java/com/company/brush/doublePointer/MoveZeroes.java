package com.company.brush.doublePointer;

import java.util.Arrays;

/**
 * @author: wangxinjian
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>输入描述:
 * [0,1,0,3,12]
 * <p>输出描述:
 * [1,3,12,0,0]
 */
public class MoveZeroes {
    private static int[] moveZeros(int[] nums){
        // 初始化指针,指向数组中最后一个不为0的元素,初始化为-1
        int lastNotZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            // 每次遍历不为0的元素,执行操作
            if(nums[i] != 0){
                // 赋值即左移
                nums[++lastNotZeroIndex] = nums[i];
                // 如果最后一个不为0的元素所在位置不是当前位置,将当前位置的数置为0
                if(lastNotZeroIndex != i) nums[i] = 0;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeros(nums)));
    }
}