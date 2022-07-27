/**
 * @author: Wxj
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n ）。
 * <p>输入描述:
 * x = 2.00000, n = 10
 * <p>输出描述:
 * 1024.00000
 */
package com.company.brush.math;

public class Pow {

    public double solution1(double x, int n) {
        return n > 0 ? myPow1(x, n) : 1.0 / myPow1(x, -n);
    }

    // 递归，分治
    public double myPow1(double x, int n) {
        if (n == 0) return 1.0;
        // 计算 n / 2 次
        double y = myPow1(x, n / 2);
        // n 为偶数：y * y
        // n 为偶数：y * y * x
        return x % 2 == 0 ? y * y : y * y * x;
    }

    // 迭代
    // 如果整数 nn 的二进制拆分为 n = 2^{i_0} + 2^{i_1} + …… + 2^{i_k}
    // 那么 x^n = x^{2^{i_0}} * x^{2^{i_1}} * …… * x^{2^{i_k}}
    // 这样以来，我们从 x 开始不断地进行平方，得到 x^2, x^4, x^8, x^16, ……
    // 如果 n 的第 k 个（从右往左，从 0 开始计数）二进制位为 1，那么我们就将对应的贡献权重计入答案。
    public double myPow2(double x, int n) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 n 进行二进制拆分的同时计算答案
        while (n > 0) {
            if (n % 2 == 1) {
                // 如果 n 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 n 二进制表示的最低位，左移找权重
            n /= 2;
        }
        return ans;
    }
}
