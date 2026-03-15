/**
 * @author: Wxj
 * 72. 编辑距离
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>输入描述:
 * word1 = "horse", word2 = "ros"
 * <p>输出描述:
 * 3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
package com.company.brush.dynamicprogramming;

import java.util.Scanner;

public class MinDistance {
    public static int solution(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // 其中一个为空，将另一个全删除，返回另一个的长度
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;

        // dp[i][j]表示 word1 的前 i 个字符到 word2 的前 j 个字符的最小编辑距离
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化边界
        // word2 为空
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        // word1 为空
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // 递推
        // 归根结底的操作只有四种：
        // 1、不做操作（word1 和 word2 字符相同）：dp[i][j] = dp[i - 1][j - 1]
        // 2、修改 word1 的字符（修改 word2 的字符）：dp[i][j] = dp[i - 1][j - 1] + 1
        // 3、删除 word1 的字符（在 word2 中插入字符）：dp[i][j] = dp[i][j - 1] + 1
        // 4、在 word1 中插入字符（删除 word2 的字符）：dp[i][j] = dp[i - 1][j] + 1
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                } else if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("word1= ");
        String word1 = sc.nextLine();
        System.out.print("word2= ");
        String word2 = sc.nextLine();
        System.out.println(solution(word1, word2));

    }
}
