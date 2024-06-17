/**
 * @author: Wxj
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>输入描述:
 * s = "leetcode", wordDict = ["leet", "code"]
 * <p>输出描述:
 * true
 */
package com.company.brush.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean solution(String s, List<String> wordDict) {
        int n = s.length();

        // 将 wordDict 转为 Set，方便查找
        Set<String> set = new HashSet<>(wordDict);
        // 动态数组，dp[i]表示是否能用字典中的单词拼出前 i 位
        boolean[] dp = new boolean[n + 1];
        // 初始值
        dp[0] = true;
        // 递推
        // 由于 substring 的特性，注意 i 的设置
        for (int i = 1; i <= s.length(); i++) {
            // 每次判断 [j, i - 1] 这几位
            for (int j = i - 1; j >= 0; j--) {
                // 如果[0, j - 1] 和 [j, i - 1] 都能拼出来
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
