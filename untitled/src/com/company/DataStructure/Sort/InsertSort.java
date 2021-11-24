package com.company.DataStructure.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSort {

    public static void main(String[] args) {

        System.out.println("请输入随机数组，用逗号隔开：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arrs = s.split(",");
        int[] arr = new int[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            arr[i] = Integer.parseInt(arrs[i]);
        }

        // 测试插入排序
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        /**
         * 插入排序 从小到大
         */
        int insertVal = 0; // 插入值
        int insertIndex = 0; // 插入位置
        // 插入排序 的时间复杂度 O(n^2)
        for (int i = 1; i < arr.length; i++) { // 第一位默认，从第二个数开始

            insertVal = arr[i]; // 取出无序表中的数
            insertIndex = i - 1; // 从其前一个位置开始插入

            // 给insertVal 找到插入的位置
            // 1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 右移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex]; // arr[insertIndex] 右移
                insertIndex--; // 索引左移，再与前一个数比较
            }

            if (insertIndex + 1 != i) {  // 位置更改
                arr[insertIndex + 1] = insertVal; // 插入
            }

            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }
}
