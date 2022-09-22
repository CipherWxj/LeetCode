package com.company.bishi.mayi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[][] a = new int[q][3];
        int outN = 0;
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
                if (j == 0 && a[i][j] == 2) outN++;
            }
        }
        int[] ans = new int[outN];
        int k = 0;
        for (int i = 0; i < q; i++) {
            if (a[i][0] == 1) {
                nums[a[i][1] - 1] = a[i][2];
            } else {
                int count = 0;
                for (int j = 0; j < a[i][1]; j++) {
                    if (nums[j] == a[i][2]) count++;
                }
                ans[k++] = count;
            }
        }
        for (int i = 0; i < outN; i++) {
            System.out.println(ans[i]);
        }
    }
}