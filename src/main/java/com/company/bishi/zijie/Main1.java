package com.company.bishi.zijie;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String nu = sc.nextLine();
        String[] texts = new String[n];
        for (int i = 0; i < n; i++) {
            texts[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(solution(n, texts)[i]);
        }
    }

    public static String[] solution(int n, String[] texts) {
        String[] res = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = texts[i];
            if (isSeries(s)) {
                res[i] = "yes";
            }else if (!map.isEmpty() && map.containsKey(s) && i - map.get(s) < 10) {
                res[i] = "yes";
            } else {
                res[i] = "no";
            }
            map.put(s, i);
        }
        return res;
    }

    public static boolean isSeries(String s) {
        int len = s.length();
        if (len < 5) return false;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'q' || s.charAt(i) == 'w' || s.charAt(i) == 'k' || s.charAt(i) == 'h' || s.charAt(i) == 'j') {
                dp[i + 1] = true;
                if (dp[i]) {
                    count++;
                } else {
                    count = 0;
                }
            }
            if (count == 5) {
                return true;
            }
        }
        return false;
    }
}
