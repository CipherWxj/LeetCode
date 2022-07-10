/**
 * @author: Wxj
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>输入描述:
 * nums = [3,30,34,5,9]
 * <p>输出描述:
 * "9534330"
 */
package com.company.brush.array_string;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    // 只需要比较两个数不同的拼接顺序的结果，进而决定它们在结果中的排列顺序
    public String solution(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = nums[i] + "";
        }
        // 重新排序
        Arrays.sort(str, new Comparator<String>() {
            @Override
            // 重写compare方法，比较字符串连接之后的 o1 + o2 和 o2 + o1 的数值大小
            // o1 + o2 更大，返回 -1，不重排，o1 排在前
            // o2 + o1 更大，返回 1，重排，o2 排在前
            public int compare(String o1, String o2) {
                // 如果 Long.parseLong(o2 + o1) < Long.parseLong(o1 + o2), 返回 -1；
                // 如果 Long.parseLong(o2 + o1) = Long.parseLong(o1 + o2), 返回 0；
                // 如果 Long.parseLong(o2 + o1) > Long.parseLong(o1 + o2), 返回 1；
                return Long.compare(Long.parseLong(o2 + o1), Long.parseLong(o1 + o2));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        // 去除前导 0！
        int k = 0;
        while (k < n - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
}
