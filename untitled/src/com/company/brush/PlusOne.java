/**
 * @author: Wxj
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>输入描述:
 * digits = [1,2,3]
 * <p>输出描述:
 * [1,2,4]
 */
package com.company.brush;

import java.util.Arrays;
import java.util.Scanner;

public class PlusOne {
    public static int[] solution(int[] digits) {
        // 从后往前反向遍历
        for (int i = digits.length - 1; i >= 0; i--) {
            // +1!=9,则该位+1返回
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            // +1==9,则该位赋值0，向前一位遍历，进位也为+1
            digits[i] = 0;
        }
        // 全部遍历完则说明所有位置上均为9，则数组长度+1，最高位1，其余位0
        int[] allNine = new int[digits.length + 1];
        allNine[0] = 1;
        return allNine;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个一位整数构成的数组：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(Arrays.toString(solution(arr)));
    }
}
