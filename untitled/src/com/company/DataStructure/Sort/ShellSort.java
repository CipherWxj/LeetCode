package com.company.DataStructure.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
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

		// 测试希尔排序
		shellSort1(arr);
		shellSort2(arr);
	}

	public static void shellSort1(int[] arr) {
		/**
		 * 希尔排序  从小到大  交换
		 */
		int temp = 0;
		int count = 0;

		for (int gap = arr.length / 2; gap > 0; gap /= 2) { // 间隔分组，增量递减
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组中所有的元素(共gap组，每组有length/gap个元素), 步长gap
				// 交换排序
				for (int j = i - gap; j >= 0; j -= gap) {
					// 如果当前元素大于加上步长后的那个元素，向前交换
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			System.out.println("第" + (++count) + "趟排序后的数组");
			System.out.println(Arrays.toString(arr));
		}
	}

	public static void shellSort2(int[] arr) {
		/**
		 * 希尔排序  从小到大  前移
		 */
		int count = 0;

		for (int gap = arr.length / 2; gap > 0; gap /= 2) { // 间隔分组，增量递减
			// 从第gap个元素，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int insertIndex = i;
				int insertVal = arr[insertIndex];
				if (arr[insertIndex] < arr[insertIndex - gap]) {
					while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
						arr[insertIndex] = arr[insertIndex - gap]; // arr[insertIndex-gap]右移
						insertIndex -= gap; // 索引左移，再与前一个数比较
					}
					arr[insertIndex] = insertVal; // 插入
				}
			}
			System.out.println("第" + (++count) + "趟排序后的数组");
			System.out.println(Arrays.toString(arr));
		}
	}
}
