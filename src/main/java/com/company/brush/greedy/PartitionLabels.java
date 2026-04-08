package com.company.brush.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangxinjian
 * 763. 划分字母区间
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>输入描述:
 * s = "ababcbacadefegdehijhklij"
 * <p>输出描述:
 * [9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 */
public class PartitionLabels {
    private static List<Integer> partitionLabels(String s) {
        // 初始化数组存储字符在字符串中的最大位置
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }
        // 划分的起始和结束位置
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < s.length(); j++) {
            // 结束位置是当前字符在字符串中出现的最远位置
            end = Math.max(end, index[s.charAt(j) - 'a']);
            // 如果当前位置是结束位置，则划分一个区间
            if (j == end) {
                res.add(end - start + 1);
                // 更新下一个区间的起始位置
                start = end + 1;
                end = start;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
