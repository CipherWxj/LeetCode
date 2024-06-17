package com.company.bishi.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 法术数量
        long k = sc.nextLong(); // 需要的威力值

        long[] power = new long[n]; // power[i]表示第i个法术的威力
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextLong();
        }
        System.out.println(solution(power, k));
    }

    public static long solution(long[] power, long k) {
        int n = power.length;
        Arrays.sort(power);
        if (power[0] >= k) return (long) n * n - n;

        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (power[i] >= k) {
                ans += i;
            } else {
                int j = 0;
                while (j < n) {
                    if (j != i && power[i] * power[j] >= k) {
                        ans++;
                    }
                    j++;
                }
            }
        }
        return ans;
    }
}
