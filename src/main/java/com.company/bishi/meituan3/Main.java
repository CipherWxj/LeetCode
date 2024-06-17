package com.company.bishi.meituan3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] edge = new int[n];
        for (int i = 1; i < n; i++) {
            edge[i] = sc.nextInt();
        }
        sc.nextLine();
        String s = sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print(solution(edge, s)[i] + " ");
        }
    }

    public static int[] solution(int[] edge, String s) {
        int n = edge.length;
        int[] ans = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int root = i + 1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            queue.add(root);
            while (!queue.isEmpty()) {
                int a = queue.size();
                for (int j = 0; j < a; j++) {
                    int cur = queue.poll();
                    for (int k = 0; k < n; k++) {
                        if (edge[k] == cur) {
                            queue.add(k + 1);
                            set.add(s.charAt(k));
                        }
                    }
                }
            }
            ans[i] = set.size();
        }
        return ans;
    }
}

