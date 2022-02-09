/**
 * @author: Wxj
 * # 取模数对
 * 在自然数序列 1~n 中任意选择两个不同的数 x 和 y ，求满足 x%y=k（%：取模）的（x，y）的对数；
 * （1≤t≤100，1<=n，k≤10^6)
 * <p>输入描述：
 * t=2
 * (n,k):5 2
 * 7 3
 * <p>输出描述：
 * 4
 * 5
 */
package com.company.brush.enumeration;

import java.util.Scanner;

public class ModNumberPair {

    public static int solution(int n, int k) {
        int count = 0;  //计数器

        for (int x = 1; x < n + 1; x++) {
            for (int y = 1; y < n + 1; y++) {
                if (x != y && x % y == k) {
                    count++; //x=!y且x%y=k，判断，成立时2计数器+1
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("t=");
        int t = sc.nextInt(); //输入第一行，t
        int[] ns = new int[t];
        int[] ks = new int[t];
        int[] res = new int[t]; //容器数组，n、k、result
        System.out.print("(n,k):");
        for (int i = 0; i < t; i++) {
            ns[i] = sc.nextInt(); //获取n
            ks[i] = sc.nextInt(); //获取k
            res[i] = (solution(ns[i], ks[i]));  //执行算法，返回结果
        }
        for (int i = 0; i < t; i++) {
            System.out.println(res[i]);  //分行显示结果
        }
    }
}
