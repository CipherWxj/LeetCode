package com.company.DataStructure.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    /**
     * 希尔排序
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

        // 测试快速排序
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        /**
         * 快速排序
         */
        int l = left; // 左下标
        int r = right; // 右下标

        int pivot = arr[(left + right) / 2]; // 基准数据，取中间的数
        int temp = 0; // 临时变量

        //比pivot 值小放到左边；比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果l >= r说明pivot 的左右两边的值已经按照左边全部是小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 规避数组中有其他与 pivot 相等的数
            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l++;
            }
        }
        System.out.println("排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 如果 l == r, 说明左右都遍历到了基准数据位置，必须l++, r--
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
