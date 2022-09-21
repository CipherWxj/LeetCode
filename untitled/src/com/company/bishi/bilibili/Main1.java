package com.company.bishi.bilibili;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int evenMax = 0, evenSum = 0;
        for (int i = 1; i < n; i += 2) {
            evenMax = Math.max(evenMax, nums[i]);
            evenSum += nums[i];
        }
        int oddMin = 10001, oddSum = 0;
        for (int i = 0; i < n; i += 2) {
            oddMin = Math.min(oddMin, nums[i]);
            oddSum += nums[i];
        }
        if (oddMin < evenMax) {
            evenSum -= evenMax;
            oddSum -= oddMin;
            System.out.println(oddSum + evenMax - (evenSum + oddMin));
        } else {
            System.out.println(oddSum - evenSum);
        }
    }
}
