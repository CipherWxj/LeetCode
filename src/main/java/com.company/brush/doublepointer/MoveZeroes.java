/**
 * @author: Wxj
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>输入描述:
 * [0,1,0,3,12]
 * <p>输出描述:
 * [1,3,12,0,0]
 */
package com.company.brush.doublepointer;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {
    public static int[] solution(int[] nums) {
        // 初始化双指针，cur：遍历指针，maybeFirstZeroIndex标记左起第一个可能为0的位置
        int cur = 0, maybeFirstZeroIndex = 0;

        while (cur < nums.length) {
            // 将不为0的数放到前面，不改变顺序
            if (nums[cur] != 0) {
                nums[maybeFirstZeroIndex] = nums[cur];
                maybeFirstZeroIndex++;
            }
            cur++;
        }
        // maybeFirstZeroIndex及其后面的数都是0
        for (int i = maybeFirstZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数组：");
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        System.out.println(Arrays.toString(solution(nums)));
    }
}
