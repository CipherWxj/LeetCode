package com.company.bishi.weilai;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(solution(x));
    }

    public static int solution(int x) {
        int i = 0;
        while (i * i < x) {
            i++;
        }
        if (i * i == x) return 0;
        int left = i-1;
        while ((x - left * left) % 2 != 0) left--;
        int l = (x - left * left) / 2;
        int right = i;
        while ((right * right - x) % 2 != 0) right++;
        int r = (right * right - x) / 2;
        return Math.min(l, r);
    }
}
