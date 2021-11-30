/**
 * @author: Wxj
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于n/2 的元素。
 * 假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>输入描述:
 * [2,2,1,1,1,2,2]
 * <p>输出描述:
 * 2
 */
package com.company.brush;

import java.util.Scanner;

public class MajorityElement {

    public static int solution(int[] nums) {
        /**
         * 摩尔投票法：遇到相同的则票数 +1，遇到不同的则票数 -1。
         * 且“多数元素”的个数>  n/2，其余元素的个数总和<= n/2。
         * 因此 “多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
         * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
         */
        int majNum = nums[0], count = 1; // 初始化，假设第一个元素为多数

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) { // 之前的元素出现数量相互抵消
                majNum = nums[i]; // 将当前元素假设为多数元素
//                count = 1; // 重新开始计数(下面改成 else if)
            }
            if (nums[i] == majNum) { // 遇到相同的则票数 +1
                count++;
            } else count--; // 遇到不同的则票数 -1
        }
        return majNum; // 返回最后的多数元素
    }

    public static void main(String[] args) {

        System.out.println("请输入一个存在多数元素（个数大于n/2）的数组：");
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        s1 = s1.substring(1, s1.length() - 1);
        String[] n1 = s1.split(",");
        int[] nums = new int[n1.length];
        for (int i = 0; i < n1.length; i++) {
            nums[i] = Integer.parseInt(n1[i]);
        }
        System.out.println(solution(nums));
    }
}
