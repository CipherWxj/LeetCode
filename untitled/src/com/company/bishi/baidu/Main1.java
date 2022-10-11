package com.company.bishi.baidu;

import java.util.Scanner;

public class Main1 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[5][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            if (s.length() == 1) {
                outer:
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < n; k++) {
                        if (a[j][k] != 0) {
                            System.out.println(a[j][k]);
                            a[j][k] = 0;
                            break outer;
                        }
                    }
                }
            } else {
                String[] str = s.split(" ");
                int num = Integer.parseInt(str[1]);
                int numIndex = Integer.parseInt(str[2]);
                a[numIndex - 1][num - 1] = num;
            }
        }
    }
}
