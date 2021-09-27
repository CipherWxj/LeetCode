/**
 * @author: Wxj
 * 给定一个整数数组nums和一个整数目标值target，
 * 请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标；
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现；
 * 你可以按任意顺序返回答案。
 * <p>输入描述:
 * nums = [2,7,11,15]
 * target = 9
 * <p>输出描述:
 * [0,1]
 */

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfDouble {
    public static int[] solution(int[] nums, int target) {
        int[] res = new int[2]; //结果容器
        for (int i = 0; i < nums.length - 1; i++) { //从第一个元素开始，倒数第二个结束
            for (int j = i + 1; j < nums.length; j++) { //从后一个元素开始相加
                if (nums[i] + nums[j] == target) { //判断
                    res[0] = i;
                    res[1] = j; //结果赋值
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nums=");
        String input = sc.nextLine(); //输入string
        String str = input.substring(1, input.length() - 1); //去掉首尾[]
        String[] arr = str.split(","); //按,分隔
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]); //string强制转换成int型
        }
        System.out.print("target=");
        int target = sc.nextInt();
        System.out.println(Arrays.toString(solution(nums, target))); //int型数组强制转换成string打印输出
    }
}
