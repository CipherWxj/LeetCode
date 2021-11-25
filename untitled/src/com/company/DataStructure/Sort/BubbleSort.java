package com.company.DataStructure.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    /**
     * 冒泡排序
     */

    public static void main(String[] args) {

        System.out.println("请输入随机数组，用逗号隔开：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arrs = s.split(",");
        int[] arr = new int[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            arr[i] = Integer.parseInt(arrs[i]);
        }

        // 测试冒泡排序
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        /**
         * 冒泡排序  最大的数放在最后
         */

        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));

            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }
        }
    }
}
