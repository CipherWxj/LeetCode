package com.company.bishi.xiecheng;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 2) {
            System.out.println(20);
        } else {
            int ans1 = 1 + 2 + 3 + 4;
            long ans2 = 0;
            long ans3 = 0;
            for (long i = 5; i <= (n - 1) * 4L; i++) {
                ans2 += i;
            }
            for (long i = (n - 1) * 4L + 1; i <= (long) n * n; i++) {
                ans3 += i;
            }
            long a = ans1 % 1000000007;
            long b = ans2 % 1000000007;
            long c = ans3 % 1000000007;
            System.out.println((a * 2 + b * 3 + c * 4) % 1000000007);
        }
    }
}
