/**
 * @author: Wxj
 * 468. 验证IP地址
 * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。
 * 例如: “192.168.1.1”、 “192.168.1.0” 为有效IPv4地址，
 * “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
 * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
 * 1 <= xi.length <= 4
 * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 在 xi 中允许前导零。
 * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，
 * 而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
 * <p>输入描述:
 * queryIP = "172.16.254.1"
 * <p>输出描述:
 * "IPv4"
 */
package com.company.brush.array_string;

public class ValidIPAddress {
    public String solution(String queryIP) {
        // 最短长度7位， 0.0.0.0
        if (queryIP.length() < 7) return "Neither";
        for (int i = 1; i < 5; i++) {
            // 如果前四位有 . 则判断是不是ipv4
            if (i < 4 && queryIP.charAt(i) == '.') return isIPv4(queryIP);
            // 如果前五位有 : 则判断是不是ipv6
            if (queryIP.charAt(i) == ':') return isIPv6(queryIP);
        }
        return "Neither";
    }

    public String isIPv6(String queryIP) {
//        if (queryIP.charAt(queryIP.length() - 1) == ':') return "Neither";
//        String[] str = queryIP.split(":");
        // split函数如果不指定分割的最小长度，会剔除末尾的空字符串！！！
        // 2001:0db8:85a3:0:0:8A2E:0370:7334:  这种会被判定为ipv6
        String[] str = queryIP.split(":", -1);
        // 分割后长度不为 8，不合理
        if (str.length != 8) return "Neither";
        int j;
        for (int i = 0; i < 8; i++) {
            String s = str[i];

            // 中间有空字符串的情况
            if (s.equals("")) return "Neither";

            j = 0;
            while (j < s.length()) {
                // 合理的字符，继续遍历
                if ((s.charAt(j) >= '0' && s.charAt(j) <= '9') || (s.charAt(j) >= 'a' && s.charAt(j) <= 'f') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'F')) {
                    j++;
                } else { // 不合理的字符
                    return "Neither";
                }
            }
            // 遍历完如果 子串长度>4, 不合理
            if (j > 4) {
                return "Neither";
            }
        }
        // 遍历完，合理
        return "IPv6";
    }

    public String isIPv4(String queryIP) {
//        if (queryIP.charAt(queryIP.length() - 1) == '.') return "Neither";
//        String[] str = queryIP.split("\\.");
        // split函数如果不指定分割的最小长度，会剔除末尾的空字符串！！！
        // 255.255.255.255.  这种会被判定为ipv4
        String[] str = queryIP.split(":", -1);
        // 分割后长度不为 4，不合理
        if (str.length != 4) return "Neither";
        int j, num;
        for (int i = 0; i < 4; i++) {
            String s = str[i];
            // 中间有空字符串的情况 和 有先导 0（注意单个0是合理的！）
            if (s.equals("") || (s.length() != 1 && s.charAt(0) == '0')) return "Neither";

            j = 0;
            num = 0;
            while (j < s.length()) {
                // 是合法的数字，计算数值，继续遍历
                if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                } else { // 不合理的字符
                    return "Neither";
                }
            }
            // 遍历完如果 子串长度>3 或 数值>255, 不合理
            if (j > 3 || num > 255) {
                return "Neither";
            }
        }
        // 遍历完，合理
        return "IPv4";
    }
}
