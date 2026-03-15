package com.company.bishi.interview;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 12 == 0) {
            System.out.println((n / 12) * 4);
        } else {
            System.out.println((n / 12) * 4 + 2);
        }
    }
}

