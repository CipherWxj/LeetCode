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
		
		
		/*
		
		//ʹ�����Ƶ��ķ�ʽ��������ѡ������
		//��1��
		//ԭʼ������ �� 	101, 34, 119, 1
		//��һ������ :   	1, 34, 119, 101
		//�㷨 �ȼ�--�� �����ӣ� ���ǿ��԰�һ�����ӵ��㷨����ֳɼ򵥵�����-���𲽽��
		
		//��1��
		int minIndex = 0;
		int min = arr[0];
		for(int j = 0 + 1; j < arr.length; j++) {
			if (min > arr[j]) { //˵���ٶ�����Сֵ����������С
				min = arr[j]; //����min
				minIndex = j; //����minIndex
			}
		}
		
		
		//����Сֵ������arr[0], ������
		if(minIndex != 0) {
			arr[minIndex] = arr[0];
			arr[0] = min;
		}
		
		System.out.println("��1�ֺ�~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
		
		
		//��2��
		minIndex = 1;
		min = arr[1];
		for (int j = 1 + 1; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
				min = arr[j]; // ����min
				minIndex = j; // ����minIndex
			}
		}

		// ����Сֵ������arr[0], ������
		if(minIndex != 1) {
			arr[minIndex] = arr[1];
			arr[1] = min;
		}

		System.out.println("��2�ֺ�~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
		
		//��3��
		minIndex = 2;
		min = arr[2];
		for (int j = 2 + 1; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
				min = arr[j]; // ����min
				minIndex = j; // ����minIndex
			}
		}

		// ����Сֵ������arr[0], ������
		if (minIndex != 2) {
			arr[minIndex] = arr[2];
			arr[2] = min;
		}

		System.out.println("��3�ֺ�~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 101, 119 */


	}

}
