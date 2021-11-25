package com.company.DataStructure.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	/**
	 * 归并排序
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

		// 测试归并排序
		int[] temp = new int[arr.length]; // 开辟额外存储空间
		mergeSort(arr, 0, arr.length - 1, temp);
	}

	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		/**
		 * 归并排序
		 * @param arr 待排序的数组
		 * @param left 左边起始位置
		 * @param right 右边起始位置
		 * @param temp 存储空间
		 */
		if (left < right) {
			int mid = (left + right) / 2; //中间索引
			//向左递归进行分解
			mergeSort(arr, left, mid, temp);
			//向右递归进行分解
			mergeSort(arr, mid + 1, right, temp);
			//合并
			merge(arr, left, mid, right, temp);
			System.out.println("排序后的数组");
			System.out.println(Arrays.toString(arr));
		}
	}

	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		/**
		 * 合并
		 * @param arr 排序的原始数组
		 * @param left 左边有序序列的初始索引
		 * @param mid 中间索引
		 * @param right 右边索引
		 * @param temp 做中转的数组
		 */
		int i = left; // 初始化i, 左边有序序列的初始索引
		int j = mid + 1; //初始化j, 右边有序序列的初始索引
		int t = 0; // 指向 temp数组 的当前索引

		// 1. 先把左右两边(有序)的数据按照规则填充到temp数组
		//    直到左右两边的有序序列，有一边处理完毕为止
		while (i <= mid && j <= right) {
			// 如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
			// 即将左边的当前元素，填充到 temp数组
			// 然后 t++, i++
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			} else { // 反之,将右边有序序列的当前元素，填充到 temp数组
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}

		// 2. 把有剩余数据的一边的数据依次全部填充到 temp
		// 左边的有序序列还有剩余的元素，就全部填充到temp
		while (i <= mid) {
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		//右边的有序序列还有剩余的元素，就全部填充到temp
		while (j <= right) {
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}

		// 3. 将temp数组的元素拷贝到arr
		// 注意，并不是每次都拷贝所有
		t = 0;
		int tempLeft = left;
		// 一、tempLeft=0，right = 1 //tempLeft=2，right=3 //tL=0 ri=3
		// 最后一次 tempLeft=0，right=7
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
	}
}
