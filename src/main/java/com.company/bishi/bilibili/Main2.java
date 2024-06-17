package com.company.bishi.bilibili;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] s = new int[4];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[0] = matrix[i][j];
                s[1] = matrix[n - i - 1][j];
                s[2] = matrix[i][m - j - 1];
                s[3] = matrix[n - i - 1][m - j - 1];
                Arrays.sort(s);
                for (int k = 0; k < 4; k++) {
                    ans += Math.abs(s[k] - s[1]);
                }
            }
        }
        System.out.println(ans / 4);
    }
}
