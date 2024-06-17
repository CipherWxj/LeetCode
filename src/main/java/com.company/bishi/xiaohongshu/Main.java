package com.company.bishi.xiaohongshu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 大臣数
        int m = sc.nextInt(); // 重要性数量
        int id = sc.nextInt(); // 求帮忙的大臣
        int[][] imp = new int[n][m]; // imp[i][j]表示序号为i的大臣的汇报在第j个方面的重要性
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                imp[i][j] = sc.nextInt();
            }
        }

        int[] impSum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                impSum[i] += imp[i][j];
            }
        }

        int tar = impSum[id - 1];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (i == id - 1) continue;
            if (impSum[i] > tar) {
                ans++;
            } else if (impSum[i] == tar && i < id - 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
