package com.company.bishi.duxiaoman;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int[] res = new int[t];
        for (int k = 0; k < t; k++) {
            String ns = sc.nextLine();
            String[] nst = ns.split(" ");
            int n = Integer.parseInt(nst[0]);
            int p = Integer.parseInt(nst[1]);
            String s = sc.nextLine();
            int[][] a = new int[p][30];
            for (int i = 0; i < n; i++) {
                a[i % p][s.charAt(i) - 'a']++;
            }
            int max = 0, ans = 0;
            for (int i = 0; i < p / 2; i++) {
                max = 0;
                for (int j = 0; j < 26; j++) {
                    max = Math.max(max, a[i][j] + a[p - i - 1][j]);
                }
                ans += 2 * n / p - max;
            }
            if (p % 2 == 1) {
                max = 0;
                for (int i = 0; i < 26; i++) {
                    max = Math.max(max, a[p / 2][i]);
                }
                ans += n / p - max;
            }
            res[k] = (ans);
        }
        for (int i = 0; i < t; i++) {
            System.out.println(res[i]);
        }
    }
}
