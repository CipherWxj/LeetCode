package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MedianOfTwoArrays {

    public static double solution(int[] num1, int[] num2) {
        int[] num;
        if (num1 != null && num2 != null) {
            int n1 = num1.length;
            int n2 = num2.length;
            int n = n1 + n2;
             num = new int[n];

            for (int k = 0; k < n1; k++) {
                num[k] = num1[k];
            }

            for (int k = 0; k < n2; k++) {
                num[k + n1] = num2[k];
            }
        } else if (num1 == null && num2 != null) {
             num = num2;
        } else if (num2 == null && num1 != null) {
             num = num1;
        } else {
            return 0.0;
        }

//        //第一个循环用来遍历数组中的所有数字
//        for (int i = 0; i < n; i++) {
//            //初始化一个变量，用来记录最小数字的下标。初始默认假设第一个数字就是最小数字
//            int minIndex = i;
//            //第二个循环，通过比较获取数组中最小的数字的下标。
//            for (int j = i + 1; j < n; j++) {
//                //如果找到更小的数字，
//                if (num[minIndex] >= num[j]) {
//                    //将minIndex变量的值修改为新的最小数字的下标。
//                    minIndex = j;
//                }
//            }
//            //所有数字一个个比较结束之后，就能确认那个数字最小了。
//            //将最小的数字替换到第一个位置，将第一个位置的数字放到最小数字原来的位置，就是一次交换。
//            int temp = num[i];
//            num[i] = num[minIndex];
//            num[minIndex] = temp;
//        }
        Arrays.sort(num);
        if (num.length % 2 == 0) {
            return (num[num.length / 2 - 1] + num[(num.length / 2)]) / 2.0;
        } else {
            return num[(num.length - 1) / 2];
        }
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

