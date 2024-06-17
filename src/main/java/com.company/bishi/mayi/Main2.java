package com.company.bishi.mayi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String k = sc.nextLine();
        int count = 0;
        int ns = s.length(), nk = k.length();
        if (ns < nk) System.out.println(0);
        for (int i = 0; i < nk - 1; i++) {
            count += (ns - i);
        }
        for (int i = 0; i <= ns - nk; i++) {
            int j = i;
            while (j < i + nk && s.charAt(j) <= k.charAt(j - i)) {
                j++;
                if (j == i + nk && s.charAt(j - 1) < k.charAt(j - 1 - i)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
