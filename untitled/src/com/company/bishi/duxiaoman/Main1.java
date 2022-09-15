package com.company.bishi.duxiaoman;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int l = s.length();
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < l; j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
            int min = list.get(0).getValue();
            int max = list.get(list.size() - 1).getValue();
            ans = Math.max(ans, max - min);
        }
        System.out.println(ans);
    }
}

