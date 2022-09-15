package com.company.bishi.duxiaoman;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        System.out.println(solution(nums, h));
    }

    public static int solution(int[][] nums, int h) {
        int maxR = 0, minL = Integer.MAX_VALUE;
        for (int[] num : nums) {
            maxR = Math.max(maxR, num[1]);
            minL = Math.min(minL, num[0]);
        }
        int[] high = new int[maxR];
        for (int[] num : nums) {
            int l = num[0], r = num[1];
            for (int j = l; j < r; j++) {
                high[j]++;
            }
        }
        int ans = 0;
        for (int i = minL; i < maxR; i++) {
            if (high[i] >= h) ans++;
        }
        return ans;
    }
}

