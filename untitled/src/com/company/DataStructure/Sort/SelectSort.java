package com.company.DataStructure.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectSort {
	/**
	 * 选择排序
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

		// 测试选择排序
		selectSort(arr);
	}

	public static void selectSort(int[] arr) {
		/**
		 * 选择排序  最大的数放在最后
		 */
		// 选择排序 的时间复杂度 O(n^2)
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i; // 最小值位置索引
			int min = arr[i]; // 临时存储最小值
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) { //
					min = arr[j]; // 最小值
					minIndex = j; // minIndex
				}
			}

			// 将最小值，放在arr[i], 即交换
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}

			System.out.println("第" + (i + 1) + "趟排序后的数组");
			System.out.println(Arrays.toString(arr));
		}
	}
}
