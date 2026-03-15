package com.company.DataStructure.SparseArray;

public class SparseArray {

	public static void main(String[] args) {
		// 创建原始二维数组（棋盘）
		// 大小：11*11  0：空  1：黑子  2：白子
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;

		// 打印
		System.out.println("原始的二维数组：");
		for (int[] row : chessArr1) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// 将 二维数组 转为 稀疏数组
		// 1. 计算非零元素的个数
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}

		// 2. 创建稀疏数组
		int sparseArr[][] = new int[sum + 1][3];
		// 稀疏数组第一行
		sparseArr[0][0] = 11; //原始数组的行数
		sparseArr[0][1] = 11; //原始数组的列数
		sparseArr[0][2] = sum; //原始数组中非零元素的个数

		// 遍历二维数组，将非零值存入稀疏数组
		int count = 0; //计数器，记录非零元素个数
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i; //行索引
					sparseArr[count][1] = j; //列索引
					sparseArr[count][2] = chessArr1[i][j]; //非零元素值
				}
			}
		}

		// 打印稀疏数组
		System.out.println();
		System.out.println("转成的稀疏数组为：");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
		System.out.println();

		// 稀疏数组 恢复为 二维数组
		// 1.根据稀疏数组第一行元素创建二维数组
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

		// 2.根据索引填入元素
		for (int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		// 打印
		System.out.println("恢复后的二维数组为：");
		for (int[] row : chessArr2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}
}
