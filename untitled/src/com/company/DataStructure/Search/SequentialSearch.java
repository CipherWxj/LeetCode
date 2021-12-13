package com.company.DataStructure.Search;

import java.util.Scanner;

public class SequentialSearch {

    public static int seqSearch(int[] arr, int value) {
        /**
         * 这里我们实现的线性查找是找到一个满足条件的值，就返回
         * @param arr 无序数组
         * @param value 查找的值
         * @return
         */
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数组：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println("请输入所要查找的值：");
        int targetValue = sc.nextInt();
        int index = seqSearch(arr, targetValue);
        if (index == -1) {
            System.out.println("没有找到到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }
}
