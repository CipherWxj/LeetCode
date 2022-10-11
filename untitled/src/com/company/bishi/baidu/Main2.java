package com.company.bishi.baidu;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = 1000000001, r = -1;
        int[] seq = new int[1000000000];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            l = Math.min(l, s);
            int t = sc.nextInt();
            for (int j = s - 1; j < t - 1; j++) {
                seq[j] += 1;
            }
        }
        int max = 0, minIndex = -1;
        for (int i = l; i < r; i++) {
            if (seq[i] > max) {
                max = seq[i];
                minIndex = i + 1;
            }
        }
        System.out.println(minIndex + " " + max);
    }
}
