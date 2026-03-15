package com.company.DataStructure.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    /**
     * 基数排序（桶排序）
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

        // 测试基数排序
        radixSort(arr);


    }

    public static void radixSort(int[] arr) {
        /**
         * 基数排序
         */
        // 得到数组中最大的数的位数
        int max = arr[0]; // 假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 得到最大数是几位数
        int maxLength = String.valueOf(max).length();


        // 定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        // 1. 二维数组包含10个一维数组
        // 2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        // 比如：bucketElementCounts[0]记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        // 对数位循环处理，个位、十位、百位
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int value : arr) {
                // 取出每个元素的对应位的值
                int digitOfElement = value / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }
            // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            // 遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                // 第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + (i + 1) + "排序处理 arr =" + Arrays.toString(arr));
        }
    }
}
