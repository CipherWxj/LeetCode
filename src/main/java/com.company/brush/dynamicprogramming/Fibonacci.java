/**
 * @author: Wxj
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0, F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>输入描述:
 * n = 5
 * <p>输出描述:
 * 5
 */
package com.company.brush.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public int fib(int n) {
        // 特殊情况单独摘出来
        if (n == 0) return 0;
        if (n == 1) return 1;
        // 为了减小空间复杂度，只取前两个值
        // fn：F(N)，f1：F(N - 1)，f2：F(N - 2)
        int f1 = 1, f2 = 0, fn = 0;
        // 递推
        for (int i = 2; i <= n; i++) {
            fn = (f1 + f2) % 1000000007;
            // 更新f1：F(N - 1) 和 f2：F(N - 2)
            f2 = f1;
            f1 = fn;
        }
        return fn;
    }

    // 递归
    Map<Integer, Integer> map = new HashMap<>(); // <n, f(n)>

    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        map.put(0, 0);
        map.put(1, 1);
        return f(n);
    }
    // 记录，减少时间复杂度
    public int f(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int m = f(n - 1) + f(n - 2);
            map.put(n, m);
            return m;
        }
    }
}
