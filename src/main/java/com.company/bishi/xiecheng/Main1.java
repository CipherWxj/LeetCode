package com.company.bishi.xiecheng;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        double ans = 0;
        // 偶数刀，横竖相等
        if (k % 2 == 0) {
            ans = 1.0 * n * n / ((1.0 * k / 2 + 1) * (1.0 * k / 2 + 1));
        } else { // 奇数刀，横竖差1刀
            ans = 1.0 * n * n / ((1.0 * (k + 1) / 2) * (1.0 * (k + 1) / 2 + 1));
        }
        System.out.printf("%.2f", ans);
    }
}