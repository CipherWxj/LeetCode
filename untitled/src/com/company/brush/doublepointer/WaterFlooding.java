/**
 * @author: Wxj
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>输入描述:
 * height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>输出描述:
 * 6
 */
package com.company.brush.doublepointer;

/*
 * 方法1：动态规划 com/company/brush/dynamicprogramming/WaterFlooding.java
 * 方法2：单调栈 com/company/brush/stack/WaterFlooding.java
 * 方法3：双指针 com/company/brush/doublepointer/WaterFlooding.java
 */
public class WaterFlooding {

    // 双指针
    public static int solution3(int[] height) {
        int len = height.length;
        // left从左往右遍历，right从右往左遍历
        int left = 0, right = len - 1;
        // 分别记录左右侧的最大高度
        int leftMax = 0, rightMax = 0;
        int res = 0;

        // 相遇之前计算，相遇遍历完
        while (left < right) {
            // 比较left当前位置和左侧最大高度，更新
            leftMax = Math.max(height[left], leftMax);
            // 比较right当前位置和右侧最大高度，更新
            rightMax = Math.max(height[right], rightMax);

            // 说明在右侧一定有比当前left位置更高的柱子
            if (height[left] < height[right]) {
                // 在维护过程中已经保证了 leftMax<rightMax
                res += leftMax - height[left];
                left++;
            // 说明在左侧一定有比当前right位置更高的柱子
            } else if (height[left] >= height[right]) {
                // 在维护过程中已经保证了 leftMax>rightMax
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
