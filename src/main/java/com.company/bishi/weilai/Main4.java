package com.company.bishi.weilai;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int score;
        for (int i = 0; i < t; i++) {
            score = sc.nextInt();
            System.out.println(solution(score));
        }

    }

    public static int solution(int score) {
        if (score < 10 && score% 2 != 0) {
            return 2;
        } else {
            return 1;
        }
    }
}
