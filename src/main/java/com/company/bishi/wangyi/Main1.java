/**
 * 牛牛要买 m 个文具，街上有 n 个文具店，第 i 个商店有 yi 个单价为 xi 的文具，
 * 牛牛最少要花多少钱才能买到 m 个文具？
 */
package com.company.bishi.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
            x[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, y, x));
    }

    public static int solution(int n, int m, int[] nums, int[] prices) {
        // HashMap 记录单价和数量关系
        // key：单价   value：数量
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.isEmpty() && map.containsKey(prices[i])) {
                map.put(prices[i], map.get(prices[i]) + nums[i]);
            } else {
                map.put(prices[i], nums[i]);
            }
        }

        // 单价排序
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        int[] pri = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            pri[i] = keys[i];
        }
        Arrays.sort(pri);

        // 从小往大买，不用管商店位置
        int pay = 0, i = 0;
        while (m > 0 && i < n) {
            if (m >= map.get(pri[i])) {
                pay += map.get(pri[i]) * pri[i];
                m -= map.get(pri[i]);
            } else {
                pay += m * pri[i];
                m = 0;
            }
            i++;
        }
        return pay;
    }
}
