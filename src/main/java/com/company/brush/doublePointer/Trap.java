package com.company.brush.doublePointer;

/**
 * @author: wangxinjian
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>输入描述:
 * height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>输出描述:
 * 6
 */
public class Trap {
    /**
     * 某根柱子i能存多少水由它左右两侧最高的柱子和它本身决定，存水高度：h = Math.min(leftMaxH, rightMaxH) - height[i]
     * 不管距离多远，只要左右两侧有比它高的柱子，那么该柱子上面一定可以存水
     */
    private static int trap(int[] height) {
        int res = 0;
        // 初始化左侧的最大高度和右侧的最大高度
        int leftMax = 0, rightMax = 0;
        // 从左右两侧向中间逼近
        int left = 0, right = height.length - 1;
        while (left < right) {
            // 更新左侧的最大高度
            leftMax = Math.max(leftMax, height[left]);
            // 更新右侧的最大高度
            rightMax = Math.max(rightMax, height[right]);
            // 如果左指针处的高度小于右指针处的高度,计算左指针处位置可以存的水量
            if (height[left] < height[right]) {
                // 木桶原理,取左右最大高度的最小值
                res += Math.min(leftMax, rightMax) - height[left];
                left++;
            } else { // 如果左指针处的高度等于大于右指针处的高度,计算右指针位置可以存的水量
                res += Math.min(leftMax, rightMax) - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
