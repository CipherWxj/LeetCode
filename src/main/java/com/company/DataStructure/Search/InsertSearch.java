package com.company.DataStructure.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertSearch {
    public static List<Integer> binarySearchs(int[] arr, int targetValue, int left, int right) {
        /**
         * 自适应权值的二分法
         * @param arr 有序数组
         * @param targetValue 目标值
         * @param left 左侧索引
         * @param right 右侧索引
         * @return
         */
        // 递归终止条件，递归完整个数组仍然没有找到，返回 -1
        // 防止 targetValue 过大或过小 造成 midIndex 越界
        if (left > right || arr[0] > targetValue || arr[arr.length - 1] < targetValue) return null;

        // 自适应权值
        int midIndex = left + (right - left) * (targetValue - arr[left]) / (arr[right] - arr[left]); // 索引位置
        int midValue = arr[midIndex]; // 中间值

        if (midValue < targetValue) {
            return binarySearchs(arr, targetValue, midIndex + 1, right); // 向上递归
        } else if (midValue > targetValue) {
            return binarySearchs(arr, targetValue, left, midIndex - 1); // 向下递归
        } else {
            // 1. 在找到mid 索引值，不要马上返回
            // 2. 向 midIndex 索引值的左边扫描，将所有等于 targetValue 的元素的下标，加入到集合ArrayList
            // 3. 向 midIndex 索引值的右边扫描，将所有等于 targetValue 的元素的下标，加入到集合ArrayList
            // 4. 将Arraylist返回
            List<Integer> resIndexlist = new ArrayList<Integer>();
            //向 midIndex 索引值的左边扫描，将所有等于 targetValue 的元素的下标，加入到集合ArrayList
            int temp = midIndex - 1;
            while (temp >= 0 && arr[temp] == targetValue) {
                // 将 temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp -= 1; //temp左移
            }
            resIndexlist.add(midIndex);

            //向 midIndex 索引值的右边扫描，将所有满足 targetValue， 的元素的下标，加入到集合ArrayList
            temp = midIndex + 1;
            while (temp <= arr.length - 1 && arr[temp] == targetValue) {
                // 将 temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp += 1; //temp右移
            }
            return resIndexlist;
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入一个升序排列的数组：");
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
        List<Integer> resIndexList = binarySearchs(arr, targetValue, 0, arr.length - 1);
        if (resIndexList == null) {
            System.out.println("没有找到!!!");
        } else {
            System.out.println("resIndexList=" + resIndexList);
        }
    }
}
