/**
 * @author: Wxj
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>输入描述:
 * [0,1,0,3,12]
 * <p>输出描述:
 * [1,3,12,0,0]
 */
package com.company.brush;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {
    public static int[] solution(int[] nums) {
        int i = 0, j = 0; // 初始化双指针
        while (i < nums.length) { // 遍历
            if (nums[i] != 0) {
                nums[j] = nums[i]; // 不等，将该元素赋值给j指向的位置
                j++; // j自增（j前面的元素都是非零元素）
            }
            i++;
        }
        // 将后面所有元素置0
        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
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
