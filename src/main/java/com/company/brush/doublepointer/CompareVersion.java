/**
 * @author: Wxj
 * 165. 比较版本号
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。
 * 每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。
 * 修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。
 * 例如，2.5.33 和 0.1 都是有效的版本号。
 *
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。
 * 比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。
 * 如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
 * 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 *
 * 返回规则如下：
 *
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。

 * <p>输入描述:
 * version1 = "1.0", version2 = "1.0.0"
 * <p>输出描述:
 * 0
 */
package com.company.brush.doublepointer;

public class CompareVersion {

    // 直接用split（）函数分割
    public int solution1(String version1, String version2) {
        // 利用split函数分割修订号，注意“.”的转义！
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        // 题目要求说明修订号都可以存储在 32位整数 中，直接parseInt比较
        for(int i = 0; i < Math.max(v1.length, v2.length); i++){
            int x = i > v1.length - 1 ? 0 : Integer.parseInt(v1[i]);
            int y = i > v2.length - 1 ? 0 : Integer.parseInt(v2[i]);
            if(x > y) return 1;
            if(x < y) return -1;
        }
        return 0;
    }

    // 双指针分割
    public int solution2(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();

        // 初始化双指针，用于遍历版本号
        int i = 0, j = 0;
        while(i < len1 || j <len2){
            // 版本号version1遍历到“.”计算修订号
            int x = 0;
            while(i < len1 && version1.charAt(i) != '.'){
                x = x * 10 + version1.charAt(i) - '0';
                i++;
            }
            // 版本号version2遍历到“.”计算修订号
            int y = 0;
            while(j < len2 && version2.charAt(j) != '.'){
                y = y * 10 + version2.charAt(j) - '0';
                j++;
            }
            if(x > y) return 1;
            if(x < y) return -1;
            // “.”的位置要遍历掉！！
            i++;
            j++;
        }
        return 0;
    }
}
