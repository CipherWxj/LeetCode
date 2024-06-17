package com.company.bishi.weilai;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int[] hotel = new int[n];
        int[] pay = new int[n];
        for (int i = 0; i < n; i++) {
            hotel[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        System.out.println(solution(n, k, p, hotel, pay));
    }

    public static int solution(int n, int k, int p, int[] hotel, int[] pay) {
        int ans = 0;
        for (int l = 0; l < n; l++) {
            int r = n - 1;
            while (r > l) {
                if (hotel[r] == hotel[l]) {
                    for (int j = l; j <= r; j++) {
                        if (pay[j] <= p) ans++;
                    }
                }
                r--;
            }
        }
        return ans;
    }
}
