/**
 * @author: Wxj
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>输入描述:
 * nums = [-1,0,1,2,-1,-4]
 * <p>输出描述:
 * [[-1,-1,2],[-1,0,1]]
 */
package com.company.brush.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {
    public static List<List<Integer>> solution(int[] nums) {
        int n = nums.length; // 数组长度
        List<List<Integer>> res = new ArrayList<>(); // 结果存储
        Arrays.sort(nums); // 排序
        for (int first = 0; first < n; first++) {
            // 如果第一个数都大于0了，后面就不用考虑了
            if (nums[first] > 0) {
                return res;
            }
            // 去除第一个数重复
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1; // 第二个数从前往后遍历
            int third = n - 1; // 第三个数从后往前遍历
            // 始终保证第二个数小于等于第三个数
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == 0) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[first]);
                    ans.add(nums[second]);
                    ans.add(nums[third]);
                    res.add(ans);
                    // 去除第二个数重复
                    while (second < third && nums[second] == nums[second + 1]) {
                        ++second;
                    }
                    // 去除第三个数重复
                    while (second < third && nums[third] == nums[third - 1]) {
                        --third;
                    }
                    ++second;
                    --third;
                } else if (sum < 0) {
                    // 和小于0，增加第二个数，第三个数已经最大了（去不去重复对结果无影响）
                    ++second;
                } else {
                    // 和大于0，减小第三个数，第二个数已经最小了
                    --third;
                }
            }
        }
        return res;
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

        System.out.println(solution(nums));
    }
}
