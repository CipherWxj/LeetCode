/**
 * @author: Wxj
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入'.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>输入描述:
 * s = "25525511135"
 * <p>输出描述:
 * ["255.255.11.135","255.255.111.35"]
 */
package com.company.brush.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestoreIpAddresses {
    public static List<String> solution(String s) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    // 回溯
    public static void backtrack(List<String> res, StringBuilder ip, String s, int part, int startIndex) {
        // 终止条件
        if (startIndex == s.length() && part == 4) {
            // 这里新建一个 字符串，不操作 原字符串，为了后面 回溯时操作一致！
            // 例如：ip  255.255.11.135.
            // 这里一定要 new 一个新的对象！单纯的定义指针StringBuilder ans = ip不起作用，回忆String对象的内存结构
            StringBuilder ans = new StringBuilder(ip);
            // 去除最后的 "."  变成 255.255.11.135
            ans.deleteCharAt(ans.length() - 1);
            res.add(ans.toString());
            return;
        }

        // 剩余的长度不合法就返回
        if ((s.length() - startIndex) > 3 * (4 - part) || (s.length() - startIndex) < (4 - part)) {
            return;
        }

        // 排除前导 0，如果起始位置为 0 则必须 该部分只存在 0
        if (s.charAt(startIndex) == '0') {
            ip.append('0').append('.');
            backtrack(res, ip, s, part + 1, startIndex + 1);
            // 回溯修剪
            ip.delete(ip.length() - 2, ip.length());
            // 这个return不能忘了！
            return;
        }

        // 常规寻找
        for (int i = 0; i < 3; i++) {
            // 越界
            if ((startIndex + i) > (s.length() - 1)) break;
            // 有效，则搜索
            if (isAvailable(s, startIndex, startIndex + i)) {
                ip.append(s, startIndex, startIndex + i + 1).append('.');
                backtrack(res, ip, s, part + 1, startIndex + i + 1);
                // 回溯修剪
                ip.delete(ip.length() - 2 - i, ip.length());
            }
        }

    }

    // 判断是否有效，<=255
    public static boolean isAvailable(String s, int start, int end) {
        int num = 0;
        for (int i = 0; i < (end - start + 1); i++) {
            num = num * 10 + s.charAt(start + i) - '0';
        }
        return num <= 255;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine()));
    }
}
