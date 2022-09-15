package com.company.bishi.xiecheng;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int[] ans = new int[t];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            String[] str = s.split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(str[j]);
            }
            String clo = sc.nextLine();
            ans[i] = solution(nums,clo);
        }
        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int solution(int[] nums, String clo) {
        int n = nums.length;
        if (n == 1) return 0;
        // 分别找出红的、蓝的最大最小值
        int minR = Integer.MAX_VALUE, maxR = 0, minB = Integer.MAX_VALUE, maxB = 0, rLen = 0, bLen = 0;
        for (int i = 0; i < n; i++) {
            if (clo.charAt(i) == 'R') {
                maxR = Math.max(maxR, nums[i]);
                minR = Math.min(minR, nums[i]);
                rLen++;
            } else {
                maxB = Math.max(maxB, nums[i]);
                minB = Math.min(minB, nums[i]);
                bLen++;
            }
        }
        // 操作无效的情况先去掉
        // 全蓝
        if (rLen == 0) return maxB - minB;
        // 全红
        if (bLen == 0) return maxR - minR;
        // 蓝的最小值比红的最小值小 且 红的最大值比蓝的最大值 大
        if (maxR >= maxB && minB <= minR) return maxR - minB;
        // 可操作
        int min = Integer.MAX_VALUE;
        // 考虑边界大于0
        while ((maxR < maxB || minR < minB) && minR > 0 && minB > 0) {
            maxR++;
            minR++;
            min = Math.min(min, Math.max(maxB, maxR) - Math.min(minB, minR));
            maxB--;
            minB--;
            min = Math.min(min, Math.max(maxB, maxR) - Math.min(minB, minR));
        }
        return min;
    }
}
