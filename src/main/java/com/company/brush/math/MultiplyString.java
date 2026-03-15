/**
 * @author: Wxj
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>输入描述:
 * num1 = "123", num2 = "456"
 * <p>输出描述:
 * "56088"
 */
package com.company.brush.math;

public class MultiplyString {
    public static String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        // 排除一个乘数为0的特殊情况，否则返回多位0，如“0000”
        if((len1 == 1 && num1.charAt(0) == '0') || (len2 == 1 && num2.charAt(0) == '0')) return "0";
        // 初始化结果
        StringBuffer res = new StringBuffer("0");
        // 第一个乘数每一位依次乘第二个乘数
        for(int i = 0; i < len1; i++){
            int x = num1.charAt(len1 - 1 - i) - '0';
            // 结果 逆序！！！
            StringBuffer temp = new StringBuffer();
            // 这个地方一定要补0（十位、百位……）
            for(int k = 0; k < i; k++){
                temp.append(0);
            }
            // 进位
            int carry = 0;
            // 与第二个乘数的每一位相乘再相加
            for(int j = 0; j < len2; j++){
                int y = num2.charAt(len2 - 1 - j) - '0';
                int bitAns = x * y + carry;
                temp.append(bitAns % 10);
                carry = bitAns / 10;
            }
            // 不要忘记最后的进位判断！！！
            if(carry != 0){
                temp.append(carry);
            }
            // 每一位相乘之后再依次相加
            res = add(res, temp);
        }
        return res.reverse().toString();
    }

    // 见leetcode 415题，两个字符串相加
    // 区别在于这里两个字符串本来就是逆序的，逆序输入，逆序输出！
    public static StringBuffer add(StringBuffer s1, StringBuffer s2){
        int len1 = s1.length(), len2 = s2.length();
        StringBuffer res = new StringBuffer();
        int carry = 0;
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int x = (i > len1 - 1) ? 0 : s1.charAt(i) - '0';
            int y = (i > len2 - 1) ? 0 : s2.charAt(i) - '0';
            int bitSum = x + y + carry;
            res.append(bitSum % 10);
            carry = bitSum / 10;
        }
        if(carry != 0){
            res.append(carry);
        }
        return res;
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
