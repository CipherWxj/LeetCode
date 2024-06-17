package com.company.bishi.oukeyunlian;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            res.append(str[i]);
            res.append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        System.out.println(res.toString());
    }
}
