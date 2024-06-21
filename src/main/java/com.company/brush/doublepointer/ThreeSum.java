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
        List<List<Integer>> res = new ArrayList<>();
        // 先排序！
        Arrays.sort(nums);
        // 三指针，i：第一个数，j：第二个数，k：第三个数
        // 固定第一个数，从两边向中间遍历第二个数和第三个数
        for (int i = 0; i < nums.length - 2; i++) {
            // 从数组第二位开始，如果第一个数相等则跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 从两边向中间遍历第二个数和第三个数
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) { // 三数之和大于0，说明较大的数大了，要减小
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) { // 三数之和小于0，说明较小的数小了，要增大（第一个数固定）
                    j++;
                } else { // 三数之和等于0
                    // 去重，直到取到最后一个可取值时放到结果中
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    res.add(ans);
                    // 继续向中间遍历
                    j++;
                    k--;
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
