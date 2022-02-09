/**
 * @author: Wxj
 *229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 n/3 次的元素。
 * <p>输入描述:
 * [2,2,1,1,1,2,2,3,4]
 * <p>输出描述:
 * [2]
 */
package com.company.brush.moorevote;

import java.util.*;

public class MajorityElement3 {

    public static List<Integer> solution1(int[] nums) {
        /**
         * 摩尔投票法：遇到相同的则票数 +1，遇到不同的则票数 -1。
         * 至多存在 两个 个数大于 n/3 的数。
         * 最后 合并重复计数的元素，并验证是否正确。
         */
        int majNum1 = 0, count1 = 0; // 初始化，假设第一个元素为多数元素
        int majNum2 = 0, count2 = 0; // 初始化第二个多数元素的存储和计数器
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majNum1 && count1 > 0) { // 遇到与 majNum1 相同的则其票数 +1
                count1++;
            } else if (nums[i] == majNum2 && count2 > 0) { // 遇到与 majNum2 相同的则其票数 +1
                count2++;
            } else if (count1 == 0 && count2 >= 0) { // majNum1 票数为0，将当前元素假设为majNum1
                majNum1 = nums[i];
                count1++;
            } else if (count2 == 0 && count1 >= 0) { // majNum2 票数为0，将当前元素假设为majNum2
                majNum2 = nums[i];
                count2++;
            } else { // 遇到不同的则两者的票数都 -1
                count1--;
                count2--;
            }
        }

        // 验证
        int c1 = 0, c2 = 0;
        List<Integer> res = new ArrayList<>();
        if (majNum1 == majNum2) {
            res.add(majNum1);
        } else {
            for (int num : nums) {
                if (num == majNum1) c1++;
                if (num == majNum2) c2++;
            }
            if (c1 > nums.length / 3) res.add(majNum1);
            if (c2 > nums.length / 3) res.add(majNum2);
        }
        return res;
    }

    public static List<Integer> solution2(int[] nums) {
        /**
         * 哈希表法
         * Key：数组中的数  Value：出现的个数
         */
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // Key：数组中的数  Value：出现的个数
        for (int num : nums) {
            // Map中存在 num 时，在 num的值 的基础上 +1
            //    不存在 num 时，初始化其值为 0（遇到新的数）
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : map.keySet()) { // 遍历 Key
            if (map.get(i) > n / 3) res.add(i); // 对应的 Value > n / 3，添加
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println("请输入一个数组：");
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        s1 = s1.substring(1, s1.length() - 1);
        String[] n1 = s1.split(",");
        int[] nums = new int[n1.length];
        for (int i = 0; i < n1.length; i++) {
            nums[i] = Integer.parseInt(n1[i]);
        }

        System.out.println(solution1(nums));
        System.out.println(solution2(nums));
    }
}
