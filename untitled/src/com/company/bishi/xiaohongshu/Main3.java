package com.company.bishi.xiaohongshu;


import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 新员工数

        int[] friend = new int[n + 1]; // 员工关系
        for (int i = 2; i < n + 1; i++) {
            friend[i] = sc.nextInt();
        }
        int[] friendA = new int[n + 1];
        int[] friendB = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            friendA[friend[i]]++;
            friendA[i]++;
        }
        friendA[1]++;
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            int r = n;
            int l = 0;
            if (friendB[i] == 0) {
                for (int j = 1; j < n + 1; j++) {
                    if (friend[j] == i && friendB[j] == 0 && r > friendA[j]) {
                        r = friendA[j];
                        l = j;
                        ans++;
                        if (r == 2) {
                            j = n + 1;
                        }
                    }
                }
            }
            friendB[i] = 1;
            friendB[l] = 1;
            friendA[i]--;
            friendA[l]--;
        }
        System.out.println(ans);
    }
}
