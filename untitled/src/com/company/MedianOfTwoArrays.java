package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MedianOfTwoArrays {

    public static double solution(int[] num1, int[] num2) {
        int[] num;
        int n1 = num1.length;
        int n2 = num2.length;
        int n = n1 + n2;
        num = new int[n];

        if (n1 == 0 && n2 != 0) {
            if (n2 % 2 == 0) {
                return (num2[n2 / 2 - 1] + num2[(n2 / 2)]) / 2.0;
            } else {
                return num2[(n2 - 1) / 2];
            }
        }

        if (n1 != 0 && n2 == 0) {
            if (n1 % 2 == 0) {
                return (num1[n1 / 2 - 1] + num1[(n1 / 2)]) / 2.0;
            } else {
                return num1[(n1 - 1) / 2];
            }
        }

        if (n1 != 0 && n2 != 0) {
            System.arraycopy(num1, 0, num, 0, n1);

            System.arraycopy(num2, 0, num, 0 + n1, n2);

            Arrays.sort(num);

            if (n % 2 == 0) {
                return (num[n / 2 - 1] + num[(n / 2)]) / 2.0;
            } else {
                return num[(n - 1) / 2];
            }
        }
        return 0;
    }

    public static int[] input(String s) {
        if (s.length() > 2) {
            String str = s.substring(1, s.length() - 1); //去掉首尾[]
            String[] arr = str.split(","); //按,分隔
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]); //string强制转换成int型
            }
            return nums;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("num1=");
        String s1 = sc.nextLine();
        int[] num1 = input(s1);
        System.out.print("num2=");
        String s2 = sc.nextLine();
        int[] num2 = input(s2);
        System.out.println(solution(num1, num2));
    }
}

