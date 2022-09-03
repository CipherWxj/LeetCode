package com.company.bishi.meituan3;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(solution(a, b));
    }

    public static int solution(int a, int b) {
        if (a < 11) {
            if (b <= 9) {
                return 11 - a;
            } else if (b == 10) {
                return 12 - a;
            } else if (b == 11) {
                return 13 - a;
            }
        } else {
            if (a > b) {
                return 1;
            } else {
                return b - a + 2;
            }
        }
        return 0;
    }
}
