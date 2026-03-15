package com.company.bishi.xiecheng;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] a = new int[2][2];
        int[][] b = new int[2][2];
        int[] ans = new int[t];
        for (int i = 0; i < t; i++) {
            // 管他三七二十一，挨个赋值
            a[0][0] = sc.nextInt();
            a[0][1] = sc.nextInt();
            a[1][0] = sc.nextInt();
            a[1][1] = sc.nextInt();
            b[0][0] = sc.nextInt();
            b[0][1] = sc.nextInt();
            b[1][0] = sc.nextInt();
            b[1][1] = sc.nextInt();
            int a0 = 0, b0 = 0; // 先统计一下两个矩阵中 0的个数
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (a[j][k] == 0) a0++;
                    if (b[j][k] == 0) b0++;
                }
            }
            // 个数不同，交换到死也不行
            if (a0 != b0) {
                ans[i] = -1;
            } else { // 个数相同，一定能交换成功
                boolean[][] v = isSame(a, b); // 就四个位置，讨论也就几种情况，穷举就完事了
                // 1、四个位置都相同（0个位置不同）
                if (v[0][0] && v[0][1] && v[1][0] && v[1][1]) ans[i] = 0;
                // 2、四个位置都不同 （4个位置不同）
                // 3、有一条对角线不同（2个位置不同的特殊情况）
                else if ((v[0][0] && !v[0][1] && !v[1][0] && v[1][1]) || (!v[0][0] && v[0][1] && v[1][0] && !v[1][1]) || (!v[0][0] && !v[0][1] && !v[1][0] && !v[1][1]))
                    ans[i] = 2;
                // 其他2个位置不同的情况
                else ans[i] = 1;
                // 不可能存在奇数个位置不同！！！
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }
    }

    public static boolean[][] isSame(int[][] a, int[][] b) {
        boolean[][] res = new boolean[2][2];
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                res[j][k] = a[j][k] == b[j][k];
            }
        }
        return res;
    }
}
